package Client;

import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import Message.Message;

public class Emission implements Runnable{

	protected PrintWriter m_out;
	protected transient Socket m_socket;
	protected Message m_message;
	protected Logger m_logger;
	
	public Emission(PrintWriter out, Message message, Socket soc){
		this.m_out = out;
		this.m_message = message;
		this.m_socket = soc;
		
		m_logger = (new Client_Log4J()).getLogger();
		m_logger.info("Client.Emission message :"+m_message.toString());
	}
	
	public void run(){
		//checker le nom de la méthode de récupération du socket une fois qu'elle sera codée
		Socket currentSocket = m_socket;
		//checker la valeur d'un socket lorsqu'il n'a pas été construit
		if (currentSocket != null){
			this.m_out.println(m_message.toString());
		}
		else{
			System.out.println("Connection unavailable, please try to reconnect");
		}
		
	}
	
}
