package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import Client.KeepAlive;
import Message.*;
import Profile.Profile;

public class Receive implements Runnable{
	
	private PrintWriter m_out;
	private BufferedReader m_in;
	private Profile m_profile;
	private Thread m_t3;
	private Logger m_logger;
	
	public Receive (BufferedReader in, Profile p){
		m_logger = (new Server_Log4J()).getLogger();
		this.m_in = in;
		this.m_profile = p;
		
		try{
			m_out = new PrintWriter(p.getSocket().getOutputStream());
			m_logger.info("Receive.Receive : m_out initialisation");
			//m_in = new ObjectInputStream(p.getSocket().getInputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//while(true){
			try{				
				String s = m_in.readLine();
				m_logger.info("Receive.Receive : received string="+s);
				Message mes = new Message(s);
				switch (mes.getId()) {
					case 1:	
						//KeepAlive msgKeepAlive = new KeepAlive(s);						
						break;
					case 2:
						Message msg = new Message(s);
						break;
					case 3:	
						MessageAuthentification msgAuthent = new MessageAuthentification(s);
						break;
					case 4:
						MessageChangeStatut msgChangeStat = new MessageChangeStatut(s);
						break;
					case 5:
						MessageConnection msgChangeConnec = new MessageConnection(s);
						break;
					case 6:
						MessageCreateProfile msgMkProfile = new MessageCreateProfile(s); 
						break;
					case 7:
						MessageDeleteProfile msgDelProfile = new MessageDeleteProfile(s);
						break;
					case 8:
						MessageEditLogin msgEditLogin = new MessageEditLogin(s);
						break;
					case 9:
						MessageEditPassword msgEditPass = new MessageEditPassword(s);
						break;
					case 10:
						MessagePrivate msgPrivate = new MessagePrivate(s);
						break;
					case 11:
						//MessagePrivateList msgPrivateLst = new MessagePrivateList(s);
						break;
					case 12:
						MessagePublic msgPublic = new MessagePublic(s);
						m_t3=new Thread (new Emission(msgPublic));
						m_t3.start();
						m_logger.info("Receive.Run : Lancement du thread emission");
						break;
					case 13:
						//MessagePublicList msgPublicLst = new MessagePublicList(s);
						break;
				}
				
			}catch(IOException e){
				e.printStackTrace();
			}
		//}
	}
	
}
