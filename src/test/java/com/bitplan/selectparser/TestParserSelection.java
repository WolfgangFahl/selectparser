package com.bitplan.selectparser;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.bitplan.selectparser.Shapes_DOM;

public class TestParserSelection {

	@Test
	public void test() throws Exception {
		ShapesParser[] parsers={new Shapes_DOM(),new Shapes_SAX()};
		
		File xmlTestFile=new File("src/test/data/shapes1.xml");
		for (ShapesParser parser:parsers) {
			List<Circle> shapes = parser.parse(xmlTestFile);
			System.out.println("There are "+shapes.size()+" circles in "+xmlTestFile.getName()+" when parsed with "+parser.getClass().getSimpleName());
		}
	}

}
