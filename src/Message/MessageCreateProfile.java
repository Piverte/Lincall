package Message;

public class MessageCreateProfile extends Message{

	/* Definition of members attributs */
	protected String m_login;
	protected String m_password;
	
	
	/* Constructor's Creation */
	
	// Default constructor
	public MessageCreateProfile(){
		this("toto","pass");
	}
	
	// Overload constructor
	public MessageCreateProfile(String login, String password){
		this.m_login = login;
		this.m_password = password;
	}
	
	public MessageCreateProfile(String message) {
		super(message);
		decompose(message);
	}
		
	// Copy constructor
	public MessageCreateProfile (MessageCreateProfile mc){
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
		MessageCreateProfile messCreateProfile = new MessageCreateProfile(m_message[1], m_message[2]);
		return messCreateProfile;
	}
	
	@Override
	public String toString() {
		return this.getId() + token + this.getM_login() + token + this.getM_password();
	}
}
