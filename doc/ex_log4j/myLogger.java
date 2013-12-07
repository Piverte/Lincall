package loic_test;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class myLogger {

	private Logger log = null;

	public myLogger() {
		// TODO Auto-generated constructor stub
		initLogger();
	}

	private void initLogger() {

		log = Logger.getLogger(this.getClass().getName());
		if(log == null) {
			System.err.println("LOGGER ERROR");
		}
		else {
			PropertyConfigurator.configure(getClass().getResource("log4j.properties"));
			log.info("log4J launch");
		}
	}

	public Logger getLogger() {
		if(log == null) {
			initLogger();
		}
		return log;

	}
}
