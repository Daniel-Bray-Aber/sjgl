package com.SJGL.debug;

public class Logger {

	private static Logger logger = null;
		
	private Logger() 
	{
		
	}
	
	public static Logger getLogger()
	{
		if(logger == null)
		{
			logger = new Logger();
		}
		return logger;
	}
	
	public void logWarning(String warning)
	{
		System.out.println("Warning: " + warning);
	}
	
	public void logError(String error)
	{
		System.out.println("Error: " + error);
	}


}
