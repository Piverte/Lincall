package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import Client.Client_Log4J;
import Client.KeepAlive;
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
import Profile.Profile;

public class Authentificator implements Runnable, Serializable{
	private transient Socket m_socket;
	private ServerSocket m_ss;
	private PrintWriter m_out;
	private BufferedReader m_in;
	private Thread m_t2;
	private Profile m_profile;
	private Logger m_logger;
	private String login, pass;


	public Authentificator(ServerSocket ss){
		this.m_ss = ss;
		m_logger = (new Server_Log4J()).getLogger();
	}
	//accept socket access, create input and output stream
	public void run(){
		try{
			while(true){
				short codeErreur = 0;
				m_socket=m_ss.accept();
				m_logger.info("Authentification.Run : connection accepted m_socket.getLocalPort"+m_socket.getLocalPort()+" "+m_socket.getPort()+" "+m_socket.getInetAddress());
				m_out = new PrintWriter(m_socket.getOutputStream());
				m_in = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
				String s = m_in.readLine();
				Message mes = new Message(s);
				m_logger.info("Authentification.Run : mes.getID="+mes.getId());
				if(mes.getId() == 5){
					MessageConnection msg = new MessageConnection(s);
					msg.decompose(s);
					m_logger.info("Authentification.Run : Creation of a connection message related to the received string");
					Profile p = new Profile(msg.getLogin(), msg.getPassword(), "online");
					p.setSocket(m_socket);

					if(isValid(p)){
						m_t2 = new Thread(new Receive(m_in, p));
						m_t2.start();
						m_logger.info("Authentification.Run : ");
						MessageAuthentification ma = new MessageAuthentification(codeErreur,new String("Welcome"+p.getLogin()));
						m_out.println(ma);
						System.out.println("Authentificator.run après le write ");
					}else{
						codeErreur=-1;
						System.out.println("Authentificator.run in else codeErreur="+codeErreur);
						m_out.println(new MessageAuthentification(codeErreur,new String("Impossible connection")));
					}
				}else{
					m_logger.error("Authentification.Run : The String receive is not valid mes.getID="+mes.getId());	
				}
			}
		}catch(IOException e){
					e.printStackTrace();
		}

	}

			public boolean isValid(Profile p){
				boolean isValidb = false;
				System.out.println("Authentificator.isValid Profile.getLogin="+p.getLogin()+"getPass"+p.getPass());
				isValidb=ManageProfile.isValid(p);
				System.out.println("Authentificator.isValid isValid="+isValidb);
				return isValidb;
			}
		}
