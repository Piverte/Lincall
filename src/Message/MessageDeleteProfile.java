package Message;

public class MessageDeleteProfile extends Message{

	/* Definition of members attributs */
	protected String m_login;
	protected String m_password;
	

	/* Constructor's Creation */
	
	// Default constructor
	public MessageDeleteProfile(){
		this("toto","pass");
	}
	
	// Overload constructor
	public MessageDeleteProfile(String login, String password){
		this.m_login = login;
		this.m_password = password;
	}
	
	public MessageDeleteProfile(String message) {
		super(message);
		decompose(message);
	}
	
	// Copy constructor
	public MessageDeleteProfile (MessageDeleteProfile mc){
		this.m_login = mc.getM_login();
		this.m_password = mc.getM_password();
	}
	
	
	/* Getter and Setter */
	public String getM_login() {
		return m_login;
	}
	
	public void setM_login(String m_login) {
		this.m_login = m_login;
	}
	
	public String getM_password() {
		return m_password;
	}
	
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	@Override
	public Message decompose(String message) {
		MessageDeleteProfile messDeleteProfile = new MessageDeleteProfile(m_message[1], m_message[2]);
		return messDeleteProfile;
	}
	
	@Override
	public String toString() {
		return this.getId() + token + this.getM_login() + token + this.getM_password();
	}
}
