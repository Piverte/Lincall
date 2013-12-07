package Client;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import javafx.stage.Stage;

public class Client {
	
	protected static transient Socket m_socket;
	protected static Thread m_Tconnection;
	protected static Stage m_window;
	protected String m_login;
	protected String m_password;
	protected String m_ipServer;
	protected int m_portServer;
	protected Connection m_connection;
	protected Logger m_logger;	

/**/
public Client(String login , String password, String ip, int port) {
		m_ipServer = ip;
		m_portServer = port;		
		m_login = login;
		m_password = password;
		
		m_logger = (new Client_Log4J()).getLogger();
		m_logger.info("Client.client : ip="+m_ipServer+" port="+m_portServer);
		
		try {
			//Open socket and thread
			m_socket = new Socket(m_ipServer,m_portServer);
			System.out.println(m_socket.getLocalPort()+" "+m_socket.getPort()+" "+m_socket.getInetAddress());
			//Call the connection constructor of Connection class to put on the connection in the thread m_connection 
			m_connection = new Connection(m_socket, m_login, m_password);
			System.out.println("Before thread Connection creation m_login:"+m_login+" m_password:"+m_password);
			m_Tconnection = new Thread(m_connection);
			m_Tconnection.start();
		
			//m_socket.close();	
			} 
		catch (IOException e) {
			e.printStackTrace();
			}
	}

	public Connection getM_connection() {
		return m_connection;
	}
}
