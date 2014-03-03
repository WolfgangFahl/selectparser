package com.bitplan.selectparser;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Shapes_JAXB implements ShapesParser {

	public List<Circle> parse(File xmlFile) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Shapes.class);
		Unmarshaller u = context.createUnmarshaller();
		Shapes shapes=(Shapes) u.unmarshal(xmlFile);
		return shapes.getCircles();
	}

}
