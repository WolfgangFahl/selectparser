package com.bitplan.selectparser;

import java.io.File;

public class ParserPerformanceImpl implements ParserPerformance {

	int size;
	File testFile;
	long milliSeconds;
	
	private long startTime;
	/**
	 * @return the size
	 */
	public long getSize() {
		return testFile.length();
	}

	/**
	 * @return the testFile
	 */
	public File getTestFile() {
		return testFile;
	}
	/**
	 * @param testFile the testFile to set
	 */
	public void setTestFile(File testFile) {
		this.testFile = testFile;
	}
	
	/**
	 * @return the milliSeconds
	 */
	public long getMilliSeconds() {
		return milliSeconds;
	}
	/**
	 * @param milliSeconds the milliSeconds to set
	 */
	public void setMilliSeconds(int milliSeconds) {
		this.milliSeconds = milliSeconds;
	}

	public void start() {
		startTime=System.nanoTime();
	};
	public void stop() {
		milliSeconds=(System.nanoTime()-startTime)/(1000l*1000l);
	}


}
