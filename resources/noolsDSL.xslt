<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://whatever"
	xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="text" encoding="UTF-8" indent="no" />

	<xsl:variable name="factAliases" />
	<xsl:variable name="aliasContextInformation" />

	<xsl:function name="foo:exploreFactSetElement">
		<xsl:param name="factSetElement" />
		<xsl:param name="facts" />
		<xsl:variable name="currentElementName" select="name($factSetElement)" />
		<xsl:choose>
			<xsl:when test="$currentElementName = 'fact'">
				<xsl:variable name="i" select="index-of($facts, $factSetElement)" />
				<xsl:variable name="alias" select="concat('c', $i)" />
				<xsl:text>(</xsl:text>
				<xsl:value-of select="$alias" />
				<xsl:text>.id = </xsl:text>
				<xsl:value-of select="$factSetElement/contextInformation" />
				<xsl:text> &amp;&amp; </xsl:text>
				<xsl:value-of select="$alias" />
				<xsl:text>.value</xsl:text>
				<xsl:choose>
					<xsl:when test="$factSetElement/operator = 'IS'">
						<xsl:text> = </xsl:text>
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
						<xsl:text> = null</xsl:text>
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
					<xsl:value-of select="foo:exploreFactSetElement(current(), $facts)" />
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
		<xsl:param name="factAliases" />
		<xsl:param name="factContextInformation" />
		<xsl:param name="index" />

		<xsl:variable name="alias" select="concat('c', $index)" />
		<xsl:variable name="newFactAliases"
			select="insert-before($factAliases, $index, concat('c', $index))" />
		<xsl:variable name="newFactContextInformation"
			select="insert-before($factContextInformation, $index, $facts[$index]/contextInformation)" />

		<xsl:choose>
			<xsl:when test="$index &lt;= count($facts)">
				<xsl:value-of
					select="foo:gatherAliases($facts, $newFactAliases, $newFactContextInformation, $index + 1)" />
			</xsl:when>
			<xsl:otherwise>
				<xsl:for-each select="distinct-values($factContextInformation)">
					<xsl:sequence select="." />
				</xsl:for-each>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:function>

	<xsl:template match="/">
		<xsl:for-each select="adaptationRules/adaptationRule">
			<xsl:text>rule </xsl:text>
			<xsl:value-of select="id" />
			<xsl:text> { </xsl:text>
			<!-- Gather all facts -->
			<xsl:variable name="contextInformation" select="foo:gatherAliases(situation//fact, (), (), 1)" />
			<xsl:value-of select="$contextInformation" />
			<xsl:for-each select="$contextInformation">
				<xsl:value-of select="concat('c', position())" />
				<xsl:text> ContextInformation; </xsl:text>
			</xsl:for-each>
			<!-- Phrase the rule -->
			<!-- Constraints -->
			<xsl:for-each select="situation/constraints/*">
				<xsl:value-of
					select="foo:exploreFactSetElement(current(), situation/constraints//fact)" />
			</xsl:for-each>
			<xsl:if
				test="count(situation/constraints/*) > 0 and count(situation/userFacts/*) > 0">
				<xsl:text> &amp;&amp; </xsl:text>
			</xsl:if>
			<!-- User Facts -->
			<xsl:for-each select="situation/userFacts/*">
				<xsl:value-of
					select="foo:exploreFactSetElement(current(), situation/userFacts//fact)" />
			</xsl:for-each>
			<xsl:text>;</xsl:text>
			<!-- Action -->
			<xsl:text> } then { </xsl:text>
			<xsl:choose>
				<xsl:when test="action/operator = 'SELECT'">
					<xsl:text>select(</xsl:text>
					<xsl:value-of select="action/learningUnitId" />
					<xsl:text>);</xsl:text>
				</xsl:when>
				<xsl:when test="action/operator = 'PRELOAD'">
					<xsl:text>preload(</xsl:text>
					<xsl:value-of select="action/learningUnitId" />
					<xsl:text>);</xsl:text>
				</xsl:when>
			</xsl:choose>
			<xsl:text> } </xsl:text>

			<!-- <xsl:for-each select="situation//fact"> <xsl:variable name="alias" 
				select="concat('c', position())" /> <xsl:value-of select="$alias" /> <xsl:text> 
				ContextInformation : </xsl:text> <xsl:value-of select="$alias" /> <xsl:text>.id 
				= </xsl:text> <xsl:value-of select="contextInformation" /> <xsl:text> and 
				</xsl:text> <xsl:value-of select="$alias" /><xsl:text>.value </xsl:text> 
				<xsl:choose> <xsl:when test="operator = 'IS'"> <xsl:text>=</xsl:text> </xsl:when> 
				<xsl:when test="operator = 'IS_NOT'"> <xsl:text>!=</xsl:text> </xsl:when> 
				<xsl:when test="operator = 'LESS_THEN'"> <xsl:text>&lt;</xsl:text> </xsl:when> 
				<xsl:when test="operator = 'GREATER_THEN'"> <xsl:text>&gt;</xsl:text> </xsl:when> 
				</xsl:choose> <xsl:text> </xsl:text> <xsl:value-of select="value" /> <xsl:choose> 
				<xsl:when test="../logicalOperator = 'OR' and following-sibling::fact"> <xsl:text>, 
				</xsl:text> </xsl:when> <xsl:when test="../logicalOperator = 'OR' and not(following-sibling::fact)"> 
				<xsl:text>) </xsl:text> </xsl:when> <xsl:otherwise> <xsl:text>; </xsl:text> 
				</xsl:otherwise> </xsl:choose> </xsl:for-each> <xsl:text>} then { </xsl:text> 
				<xsl:text>here be JavaScript</xsl:text> <xsl:text> } </xsl:text> -->
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>