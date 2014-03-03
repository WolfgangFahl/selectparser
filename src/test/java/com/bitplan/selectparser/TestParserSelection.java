package com.bitplan.selectparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParserSelection {
	
	List<File> xmlTestFiles;
	List<List<ParserPerformance>> testResult=new ArrayList<List<ParserPerformance>>();

	/**
	 * Situation erstellen
	 */
	public void build_situtation() {
		// gewünschte Grössen
		long[] sizes = { 2, 1000, 10000, 100000 };
		xmlTestFiles = new ArrayList<File>();
		// für alle Größen existenz der Testdatei/Lesbarkeit prüfen
		for (long size : sizes) {
			File xmlTestFile = new File("src/test/data/shapes" + size + ".xml");
			assertTrue(xmlTestFile.canRead());
			xmlTestFiles.add(xmlTestFile);
		}
	}

	/**
	 * Aktion durchführen
	 * @throws Exception 
	 */
	public void perform_action() throws Exception {
		ShapesParser[] parsers = { new Shapes_DOM(), new Shapes_SAX(),
				new Shapes_JAXB(), new Shapes_DOM(), new Shapes_SAX(),
				new Shapes_JAXB() };
		for (File xmlTestFile : this.xmlTestFiles) {
			List<ParserPerformance> fileResults=new ArrayList<ParserPerformance>();
			this.testResult.add(fileResults);
			for (ShapesParser parser : parsers) {
				ShapesParser testParser=parser.clone();
				List<Circle> shapes = testParser.parse(xmlTestFile);
				System.out.println("There are " + shapes.size() + " circles in "
						+ xmlTestFile.getName() + " when parsed with "
						+ parser.getClass().getSimpleName());
				fileResults.add(testParser);
			}

		}
	}

	/**
	 * Ergebnis erstellen
	 */
	public void check_ExcpectedResult() {
		for (	List<ParserPerformance> fileResults:this.testResult) {
			for (ParserPerformance performance:fileResults) {
				System.out.println(performance.getClass().getName()+" "+performance.getTestFile()+":"+performance.getSize()+"="+performance.getMilliSeconds());
			}
		}
	}

	@Test
	public void test() throws Exception {
		this.build_situtation();
		this.perform_action();
		this.check_ExcpectedResult();
	}

}
