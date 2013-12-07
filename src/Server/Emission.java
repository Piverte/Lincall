package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import Message.*;
import Profile.Profile;

public class Emission implements Runnable{
	PrintWriter m_out;
	MessagePublic m_msgP;
	Logger m_logger;
	
	public Emission (MessagePublic mp){
		this.m_msgP=mp;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			for(Profile user : ManageProfile.getListProfile()){
				m_out = new PrintWriter(user.getSocket().getOutputStream());
				m_out.println(m_msgP);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
	}

	
}
