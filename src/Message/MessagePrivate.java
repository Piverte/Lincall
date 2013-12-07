package Message;

import java.io.Serializable;

public class MessagePrivate extends Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Definition of members attributs */
	private String m_sender;
	private String m_recipient;
	private String m_content;
	
	/* Constructor's Creation */
	
	// Default constructor	
	public MessagePrivate (){

	}
	
	//overload constructor
	public MessagePrivate(String sender, String recipient, String content){
		this.m_content = content;
		this.m_sender = sender;
		this.m_recipient = recipient;
	}
	
	public MessagePrivate(String message) {
		super(message);
		decompose(message);
	}
	
	//copy constructor
	public MessagePrivate(MessagePrivate mp){
		this(mp.getM_sender(), mp.getM_recipient(), mp.getM_content());
	}

	/* Getter and Setter */
	public String getM_sender() {
		return m_sender;
	}

	public void setM_sender(String m_sender) {
		this.m_sender = m_sender;
	}

	public String getM_recipient() {
		return m_recipient;
	}

	public void setM_recipient(String m_recipient) {
		this.m_recipient = m_recipient;
	}
	
	public String getM_content() {
		return m_content;
	}

	public void setM_content(String m_content) {
		this.m_content = m_content;
	}


	@Override
	public Message decompose(String message) {
		MessagePrivate messPrivate = new MessagePrivate(m_message[1], m_message[2], m_message[3]);
		return messPrivate;
	}

	@Override
	public String toString() {
		return this.getId() + token + this.getM_sender() + token + this.getM_recipient() + token + this.getM_content();
	}

}
