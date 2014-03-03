package com.bitplan.selectparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParserSelection {

	List<File> xmlTestFiles;

	/**
	 * Situation erstellen
	 */
	public void build_situtation() {
		// gewünschte Grössen
		int[] sizes = { 2, 1000, 10000, 100000 };
		xmlTestFiles = new ArrayList<File>();
		// für alle Größen existenz der Testdatei/Lesbarkeit prüfen
		for (int size : sizes) {
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
				new Shapes_JAXB() };
		for (File xmlTestFile : this.xmlTestFiles) {
			for (ShapesParser parser : parsers) {
				List<Circle> shapes = parser.parse(xmlTestFile);
				System.out.println("There are " + shapes.size() + " circles in "
						+ xmlTestFile.getName() + " when parsed with "
						+ parser.getClass().getSimpleName());
			}

		}

	}

	/**
	 * Ergebnis erstellen
	 */
	public void check_ExcpectedResult() {
	}

	@Test
	public void test() throws Exception {
		this.build_situtation();
		this.perform_action();
		this.check_ExcpectedResult();
	}

}
