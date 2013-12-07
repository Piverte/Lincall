package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Server {

	public static ServerSocket m_ss = null;
	public static Thread m_authentificator = null;
	private static transient Socket m_socket = null;
	private static Logger m_logger;
	private static int port;
	
	public static void main (String[] args){

		try{
			init();
			ManageProfile.init_list();
			ManageProfile.displayList();
			m_ss = new ServerSocket(port);
			m_authentificator = new Thread (new Authentificator(m_ss));
			m_authentificator.start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void init (){
	// LL la classe doit etre en static pour pouvoir etre lancer a partir du main.
		
		//Properties object declaration
		Properties prop = new Properties();
		
		try{
			//Loading of the File configServer.properties in the Properties object prop
			// LL Tu es sur des \\ ?
			prop.load(new FileInputStream("conf\\configServer.properties"));
			
			//Catch in port the value of the key port1
			port=Integer.parseInt(prop.getProperty("port1"));
			
			//Set the logLevel to the value of the log4jLevel cast in level type
			
			// LL on ferra 2 fichiers de conf pour en avoir un pour le serveur et un pour les logs
			//m_logger.setLevel(Level.toLevel(prop.getProperty("log4jLevel")));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
