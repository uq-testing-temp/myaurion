package util;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

public class DebugLog {
	

	public static Logger LogInfo=Logger.getLogger(Log.class.getName());
	
	
	
	public static void StartTest(String TestName){
		
		LogInfo.info("**********************Starting the test scenario***********************");
		LogInfo.info("******************************* Scenario: "+TestName+"*************************************");
	}
	
	
	
public static void EndTest(String TestName){
		
		LogInfo.info("**********************End of the test***********************");
		LogInfo.info("******************************* Scenario: "+TestName+"*************************************");
		
		
	}



public static void information(String message) {

	LogInfo.info(message);

	}

public static void warning(String message) {

LogInfo.warn(message);

}

public static void Error(String message) {

LogInfo.error(message);

}

public static void fatalError(String message) {

LogInfo.fatal(message);

}

public static void debugMsg(String message) {

LogInfo.debug(message);

}

	

}
