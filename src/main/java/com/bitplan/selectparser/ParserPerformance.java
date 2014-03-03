package com.bitplan.selectparser;

import java.io.File;

public interface ParserPerformance {
	public long getSize();
	public File getTestFile();
	public long getMilliSeconds();

}
