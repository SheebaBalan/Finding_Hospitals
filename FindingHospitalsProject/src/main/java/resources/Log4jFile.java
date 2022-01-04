package resources;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jFile {
	
	//Logger class
	public static Logger logger=null;

	public static void log() {
		//Configuring the properties file
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void info(String message) {
		//Information class
		logger.info(message);
	}
	public static void error(String message) {
		//Error class
		logger.error(message);
	}

}
