package Message;

public class MessageEditLogin extends Message{

	/* Definition of members attributs */
	protected String m_loginOld;
	protected String m_loginNew;
	protected String m_password;
	
	
	/* Constructor's Creation */
	
	// Default constructor
	public MessageEditLogin(){
		this("toto","titi","pass");
	}
	
	// Overload constructor
	public MessageEditLogin(String loginOld, String loginNew, String password){
		this.m_loginOld = loginOld;
		this.m_loginNew = loginNew;
		this.m_password = password;
	}
	
	public MessageEditLogin(String message) {
		super(message);
		decompose(message);
	}
	
	// Copy constructor
	public MessageEditLogin (MessageEditLogin mc){
		this.m_loginOld = mc.getM_loginOld();
		this.m_loginNew = mc.getM_loginNew();
		this.m_password = mc.getM_password();
	}
	
	
	/* Getter and Setter */
	public String getM_loginOld() {
		return m_loginOld;
	}
	
	public void setM_loginOld(String m_loginOld) {
		this.m_loginOld = m_loginOld;
	}
	
	public String getM_loginNew() {
		return m_loginNew;
	}
	
	public void setM_loginNew(String m_loginNew) {
		this.m_loginNew = m_loginNew;
	}
	
	public String getM_password() {
		return m_password;
	}
	
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	@Override
	public Message decompose(String message) {
		MessageEditLogin messEditLogin = new MessageEditLogin(m_message[1], m_message[2], m_message[3]);
		return messEditLogin;
	}
	
	@Override
	public String toString() {
		return this.getId() + token  + this.getM_loginOld() + token + this.getM_loginNew() + token + this.getM_password();
	}
}
