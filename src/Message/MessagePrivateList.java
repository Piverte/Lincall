package Message;

import java.util.ArrayList;

public class MessagePrivateList extends MessagePrivate{
	ArrayList<MessagePrivate> m_messagePrivateList;
	
	public MessagePrivateList(){
		m_messagePrivateList = new ArrayList<MessagePrivate>();
	}
	public ArrayList<MessagePrivate> getPrivateList(){
		return m_messagePrivateList;
	}
	
	public void addMessage(MessagePrivate message){
		m_messagePrivateList.add(message);
	}
	
}
