<xsl:stylesheet
        version="2.0"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:motivate="http://www.motivate-project.de/XSL"
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
        <!-- initially relationFacts or contextFacts, resp. -->
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
                <xsl:when test="$name = 'logicalOperator' and $situation = 'AND'">
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
        <xsl:if test="$name = 'factSet' or $name = 'relationFacts' or $name = 'contextFacts'">
            <xsl:text>(</xsl:text>
            <xsl:sequence select="motivate:generate($situation/*, $newqueue, $newId)" />
            <xsl:text>)</xsl:text>
        </xsl:if>

        <!-- Fact -->
        <xsl:if test="$name = 'fact'">
            <xsl:variable name="alias" select="concat('c', $index)" />
            <xsl:text>this.fulfils(</xsl:text>
            <xsl:text>_contactJS.ContextInformation.fromContextInformationDescription(_d, {name: "</xsl:text>
            <xsl:value-of select="$situation/contextInformation" />
            <xsl:text>", type: "</xsl:text>
            <xsl:value-of select="$situation/contextInformationType" />
            <xsl:text>", parameterList: [</xsl:text>
            <xsl:if test="count($situation/factParameters/factParameter) > 0">
                <xsl:for-each select="$situation/factParameters/factParameter">
                    <xsl:text>["</xsl:text>
                    <xsl:value-of select="current()/contextInformation" />
                    <xsl:text>", "</xsl:text>
                    <xsl:value-of select="current()/contextInformationType" />
                    <xsl:text>", "</xsl:text>
                    <xsl:value-of select="current()/value" />
                    <xsl:text>"]</xsl:text>
                    <xsl:if test="not(position() = last())">
                        <xsl:text>,</xsl:text>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:text>]}), "</xsl:text>
            <xsl:choose>
                <xsl:when test="$situation/operator = 'IS'">
                    <xsl:text>==</xsl:text>
                </xsl:when>
                <xsl:when test="$situation/operator = 'IS_NOT'">
                    <xsl:text>!=</xsl:text>
                </xsl:when>
                <xsl:when test="$situation/operator = 'LESS_THEN'">
                    <xsl:text>&lt;</xsl:text>
                </xsl:when>
                <xsl:when test="$situation/operator = 'GREATER_THEN'">
                    <xsl:text>&gt;</xsl:text>
                </xsl:when>
                <xsl:when test="$situation/operator = 'NO_VALUE'">
                    <xsl:text>==</xsl:text>
                </xsl:when>
                <xsl:when test="$situation/operator = 'CONTAINS'">
                    <xsl:text>contains</xsl:text>
                </xsl:when>
            </xsl:choose>
            <xsl:text>", "</xsl:text>
            <xsl:if test="$situation/operator != 'NO_VALUE'">
                <xsl:value-of select="$situation/value" />
            </xsl:if>
            <xsl:text>")</xsl:text>
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

    <!-- ****************** GENERATE DSL for rule constraints ****************** -->

    <xsl:function name="motivate:relatedContextInformation">

        <!-- function parameters: -->

        <!-- sequence of fact, logOp or factSet nodes -->
        <!-- initially relationFacts or contextFacts, resp. -->
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
                <xsl:when test="$name = 'logicalOperator' and $situation = 'AND'">
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
        <xsl:if test="$name = 'factSet' or $name = 'relationFacts' or $name = 'contextFacts'">
            <xsl:sequence select="motivate:relatedContextInformation($situation/*, $newqueue, $newId)" />
        </xsl:if>

        <!-- Fact -->
        <xsl:if test="$name = 'fact'">
            <xsl:variable name="alias" select="concat('c', $index)" />
            <xsl:text>_contactJS.ContextInformation.fromContextInformationDescription(_d, {name: "</xsl:text>
            <xsl:value-of select="$situation/contextInformation" />
            <xsl:text>", type: "</xsl:text>
            <xsl:value-of select="$situation/contextInformationType" />
            <xsl:text>", parameterList: [</xsl:text>
            <xsl:if test="count($situation/factParameters/factParameter) > 0">
                <xsl:for-each select="$situation/factParameters/factParameter">
                    <xsl:text>["</xsl:text>
                    <xsl:value-of select="current()/contextInformation" />
                    <xsl:text>", "</xsl:text>
                    <xsl:value-of select="current()/contextInformationType" />
                    <xsl:text>", "</xsl:text>
                    <xsl:value-of select="current()/value" />
                    <xsl:text>"]</xsl:text>
                    <xsl:if test="not(position() = last())">
                        <xsl:text>,</xsl:text>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:text>]}),&#xa;</xsl:text>
        </xsl:if>

        <!-- exit condition: queue of nodes is empty -->
        <xsl:if test="exists($situationseq)">
            <xsl:sequence select="motivate:relatedContextInformation($newsit, $newqueue, $newId)" />
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
                <xsl:when test="$name = 'logicalOperator' and $situation = 'AND'">
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
                test="$name = 'factSet' or $name = 'relationFacts' or $name = 'contextFacts'">
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

        <!-- Gather ContextInformation -->

        <!-- gather aliases for facts from relationFacts -->
        <xsl:variable
                name="constraintAliases"
                select="motivate:gatherAliases(situation/relationFacts, (), 1)" />

        <!-- of these, get highest ID and increment it by 1 (as the basis for contextFacts processing) -->
        <!-- if there are no relationFacts, this will be '1'  -->
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

        <!-- same procedure for user facts, starting with appropriate ID -->
        <xsl:variable
                name="contextFactsAliases"
                select="motivate:gatherAliases(situation/contextFacts, (), $max)" />

        <!-- lastly: get overall maximum value of all IDs -->
        <!-- this will be the number of the rule's ContextInformation facts -->
        <xsl:variable name="contextInformation">
            <xsl:choose>
                <xsl:when test="empty($contextFactsAliases)">
                    <xsl:value-of select="$max - 1" />
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="max($contextFactsAliases)" />
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>

        <xsl:text>&#x9;{&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;"id": "</xsl:text>
        <xsl:value-of select="id" />
        <xsl:text>",&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;"relatedContextInformation": [&#xa;</xsl:text>
        <xsl:if test="count(situation/relationFacts/*) > 0">
            <xsl:value-of select="motivate:relatedContextInformation(situation/relationFacts, (), 1)" />
        </xsl:if>
        <xsl:if test="count(situation/contextFacts/*) > 0">
            <xsl:value-of select="motivate:relatedContextInformation(situation/contextFacts, (), $max)" />
        </xsl:if>
        <xsl:text>],&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;"condition": function(R) {&#xa;</xsl:text>

        <xsl:text>&#x9;&#x9;&#x9;R.when(</xsl:text>

        <!-- Phrase the rule -->

        <!-- relationFacts -->
        <xsl:if test="count(situation/relationFacts/*) > 0">
            <xsl:value-of select="motivate:generate(situation/relationFacts, (), 1)" />
        </xsl:if>

        <xsl:if test="count(situation/relationFacts/*) > 0 and count(situation/contextFacts/*) > 0">
            <xsl:text> &amp;&amp; </xsl:text>
        </xsl:if>

        <!-- User Facts -->
        <xsl:if test="count(situation/contextFacts/*) > 0">
            <xsl:value-of select="motivate:generate(situation/contextFacts, (), $max)" />
        </xsl:if>


        <xsl:if test="count(situation/relationFacts/*) = 0 and count(situation/contextFacts/*) = 0">
            <xsl:text>true</xsl:text>
        </xsl:if>

        <xsl:text>);</xsl:text>

        <!-- Action -->
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;},&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;"consequence": function(R) {&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;</xsl:text>
        <xsl:choose>
            <xsl:when test="action/operator = 'SELECT'">
                <xsl:text>&#x9;if (typeof window["ruleEngine"]._callbacks["selectLearningUnitCallback"] != "undefined") {&#xa;</xsl:text>
                <xsl:text>&#x9;&#x9;window["ruleEngine"]._callbacks["selectLearningUnitCallback"]("</xsl:text>
                <xsl:value-of select="action/learningUnitId" />
                <xsl:text>", null);&#xa;</xsl:text>
                <xsl:text>&#x9;}&#xa;</xsl:text>
            </xsl:when>
            <xsl:when test="action/operator = 'PRELOAD'">
                <xsl:text>&#x9;if (typeof window["ruleEngine"]._callbacks["preloadLearningUnitCallback"] != "undefined") {&#xa;</xsl:text>
                <xsl:text>&#x9;&#x9;window["ruleEngine"]._callbacks["preloadLearningUnitCallback"]("</xsl:text>
                <xsl:value-of select="action/learningUnitId" />
                <xsl:text>", null);&#xa;</xsl:text>
                <xsl:text>&#x9;}&#xa;</xsl:text>
            </xsl:when>
            <xsl:when test="action/operator = 'RESTRICT_FEATURE'">
                <xsl:text>&#x9;if (typeof window["ruleEngine"]._callbacks["restrictFeatureCallback"] != "undefined") {&#xa;</xsl:text>
                <xsl:text>&#x9;&#x9;window["ruleEngine"]._callbacks["restrictFeatureCallback"]("</xsl:text>
                <xsl:value-of select="action/learningUnitId" />
                <xsl:text>", null);&#xa;</xsl:text>
                <xsl:text>&#x9;}&#xa;</xsl:text>
            </xsl:when>
        </xsl:choose>
        <xsl:text>&#x9;&#x9;&#x9;R.next();&#xa;</xsl:text>
        <xsl:text>&#x9;&#x9;}&#xa;</xsl:text>
        <xsl:text>&#x9;}</xsl:text>
        <xsl:choose>
            <xsl:when test="not(position() = last())">
                <xsl:text>,&#xa;</xsl:text>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>&#xa;];</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <!-- *********************** OVERALL TEMPLATE *********************** -->

    <xsl:template match="/">
        <xsl:text>var _contactJS = require("contactJS");&#xa;</xsl:text>
        <xsl:text>var _d = new _contactJS.Discoverer();&#xa;</xsl:text>
        <xsl:text>&#xa;</xsl:text>
        <xsl:text>var _rules = [&#xa;</xsl:text>

        <!-- apply matching adaptationRule template (defined above) -->
        <xsl:apply-templates />
    </xsl:template>

</xsl:stylesheet>
