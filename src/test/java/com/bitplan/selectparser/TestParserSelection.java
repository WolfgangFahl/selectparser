package com.bitplan.selectparser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.bitplan.selectparser.Shapes_DOM;

public class TestParserSelection {

	@Test
	public void test() throws Exception {
		ShapesParser[] parsers = { new Shapes_DOM(), new Shapes_SAX(),
				new Shapes_JAXB() };
		int[] sizes = { 2,1000, 10000, 100000 };

		for (int size : sizes) {
			File xmlTestFile = new File("src/test/data/shapes" + size + ".xml");
			for (ShapesParser parser : parsers) {
				List<Circle> shapes = parser.parse(xmlTestFile);
				System.out.println("There are " + shapes.size() + " circles in "
						+ xmlTestFile.getName() + " when parsed with "
						+ parser.getClass().getSimpleName());
			}
		}
	}

}
