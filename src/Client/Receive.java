package Client;

import java.io.IOException;
import java.io.BufferedReader;
import java.net.Socket;

import org.apache.log4j.Logger;

import Message.Message;
import Message.MessageAuthentification;
import Message.MessageChangeStatut;
import Message.MessageConnection;
import Message.MessageCreateProfile;
import Message.MessageDeleteProfile;
import Message.MessageEditLogin;
import Message.MessageEditPassword;
import Message.MessagePrivate;
import Message.MessagePrivateList;
import Message.MessagePublic;
import Message.MessagePublicList;
import Server.Emission;

public class Receive implements Runnable{
	protected BufferedReader m_in;
	protected Socket m_socket;
	protected Message m_message;
	protected Logger m_logger;

	public Receive(Socket soc){
		m_socket = soc;
		m_logger = (new Client_Log4J()).getLogger();
		m_logger.info("Client.Receive ip server ="	+ m_socket.getInetAddress()
											+ " ip client ="+m_socket.getLocalAddress()
											+" port client ="+m_socket.getLocalPort()
											+" port server ="+m_socket.getPort());
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				String s= m_in.readLine();
				Message messageReceived = new Message(s);
				//Switch case sur msg
				switch (messageReceived.getId()) {
				case 1:	
					//KeepAlive msgKeepAlive = new KeepAlive(messageReceived);						
					break;
				case 2:
					Message msgMessage = new Message(s);
					break;
				case 3:	
					MessageAuthentification msgMessageAuthentification = new MessageAuthentification(s);
					break;
				case 4:
					MessageChangeStatut msgMessageChangeStatut = new MessageChangeStatut(s);
					break;
				case 5:
					MessageConnection msgMessageConnection = new MessageConnection(s);
					break;
				case 6:
					MessageCreateProfile msgMessageCreateProfile = new MessageCreateProfile(s); 
					break;
				case 7:
					MessageDeleteProfile msgMessageDeleteProfile = new MessageDeleteProfile(s);
					break;
				case 8:
					MessageEditLogin msgMessageEditLogin = new MessageEditLogin(s);
					break;
				case 9:
					MessageEditPassword msgMessageEditPassword = new MessageEditPassword(s);
					break;
				case 10:
					MessagePrivate msgMessagePrivate = new MessagePrivate(s);
					break;
				case 11:
					//MessagePrivateList msgMessagePrivateList = new MessagePrivateList(s);
					break;
				case 12:
					MessagePublic msgMessagePublic = new MessagePublic(s);
					break;
				case 13:
					//MessagePublicList msgMessagePublicList = new MessagePublicList(s);
					break;
				}
				m_logger.info("Client.Receive Received message ="+ messageReceived);
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}

}



