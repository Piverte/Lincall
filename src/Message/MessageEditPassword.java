package Message;

public class MessageEditPassword extends Message{

	/* Definition of members attributs */
	protected String m_login;
	protected String m_passwordOld;
	protected String m_passwordNew;
	
	
	/* Constructor's Creation */
	
	// Default constructor
	public MessageEditPassword(){

	}
	
	// Overload constructor
	public MessageEditPassword(String login, String passwordOld, String passwordNew){
		this.m_login = login;
		this.m_passwordOld = passwordOld;
		this.m_passwordNew = passwordNew;
	}
	
	// Copy constructor
	public MessageEditPassword (MessageEditPassword mc){
		this.m_login = mc.getM_login();
		this.m_passwordOld = mc.getM_passwordOld();
		this.m_passwordNew = mc.getM_passwordNew();
	}
	
	public MessageEditPassword(String message) {
		super(message);
		decompose(message);
	}
	
	/* Getter and Setter */
	public String getM_login() {
		return m_login;
	}

	public void setM_login(String m_login) {
		this.m_login = m_login;
	}
	
	public String getM_passwordOld() {
		return m_passwordOld;
	}
	
	public void setM_passwordOld(String m_passwordOld) {
		this.m_passwordOld = m_passwordOld;
	}
	
	public String getM_passwordNew() {
		return m_passwordNew;
	}
	
	public void setM_passwordNew(String m_passwordNew) {
		this.m_passwordNew = m_passwordNew;
	}

	@Override
	public Message decompose(String message) {
		MessageEditPassword messEditPassword = new MessageEditPassword(m_message[1], m_message[2], m_message[3]);
		return messEditPassword;
	}
	
	@Override
	public String toString() {
		return this.getId() + token + this.getM_login() + token + this.getM_passwordOld() + token + getM_passwordNew() ;
	}
}
