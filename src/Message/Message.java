package Message;


public class Message {

	protected short m_id;
	protected String[] m_message;
	protected String token = "§";
	

	public Message() {
	}

	public Message(String message) {
		m_message = message.split(token);
		m_id = Short.parseShort(m_message[0]);
	}
	public short getId() {
		return m_id;
	}
	
	public Message decompose(String message){
		Message mess = new Message ();
		return mess;
	}
}
