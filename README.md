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


## Aufgabe/Ziele/Vorgehen klären 
### Aufgabe ###
Objektivieren einer Architekturentscheidung anhand messbarer Kriterien für Architekturanforderungen 
(Messbarkeit heisst hier, dass die Kriterien als Testfälle ausführbar gemacht werden)

### Ziele ###
* Spezifizieren der Anforderungen
* Spezifizieren der Kriterien für jede Anforderung
* Kriterien als ausführbare Tests bereitstellen
* Prüfen mehrerer Implementierungen, deren fachliche Richtigkeit angenommen wird mit Hilfe der Tests
* Auswahl einer Alternative anhand der Testergebnisse
* Praktisches Java Beispiel für die obige Ziele mit Auslieferung in drei Teilen:
** JAR für Interfaces 
** JAR(s) für Implementierungen
** JAR für Tests
plus Infrastruktur
