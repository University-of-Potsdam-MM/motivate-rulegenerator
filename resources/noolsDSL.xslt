<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="text" encoding="UTF-8" indent="no" />

	<xsl:template match="/">
		<xsl:for-each select="adaptationRules/adaptationRule">
			<xsl:text>rule <xsl:value-of select="id" /></xsl:text>
			<xsl:text> { </xsl:text>
			<xsl:if test="situation/logicalOperator = 'OR'">
				<xsl:text>or (</xsl:text>
			</xsl:if>
			<xsl:for-each select="situation/facts">
				<xsl:variable name="alias" select="concat('c', position())" />
				<xsl:value-of select="$alias" />
				<xsl:text> ContextInformation : </xsl:text>
				<xsl:value-of select="$alias" />
				<xsl:text>.id = </xsl:text>
				<xsl:value-of select="contextInformation" />
				<xsl:text> and </xsl:text>
				<xsl:value-of select="$alias" /><xsl:text>.value </xsl:text>
				<xsl:choose>
					<xsl:when test="operator = 'IS'">
						<xsl:text>=</xsl:text>
					</xsl:when>
					<xsl:when test="operator = 'IS_NOT'">
						<xsl:text>!=</xsl:text>
					</xsl:when>
					<xsl:when test="operator = 'LESS_THEN'">
						<xsl:text>&lt;</xsl:text>
					</xsl:when>
					<xsl:when test="operator = 'GREATER_THEN'">
						<xsl:text>&gt;</xsl:text>
					</xsl:when>
				</xsl:choose>
				<xsl:text> </xsl:text>
				<xsl:value-of select="value" />
				<xsl:choose>
					<xsl:when test="../logicalOperator = 'OR' and following-sibling::facts">
						<xsl:text>, </xsl:text>
					</xsl:when>
					<xsl:when
						test="../logicalOperator = 'OR' and not(following-sibling::facts)">
						<xsl:text>) </xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>; </xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:for-each>
			<xsl:text>} then { </xsl:text>
			<xsl:text>here be JavaScript</xsl:text>
			<xsl:text> } </xsl:text>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>