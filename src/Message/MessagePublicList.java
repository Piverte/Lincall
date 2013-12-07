package Message;

import java.util.ArrayList;

public class MessagePublicList extends MessagePublic{
	private ArrayList<MessagePublic> m_list;
	
	public MessagePublicList(){
		m_list = new ArrayList<MessagePublic>();
	}
	
	public void addMessagePublic (){
		
	}
	
	public ArrayList<MessagePublic> getList(){
		return m_list;
	}
}
