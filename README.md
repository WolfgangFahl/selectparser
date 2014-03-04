selectparser
============

Example to select a Java XML parser implementation based on criteria that are implemented as test cases

##Hintergrund / Background

* http://ak-traceab.gi.de/naechste-veranstaltung.html
```
Einladung zum nächsten Workshop dieses Arbeitskreises

"Entscheidungsfindung und Konsistenz bei Evolution von Systemen und Software"

Der nächste Workshop knüpft inhaltlich an den vorhergehenden Workshop "Konsistenz während Evolution" an. Zur Teilnahme sind alle Mitgleider des Arbeitskreises sowie alle weiteren Interessenten herzlich eingeladen. Der Workshop ist durch ein starkes Mass an Interaktion und wenig Formalismen gekennzeichnet. Die Teilnehmer sind eingeladen, ihre Position zu den Fragestellungen in einem kurzen Statement (5-10 Minuten) zu präsentieren, dies ist jedoch nicht Voraussetzung für eine Teilnahme. 

Zeit: 11. November 2013, 11:00 - 16:00 Uhr

Ort: Fraunhofer ISST, Campus Nord der TU Dortmund; Anfahrt hier

Ablauf:
- Eröffnung und kurze Vorstellung der Teilnehmer
- Vortrag "Einhaltung semantischer Konsistenz bei Evolution - Vorstellung aktueller Arbeiten" (Prof. Jürjens, TU Dortmund)
- Diskussion der Fragestellungen
- Abschluss: Zusammenfassung der Ergebnisse und Entscheidung über nächste Schritte

 

Themen und Fragestellungen:
- Wie können Constraints und Anforderungen formalisiert werden, um Werkzeugunterstützung für Entscheidungen zu ermöglichen
- Wie können Zusammenhänge zwischen verschiedenen Aspekten ausgedrückt werden, um modellübergreifende Abhängigkeiten auszuwerten
- Welche Abhängigkeiten sind bei evolutionärer Entwicklung im Software- und Systems-Engineering zu verfolgen
- Wie lässt sich die Konsistenz zwischen Designentscheidungen und Architektur aufrechterhalten
```

# Workshop 2014-03-03
## Teilnehmer
* Martin Rösch
* Wolfgang Fahl

## Ort/Zeit
BITPlan GmbH, Willich
2014-03-03 10:00 - 16:30 Uhr

## Aufgabe/Ziele/Vorgehen klären 
### Aufgabe
Objektivieren einer Architekturentscheidung anhand messbarer Kriterien für Architekturanforderungen 
(Messbarkeit heisst hier, dass die Kriterien als Testfälle ausführbar gemacht werden)

### Ziele
* Spezifizieren der Anforderungen
* Spezifizieren der Kriterien für jede Anforderung
* Kriterien als ausführbare Tests bereitstellen
* Prüfen mehrerer Implementierungen, deren fachliche Richtigkeit angenommen wird mit Hilfe der Tests
* Auswahl einer Alternative anhand der Testergebnisse
* Praktisches Java Beispiel für die obige Ziele mit Auslieferung in drei Teilen:
1. JAR für Interfaces 
2. JAR(s) für Implementierungen
3. JAR für Tests
plus Infrastruktur

### Vorgehen 
#### Beispiel: JAXP
Als Beispiel soll die Entscheidung/Auswahl einer Java XML Parser Implementierung dienen.

Prinzipiell haben JSRs bereits die dreiteilige Auslieferungsstruktur mit Trennung in Interfaces, Implementierung und Test.
Sowird z.B. die JSR 206 Implementierung Xerces als
* xml-apis.jar für die Interfaces
* xercesimpl.jar für die Implementierung
* und als TCK (http://en.wikipedia.org/wiki/Technology_Compatibility_Kit) für den Test 
bereitgestellt.
Unglücklicherweise sind die TCK Quellen dabei nicht öffentlich.

Details zum JSR 206:
* https://www.jcp.org/en/jsr/detail?id=206
* https://jaxp.java.net/1.4/JAXP-FAQ.html

Es gibt mehrere Implementierungen
* Reference Implementierung in Java SE 1.5 enthalten siehe oben JSR 206 Link
* Xerces.jar
* Saxon.jar

# Analyse
* http://en.wikipedia.org/wiki/Technology_Compatibility_Kit
* https://blogs.apache.org/foundation/entry/the_asf_s_position_on
DOM vs. SAX:
* http://www.cs.nmsu.edu/~epontell/courses/XML/material/xmlparsers.html#shapes_DOM

es zeigt sich, dass der Vergleich von DOM und SAX wie im obigen Beispiel geeigneter ist, als der direkte Vergleich von Xerces und Saxon.

# Umsetzung des obigen Vorgehens
Arbeitsname: selectparser

## Infrastruktur
Veröffentlichung der Ergebnisse hier auf Github:
<pre>
git clone https://github.com/WolfgangFahl/selectparser
</pre>

## Spezifizieren der Anforderungen
Es wird eine Beispielanforderung spezifiziert:
### Anforderung
Zu einer Liste von shapes die aus circles bestehen sollen Berechnungen durchgeführt  werden (z.b. Summe alle Flächen). Dazu müssen
die Shapes aus einer XML-Datei eingelesen werden. Dies soll möglichst schnell geschehen. Die beste Implementierung soll gewählt werden.
 
Beispiel für eine Input-Datei:
```
<shapes> 
          <circle color="BLUE"> 
                <x>20</x>
                <y>20</y>
                <radius>20</radius> 
          </circle>
          <circle color="RED" >
                <x>40</x>
                <y>40</y>
                <radius>20</radius> 
          </circle>
</shapes> 
```
## Spezifizieren der Kriterien für jede Anforderung
Es wird ein Beispielkriterium spezifiziert:
### Kriterium 
* Situation: Es liegt Shape-Dateien mit 2,1000,10000 und 100000 Shapes vor.
* Aktion: Die Dateien werd mit den XML-Parserimplementierungen SAX, DOM und JAXB als Objektstruktur eingelesen. 
* Erwartetes Ergebnis: Die Verarbeitung dauert unterschiedliche Lange. Die Implementierung werden nach Schnelligkeit sortiert angezeigt.

## Kriterien als ausführbare Tests bereitstellen
Das hier eingestellte Java Projekt ist als Eclipse-Projekt ausführbar.
Das oben aufgestellte Kriterium ist als JUnit Test in TestParserSelection.java umgesetzt.
Dieser Test kann in Eclipse oder mit
```
mvn test
```
ausgeführt werden.

