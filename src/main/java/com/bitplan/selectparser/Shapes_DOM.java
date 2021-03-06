package com.bitplan.selectparser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

/**
 * DOM implementation of ShapesParser
 * @author wf
 *
 */
public class Shapes_DOM extends ParserPerformanceImpl implements ShapesParser {

	/**
	 * parse the xmlfile and return a list of shapes
	 */
	public List<Circle> parse(File xmlFile) throws Exception {
		this.testFile=xmlFile;
		start();
		List<Circle> result = new ArrayList<Circle>();
		// create a DOMParser
		DOMParser parser = new DOMParser();
		parser.parse(xmlFile.getAbsolutePath());

		// get the DOM Document object
		Document doc = parser.getDocument();

		// get all the circle nodes
		NodeList nodelist = doc.getElementsByTagName("circle");
	
		// retrieve all info about the circles
		for (int i = 0; i < nodelist.getLength(); i++) {

			// get one circle node
			Node node = nodelist.item(i);

			// get the color attribute
			NamedNodeMap attrs = node.getAttributes();
	
			Circle circle=new CircleImpl();
			result.add(circle);
			// get the child nodes of a circle node
			NodeList childnodelist = node.getChildNodes();

			// get the x and y value
			for (int j = 0; j < childnodelist.getLength(); j++) {
				Node childnode = childnodelist.item(j);
				Node textnode = childnode.getFirstChild();// the only text node
				String childnodename = childnode.getNodeName();
				if (childnodename.equals("x"))
					circle.setX(Integer.parseInt(textnode.getNodeValue().trim()));
				else if (childnodename.equals("y"))
					circle.setY(Integer.parseInt(textnode.getNodeValue().trim()));
				else if (childnodename.equals("radius"))
					circle.setR(Integer.parseInt(textnode.getNodeValue().trim()));
			}

		}
		stop();
		return result;
	}

	/**
	 * main routine
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File xmlFile = new File(args[0]);
		Shapes_DOM shapesDOM = new Shapes_DOM();
		try {
			List<Circle> shapes = shapesDOM.parse(xmlFile);
			int numberOfCircles = shapes.size();
			System.out.println("circles=" + numberOfCircles);
			/*for (Circle shape : shapes) {
             String line="";
             line=line+"(x="+x[i]+",y="+y[i]+",r="+r[i]+",color="+color[i]+")";
             System.out.println(line);

			} */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Shapes_DOM clone() {
		return new Shapes_DOM();
	}
}