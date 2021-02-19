package com.revature.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J2 {
	public static final Logger LOGGER = LogManager.getLogger(Log4J2.class.getName());
	
	public static void info(String statement) {
		LOGGER.info(statement);
	}
	public static void error(String statement) {
		LOGGER.error(statement);
	}
	public static void debug(String statement) {
		LOGGER.debug(statement);
	}
	public static void warn(String statement) {
		LOGGER.warn(statement);
	}
	
}
