package com.bitplan.selectparser;

import java.io.File;
import java.util.List;

public interface ShapesParser extends ParserPerformance,Cloneable {
	public List<Circle> parse(File xmlFile) throws Exception;

	public ShapesParser clone();
}
