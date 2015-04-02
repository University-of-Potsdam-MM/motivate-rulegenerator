<xsl:stylesheet
	version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:motivate="http://www.motivate-project.de/"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output
		method="text"
		encoding="UTF-8"
		indent="no" />



	<!-- ****************** GENERATE DSL for rule constraints ****************** -->
	
	<xsl:function name="motivate:generate">
	
		<!-- function parameters: -->
	
		<!-- sequence of fact, logOp or factSet nodes -->
		<!-- initially constraints or userFacts, resp. -->
		<xsl:param
			name="situationseq"
			as="node()*" /> 
			
		<!-- queue for collecting fact IDs, initially empty -->
		<xsl:param
			name="queue"
			as="item()*" />
			
		<!-- current fact's ID -->
		<xsl:param name="index" />
		
		
		<!-- local variables -->
		
		<!-- first node of input sequence -->
		<xsl:variable
			name="situation"
			as="node()*"
			select="($situationseq)[1]" />
			
		<!-- name of that node -->
		<xsl:variable
			name="name"
			select="name($situation)" />
			
		<!-- queue gets extended by current fact's ID if current node is a fact -->
		<xsl:variable
			name="newqueue"
			as="item()*">
			<xsl:choose>
				<xsl:when test="$name = 'fact'">
					<xsl:sequence select="insert-before($queue, 0, $index)" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:sequence select="$queue" />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		
		<!-- next fact's ID gets incremented if it's preceded by 'AND' -->
		<xsl:variable name="newId">
			<xsl:choose>
				<xsl:when test="$name = 'logicalOperator' and $situation='AND'">
					<xsl:value-of select="$index+1" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$index" />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		
		<!-- rest of input sequence for next recursion step -->
		<xsl:variable
			name="newsit"
			as="node()*"
			select="remove($situationseq, 1)" />
			
		<!-- end of declaration part -->
			

		<!-- generate code for subnodes (this applies to root node and factSets) -->
		<xsl:if
			test="$name = 'factSet' or $name = 'constraints' or $name = 'userFacts'">
			<xsl:text>(</xsl:text>
			<xsl:sequence select="motivate:generate($situation/*, $newqueue, $newId)" />
			<xsl:text>)</xsl:text>
		</xsl:if>

		<!-- Fact -->
		<xsl:if test="$name = 'fact'">
			<xsl:variable
				name="alias"
				select="concat('c', $index)" />
			<xsl:text>(</xsl:text>
			<xsl:value-of select="$alias" />
			<xsl:text>.id == '</xsl:text>
			<xsl:value-of select="$situation/contextInformation" />
			<xsl:text>'</xsl:text>
			<xsl:if test="count($situation/factParameters/factParameter) > 0">
				<xsl:for-each select="$situation/factParameters/factParameter">
					<xsl:text> &amp;&amp; </xsl:text>
					<xsl:value-of select="$alias" />
					<xsl:text>.parameters['</xsl:text>
					<xsl:value-of select="current()/contextInformation" />
					<xsl:text>'] == </xsl:text>
					<xsl:text>'</xsl:text>
					<xsl:value-of select="current()/value" />
					<xsl:text>'</xsl:text>
				</xsl:for-each>
			</xsl:if>
			<xsl:text> &amp;&amp; </xsl:text>
			<xsl:value-of select="$alias" />
			<xsl:text>.value</xsl:text>
			<xsl:choose>
				<xsl:when test="$situation/operator = 'IS'">
					<xsl:text> == </xsl:text>
				</xsl:when>
				<xsl:when test="$situation/operator = 'IS_NOT'">
					<xsl:text> != </xsl:text>
				</xsl:when>
				<xsl:when test="$situation/operator = 'LESS_THEN'">
					<xsl:text> &lt; </xsl:text>
				</xsl:when>
				<xsl:when test="$situation/operator = 'GREATER_THEN'">
					<xsl:text> &gt; </xsl:text>
				</xsl:when>
				<xsl:when test="$situation/operator = 'NO_VALUE'">
					<xsl:text> == null</xsl:text>
				</xsl:when>
			</xsl:choose>
			<xsl:if test="$situation/operator != 'NO_VALUE'">
				<xsl:text>'</xsl:text>
				<xsl:value-of select="$situation/value" />
				<xsl:text>'</xsl:text>
			</xsl:if>
			<xsl:text>)</xsl:text>
		</xsl:if>

		<!-- Logical Operator -->
		<xsl:if test="$name = 'logicalOperator'">
			<xsl:choose>
				<xsl:when test="$situation = 'AND'">
					<xsl:text> &amp;&amp; </xsl:text>
				</xsl:when>
				<xsl:when test="$situation = 'OR'">
					<xsl:text> || </xsl:text>
				</xsl:when>
			</xsl:choose>
		</xsl:if>

		<!-- exit condition: queue of nodes is empty -->
		<xsl:if test="exists($situationseq)">
			<xsl:sequence select="motivate:generate($newsit, $newqueue, $newId)" />
		</xsl:if>
		
	</xsl:function>
	<!-- END GENERATE -->




	<!-- *************** Get a queue of all fact aliases in order of their processing *************** -->
	
	<xsl:function name="motivate:gatherAliases">
	
		<!-- same as in GENERATE (see above) only no code is being output -->
		<!-- this redundancy is due to all aliases being needed *before* code generation -->
		
		<xsl:param
			name="situationseq"
			as="node()*" /> 
		<xsl:param
			name="queue"
			as="item()*" />
		<xsl:param name="index" />

		<!-- prepare variables for next recursion -->
		<xsl:variable
			name="situation"
			as="node()*"
			select="($situationseq)[1]" />
		<xsl:variable
			name="name"
			select="name($situation)" />
		<xsl:variable
			name="newqueue"
			as="item()*">
			<xsl:choose>
				<xsl:when test="$name = 'fact'">
					<xsl:sequence select="insert-before($queue, 0, $index)" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:sequence select="$queue" />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="newId">
			<xsl:choose>
				<xsl:when test="$name = 'logicalOperator' and $situation='AND'">
					<xsl:value-of select="$index+1" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$index" />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable
			name="newsit"
			as="node()*"
			select="remove($situationseq, 1)" />

		<!-- extra recursion of subnodes -->
		<xsl:if
			test="$name = 'factSet' or $name = 'constraints' or $name = 'userFacts'">
			<xsl:sequence
				select="motivate:gatherAliases($situation/*, $newqueue, $newId)" />
		</xsl:if>
		<!-- exit condition and default -->
		<xsl:choose>
			<xsl:when test="empty($situationseq)">
				<xsl:sequence select="$queue" />
			</xsl:when>
			<xsl:otherwise>
				<xsl:sequence select="motivate:gatherAliases($newsit, $newqueue, $newId)" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>
	<!-- END GATHER ALIASES -->
	
	

	<!-- *********************** ADAPTATION RULE TEMPLATE *********************** -->

	<xsl:template match="adaptationRule">
		<xsl:text>rule "</xsl:text>
		<xsl:value-of select="id" />
		<xsl:text>" { &#xa;</xsl:text>
		<xsl:text>&#x9;when {&#xa;</xsl:text>

	
		<!-- Gather ContextInformation -->
	
		<!-- gather aliases for facts from constraints -->
		<xsl:variable
			name="constraintAliases"
			select="motivate:gatherAliases(situation/constraints, (), 1)" />
			
		<!-- of these, get highest ID and increment it by 1 (as the basis for userFacts processing) -->
		<!-- if there are no constraints, this will be '1'  -->
		<xsl:variable name="max">
			<xsl:choose>
				<xsl:when test="empty($constraintAliases)">
					<xsl:value-of select="1" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="max($constraintAliases) + 1" />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		
		<!-- same procedure for user facts, starting with apropriate ID -->
		<xsl:variable
			name="userFactsAliases"
			select="motivate:gatherAliases(situation/userFacts, (), $max)" />
		
		<!-- lastly: get overall maximum value of all IDs -->
		<!-- this will be the number of the rule's ContextInformation facts -->
		<xsl:variable name="contextInformation">
			<xsl:choose>
				<xsl:when test="empty($userFactsAliases)">
					<xsl:value-of select="$max - 1" />
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="max($userFactsAliases)" />
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>

		<!-- just a precaution -->
		<xsl:if test="$contextInformation > 0">
		
			<!-- enumerate all ContextInformation referenced in constraint -->
			<xsl:for-each select="1 to $contextInformation">
				<xsl:text>&#x9;&#x9;</xsl:text>
				<xsl:choose>
					<!-- List ContextInformation -->
					<xsl:when test="not(position() = last())">
						<xsl:value-of select="concat('c', position())" />
						<xsl:text> : ContextInformation;&#xa;</xsl:text>
					</xsl:when>
					<!-- Last ContextInformation and Constraints -->
					<xsl:otherwise>
						<!-- Negation -->
						<xsl:if test="negation = 'true'">
							<xsl:text>not(</xsl:text>
						</xsl:if>
						<xsl:value-of select="concat('c', position())" />
						<xsl:text> : ContextInformation </xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:for-each>
		</xsl:if>


		<!-- Phrase the rule -->

		<!-- Constraints -->
		<xsl:if test="count(situation/constraints/*) > 0">
			<xsl:value-of select="motivate:generate(situation/constraints, (), 1)" />
		</xsl:if>

		<xsl:if
			test="count(situation/constraints/*) > 0 and count(situation/userFacts/*) > 0">
			<xsl:text> &amp;&amp; </xsl:text>
		</xsl:if>

		<!-- User Facts -->
		<xsl:if test="count(situation/userFacts/*) > 0">
			<xsl:value-of select="motivate:generate(situation/userFacts, (), $max)" />
		</xsl:if>

		<!-- Negation -->
		<xsl:if test="negation = 'true'">
			<xsl:text>)</xsl:text>
		</xsl:if>
		<xsl:text>;</xsl:text>

		<!-- Action -->
		<xsl:text>&#xa;</xsl:text>
		<xsl:text>&#x9;} then {&#xa;</xsl:text>
		<xsl:text>&#x9;&#x9;</xsl:text>
		<xsl:choose>
			<xsl:when test="action/operator = 'SELECT'">
				<xsl:text>emit("selectLearningUnit", "</xsl:text>
				<xsl:value-of select="action/learningUnitId" />
				<xsl:text>", facts);</xsl:text>
			</xsl:when>
			<xsl:when test="action/operator = 'PRELOAD'">
				<xsl:text>emit("preloadLearningUnit", "</xsl:text>
				<xsl:value-of select="action/learningUnitId" />
				<xsl:text>", facts);</xsl:text>
			</xsl:when>
			<xsl:when test="action/operator = 'RESTRICT_FEATURE'">
				<xsl:text>emit("restrictFeature", "</xsl:text>
				<xsl:value-of select="action/learningUnitId" />
				<xsl:text>", facts);</xsl:text>
			</xsl:when>
		</xsl:choose>
		<xsl:text>&#xa;</xsl:text>
		<xsl:text>&#x9;}&#xa;</xsl:text>
		<xsl:text>}</xsl:text>
		<xsl:text>&#xa;&#xa;</xsl:text>
	</xsl:template>


	<!-- *********************** OVERALL TEMPLATE *********************** -->

	<xsl:template match="/">
		<xsl:text>define ContextInformation {&#xa;</xsl:text>
		<xsl:text>&#x9;id : '',&#xa;</xsl:text>
		<xsl:text>&#x9;value : 'NO_VALUE',&#xa;</xsl:text>
		<xsl:text>&#x9;parameters : { },&#xa;</xsl:text>
		<xsl:text>&#x9;constructor : function(id, value, parameters) {&#xa;</xsl:text>
		<xsl:text>&#x9;&#x9;this.id = id;&#xa;</xsl:text>
		<xsl:text>&#x9;&#x9;this.value = value;&#xa;</xsl:text>
		<xsl:text>&#x9;&#x9;this.parameters = parameters;&#xa;</xsl:text>
		<xsl:text>&#x9;}&#xa;</xsl:text>
		<xsl:text>}</xsl:text>
		<xsl:text>&#xa;&#xa;</xsl:text>

		<!-- apply matching adaptationRule template (defined above) -->
		<xsl:apply-templates />
	</xsl:template>
</xsl:stylesheet>
