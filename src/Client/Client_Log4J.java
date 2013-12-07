package Client;

import java.util.Properties;

import org.apache.log4j.Logger;
//pb import org.apache.log4j ...
import org.apache.log4j.PropertyConfigurator;

/**
 * This class can init the logger and return the logger
 * @author loic
 * @category Serveur
 * @category Log4J
 * 
 */

public class Client_Log4J
{
	private Logger m_logger = null;
	
	public Client_Log4J(){
		initLogger();
	}
	
	public Logger getLogger() 
	{
		if(m_logger == null)
		{
			initLogger();
		}
		return m_logger;
	}
	
	public void initLogger()
	{
		m_logger = Logger.getLogger(this.getClass().getName());
		if(m_logger == null) {
			System.err.println("LOGGER ERROR");
		}
		else {
			PropertyConfigurator.configure(getClass().getResource("conf/Client/log4j.properties"));
			m_logger.info("log4J launch");
		}
	}
}
