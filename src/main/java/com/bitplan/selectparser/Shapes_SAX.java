package com.bitplan.selectparser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.xerces.parsers.SAXParser;

/**
 * Sax solution
 * 
 * @author wf
 * 
 */
public class Shapes_SAX extends DefaultHandler implements ShapesParser {

	private CircleImpl currentCircle;
	private List<Circle> currentResult;

	/**
	 * 
	 */
	public List<Circle> parse(File xmlFile) throws Exception {
		currentResult = new ArrayList<Circle>();
		SAXParser parser = new SAXParser(); // create a SAXParser object
		parser.setContentHandler(this); // register with the ContentHandler
		parser.parse(xmlFile.getAbsolutePath());
		return currentResult;
	}

	static int flagX = 0; // to remember what element has occurred
	static int flagY = 0; // to remember what element has occurred
	static int flagR = 0; // to remember what element has occurred

	// override the startElement() method
	public void startElement(String uri, String localName, String rawName,
			Attributes attributes) {
		currentCircle = new CircleImpl();
		if (rawName.equals("x")) // if a x element is seen set the flag as 1
			flagX = 1;
		else if (rawName.equals("y")) // if a y element is seen set the flag as 2
			flagY = 1;
		else if (rawName.equals("radius")) // if a radius element is seen set the
																				// flag as 3
			flagR = 1;
	}

	// override the endElement() method
	public void endElement(String uri, String localName, String rawName) {
		// in this example we do not need to do anything else here
		if (rawName.equals("circle")) { // if a circle element is ended
			currentResult.add(currentCircle); // add Circle
			currentCircle = null;
		}
	}

	// override the characters() method
	public void characters(char characters[], int start, int length) {
		String characterData = (new String(characters, start, length)).trim(); // get
																																						// the
																																						// text

		if (flagX == 1) { // indicate this text is for <x> element
			currentCircle.setX(Integer.parseInt(characterData));
			flagX = 0;
		} else if (flagY == 1) { // indicate this text is for <y> element
			currentCircle.setY(Integer.parseInt(characterData));
			flagY = 0;
		} else if (flagR == 1) { // indicate this text is for <radius> element
			currentCircle.setR(Integer.parseInt(characterData));
			flagR = 0;
		}
	}

	// override the endDocument() method
	public void endDocument() {
		// when the end of document is seen, just print the circle info
	}

	// main method
	public static void main(String[] args) {
		try {
			File xmlFile = new File(args[0]);
			Shapes_SAX shapesParser = new Shapes_SAX(); // an instance of this class
			shapesParser.parse(xmlFile);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} // catch exeptions
	}

}