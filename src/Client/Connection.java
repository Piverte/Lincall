package Client;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import Message.Message;
import Message.MessageAuthentification;
import Message.MessageChangeStatut;
import Message.MessageConnection;
import Message.MessageDeleteProfile;
import Message.MessageEditLogin;
import Message.MessageEditPassword;
import Message.MessagePrivate;
import Message.MessagePublic;
import Server.Emission;

public class Connection implements Runnable {
	protected Socket m_socket;
	protected Thread m_receive;
	protected String m_login;
	protected String m_password;
	protected PrintWriter m_out;
	protected BufferedReader m_in;
	protected Boolean m_auth;
	protected Logger m_logger;


	public Connection(Socket soc, String login, String password) {
		m_socket = soc;
		m_password = password;
		m_login = login;
		m_logger = (new Client_Log4J()).getLogger();
		try {
			m_in = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			m_out = new PrintWriter(m_socket.getOutputStream());
			m_logger.info("Connection.Connection : m_in"+m_in);
			m_logger.info("Connection.Connection : m_out"+m_out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		m_auth = false;

	}

	@Override
	public void run() {
		MessageConnection messCon = new MessageConnection(m_login, m_password);
		m_out.println(messCon.toString());
	
		while(!m_auth){
			try{
				String msgReceived = m_in.readLine();
				m_logger.info("Connection.Run : msgReceived="+msgReceived);
				Message mess = new Message(msgReceived);
				if(mess.getId() == 3){
					MessageAuthentification msg = new MessageAuthentification(msgReceived);
					m_auth = true;
					m_logger.info("Connection.Run : m_auth="+m_auth);
					m_receive = new Thread(new Receive(m_socket));
				}else{
					m_logger.error("Connection.Run : The message id is unknown for this class Connection");
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}

	public Socket getM_socket() {
		return m_socket;
	}

	public Boolean getM_auth() {
		return m_auth;
	}

}
