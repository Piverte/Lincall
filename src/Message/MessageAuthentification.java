package Message;


public class MessageAuthentification extends Message{
	
	/**
	 * 
	 */
	/* Definition of members attributs */
	protected short m_errorCode;	
	protected String welcome;

	
	/* Constructor's Creation */
	
	// Default constructor
	public MessageAuthentification(){
		this.m_errorCode = -1;
		this.welcome = null;
	}
	
	// Overload constructor
	
	public MessageAuthentification(String message, short errorCode, String welcome) {
		super(message);
		this.m_errorCode = errorCode;
		this.welcome = welcome;
	}
	public MessageAuthentification(short errorCode, String welcome){
		this.m_errorCode = errorCode;
		this.welcome = welcome;
	}
	
	public MessageAuthentification(String message) {
		super(message);
		decompose(message);
	}
		
	// Copy constructor
	public MessageAuthentification (MessageAuthentification mc){
		this.m_errorCode = mc.getM_errorCode();
		this.welcome = mc.getWelcome();
	}
	
	
	/* Getter and Setter */
	public short getM_errorCode() {
		return m_errorCode;
	}
	
	public void setM_errorCode(short m_errorCode) {
		this.m_errorCode = m_errorCode;
	}
	
	public String getWelcome() {
		return welcome;
	}
	
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	@Override
	public Message decompose(String message) {
		MessageAuthentification messAuth = new MessageAuthentification(Short.parseShort(m_message[1]), m_message[2]);
		return messAuth;
	}
	
	@Override
	public String toString() {
		return this.getId() + token + this.getM_errorCode() + token + this.getWelcome();
	}
}
