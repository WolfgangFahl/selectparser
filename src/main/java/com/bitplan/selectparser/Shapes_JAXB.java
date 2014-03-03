package com.bitplan.selectparser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@SuppressWarnings("restriction")
public class Shapes_JAXB implements ShapesParser {

	public List<Circle> parse(File xmlFile) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Shapes.class);
		Unmarshaller u = context.createUnmarshaller();
		Shapes shapes = (Shapes) u.unmarshal(xmlFile);
		return shapes.getCircles();
	}

	public void toXML(Shapes shapes, File xmlFile) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(shapes.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		OutputStream os = new FileOutputStream(xmlFile);
		jaxbMarshaller.marshal(shapes, os);
	}
	
	/**
	 * create test files
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		int[] sizes={1000,10000,100000};
		Shapes_JAXB shapesJaxb = new Shapes_JAXB();
		for (int size:sizes) {
			File testfile=new File("src/test/data/shapes"+size+".xml");
			Shapes shapes=new Shapes();
			List<Circle> circles=new ArrayList<Circle>();
			for (int i=0;i<size;i++) {
				Circle circle=new CircleImpl();
				circle.setR((int) Math.round(Math.random()*100));
				circle.setX((int) Math.round(Math.random()*100));
				circle.setY((int) Math.round(Math.random()*100));
				circles.add(circle);
			}
			shapes.setCircles(circles);
			shapesJaxb.toXML(shapes, testfile);
		}
	}

}
