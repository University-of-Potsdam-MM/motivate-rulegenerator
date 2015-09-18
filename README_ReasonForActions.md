# "Reason" für Aktionen von Nutzern

## Ablauf:

1. Der JSONService **/get-statistics** wird aufgerufen mit den Parametern: 
   - **ontologyABox**: enthält alle OWL-Individuen, also u.a. auch alle Actions und Kontextinformationen
   - **ontologyId**: derzeit beliebig
2. In der **StatisticsFactory** wird die Methode **generateStatistics()** für alle in dieser Klasse hinzugefügten Assemblies ausgeführt. 
Derzeit betrifft das nur die **CancelActionStatisticsAssembly**. 
3. Die Methode **generateStatistics()** gibt eine **StatisticsList** zurück: einen Wrapper für eine *List* von **Reason**.

## Jeder *Reason* umfasst folgende Felder: 
- **String action** : der IRI der Nutzeraktion 
- **RDFNode user** : der [RDFNode] des Nutzers
- **RDFNode actionTime** : der RDFNode des Zeitstempels der Aktion
- **RDFNode recordedTime** : der RDFNode des Zeitstempels einer gemessenen Kontextinformation
- **RDFNode recordedContextInformation** : der RDFNode dieser Kontextinformation
- **RDFNode learningUnit** : der RDFNode der Lerneinheit, mit der die Nutzeraktion ausgeführt, d.h. die z.B. abgebrochen oder gestartet wurde
- **RDFNode metaDataProperty** : der RDFNode der Data Property, die eine Subproperty von *hasMetaData* ist, also z.B. *hasContentType* oder *isScreenReaderSuitable* dieser Lerneinheit
- **RDFNode metaDataValue** : der RDFNode des dazugehörigen Werts, z.B. "Image" bzw. "true".

## Zugriff auf diese Informationen:

... erfolgt über Getter & Setter der Klasse **Reason**.

## SPARQL-Query für Informationsbeschaffung:

... findet sich in der Klasse **ActionStatisticsAssembly**, wo deren String-Repräsentation innerhalb der Methode **getQueryString()** initialisiert wird.



[RDFNode]:https://jena.apache.org/documentation/javadoc/jena/index.html?org/apache/jena/rdf/model/RDFNode.html
