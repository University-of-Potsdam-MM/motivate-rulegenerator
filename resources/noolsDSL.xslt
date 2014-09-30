<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://whatever"
	xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="text" encoding="UTF-8" indent="no" />

	<xsl:function name="foo:exploreFactSetElement">
		<xsl:param name="factSetElement" />
		<xsl:param name="contextInformation" />

		<xsl:variable name="currentElementName" select="name($factSetElement)" />
		<xsl:choose>
			<xsl:when test="$currentElementName = 'fact'">
				<xsl:variable name="alias"
					select="foo:getAliasForContextInformation($contextInformation, concat($factSetElement/contextInformation, $factSetElement/value))" />
				<xsl:text>(</xsl:text>
				<xsl:value-of select="$alias" />
				<xsl:text>.id == '</xsl:text>
				<xsl:value-of select="$factSetElement/contextInformation" />
				<xsl:text>'</xsl:text>
				<xsl:if test="count($factSetElement/factParameters/factParameter) > 0">
					<xsl:for-each select="$factSetElement/factParameters/factParameter">
						<xsl:text> &amp;&amp; </xsl:text>
						<xsl:value-of select="$alias" />
						<xsl:text>.parameters['</xsl:text>
						<xsl:value-of select="current()/contextInformation" />
						<xsl:text>'] == </xsl:text>
						<xsl:value-of select="current()/value" />
					</xsl:for-each>
				</xsl:if>
				<xsl:text> &amp;&amp; </xsl:text>
				<xsl:value-of select="$alias" />
				<xsl:text>.value</xsl:text>
				<xsl:choose>
					<xsl:when test="$factSetElement/operator = 'IS'">
						<xsl:text> == </xsl:text>
					</xsl:when>
					<xsl:when test="$factSetElement/operator = 'IS_NOT'">
						<xsl:text> != </xsl:text>
					</xsl:when>
					<xsl:when test="$factSetElement/operator = 'LESS_THEN'">
						<xsl:text> &lt; </xsl:text>
					</xsl:when>
					<xsl:when test="$factSetElement/operator = 'GREATER_THEN'">
						<xsl:text> &gt; </xsl:text>
					</xsl:when>
					<xsl:when test="$factSetElement/operator = 'NO_VALUE'">
						<xsl:text> == null</xsl:text>
					</xsl:when>
				</xsl:choose>
				<xsl:if test="$factSetElement/operator != 'NO_VALUE'">
					<xsl:value-of select="$factSetElement/value" />
				</xsl:if>
				<xsl:text>)</xsl:text>
			</xsl:when>
			<xsl:when test="$currentElementName = 'factSet'">
				<xsl:text>(</xsl:text>
				<xsl:for-each select="$factSetElement/*">
					<xsl:value-of
						select="foo:exploreFactSetElement(current(), $contextInformation)" />
				</xsl:for-each>
				<xsl:text>)</xsl:text>
			</xsl:when>
			<xsl:when test="$currentElementName = 'logicalOperator'">
				<xsl:choose>
					<xsl:when test="$factSetElement = 'AND'">
						<xsl:text> &amp;&amp; </xsl:text>
					</xsl:when>
					<xsl:when test="$factSetElement = 'OR'">
						<xsl:text> || </xsl:text>
					</xsl:when>
				</xsl:choose>
			</xsl:when>
		</xsl:choose>
	</xsl:function>

	<xsl:function name="foo:gatherAliases">
		<xsl:param name="facts" />
		<xsl:param name="factContextInformation" />
		<xsl:param name="index" />

		<xsl:variable name="alias" select="concat('c', $index)" />
		<xsl:variable name="newFactContextInformation"
			select="insert-before($factContextInformation, $index, concat($facts[$index]/contextInformation, $facts[$index]/value))" />

		<xsl:choose>
			<xsl:when test="$index &lt;= count($facts)">
				<xsl:sequence
					select="foo:gatherAliases($facts, $newFactContextInformation, $index + 1)" />
			</xsl:when>
			<xsl:otherwise>
				<xsl:for-each select="distinct-values($factContextInformation)">
					<xsl:sequence select="." />
				</xsl:for-each>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>

	<xsl:function name="foo:getAliasForContextInformation">
		<xsl:param name="contextInformationSequence" />
		<xsl:param name="contextInformation" />

		<xsl:sequence
			select="concat('c', index-of($contextInformationSequence, $contextInformation))" />
	</xsl:function>

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

		<xsl:for-each select="adaptationRules/adaptationRule">
			<xsl:text>rule "</xsl:text>
			<xsl:value-of select="id" />
			<xsl:text>" { &#xa;</xsl:text>
			<xsl:text>&#x9;when {&#xa;</xsl:text>
			<!-- Gather all facts -->
			<xsl:variable name="contextInformation"
				select="foo:gatherAliases(situation//fact, (), 1)" />
			<xsl:variable name="negation" select="current()/negation" />
			<xsl:for-each select="$contextInformation">
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
						<xsl:if test="$negation = 'true'">
							<xsl:text>not(</xsl:text>
						</xsl:if>
						<xsl:value-of select="concat('c', position())" />
						<xsl:text> : ContextInformation </xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:for-each>
			
			<!-- Phrase the rule -->
			
			<!-- Constraints -->
			<xsl:for-each select="situation/constraints/*">
				<xsl:value-of
					select="foo:exploreFactSetElement(current(), $contextInformation)" />
			</xsl:for-each>
			<xsl:if
				test="count(situation/constraints/*) > 0 and count(situation/userFacts/*) > 0">
				<xsl:text> &amp;&amp; </xsl:text>
			</xsl:if>
			<!-- User Facts -->
			<xsl:for-each select="situation/userFacts/*">
				<xsl:value-of
					select="foo:exploreFactSetElement(current(), $contextInformation)" />
			</xsl:for-each>
			<xsl:if test="current()/negation = 'true'">
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
					<xsl:text>");</xsl:text>
				</xsl:when>
				<xsl:when test="action/operator = 'PRELOAD'">
					<xsl:text>emit("preloadLearningUnit", "</xsl:text>
					<xsl:value-of select="action/learningUnitId" />
					<xsl:text>");</xsl:text>
				</xsl:when>
				<xsl:when test="action/operator = 'RESTRICT_FEATURE'">
					<xsl:text>emit("restrictFeature", "</xsl:text>
					<xsl:value-of select="action/learningUnitId" />
					<xsl:text>");</xsl:text>
				</xsl:when>
			</xsl:choose>
			<xsl:text>&#xa;</xsl:text>
			<xsl:text>&#x9;}&#xa;</xsl:text>
			<xsl:text>}</xsl:text>
			<xsl:text>&#xa;&#xa;</xsl:text>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>