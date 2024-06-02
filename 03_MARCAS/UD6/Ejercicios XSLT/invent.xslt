<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/inventario">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Nombre</th>
                        <th>Peso</th>
                        <th>Edificio</th>
                        <th>Aula</th>
                    </tr>
                    <xsl:apply-templates select="producto"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="producto">
        <tr>
            <td><xsl:value-of select="nombre"/></td>
            <td><xsl:value-of select="peso"/><xsl:value-of select="peso/@unidad"/></td>
            <td><xsl:value-of select="lugar/@edificio"/></td>
            <td><xsl:value-of select="lugar/aula"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>