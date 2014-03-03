package com.bitplan.selectparser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shapes")
public class Shapes {

	@XmlElement(name = "circle", type = CircleImpl.class)
	private List<Circle> circles = new ArrayList<Circle>();

	public Shapes() {
	}

	public Shapes(List<Circle> circles) {
		this.circles = circles;
	}

	public List<Circle> getCircles() {
		return circles;
	}

	public void setCircles(List<Circle> circles) {
		this.circles = circles;
	}
}
