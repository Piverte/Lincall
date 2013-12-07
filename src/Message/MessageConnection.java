package Message;


public class MessageConnection extends Message{
	
	/**
	 * 
	 */
	// Definition des attributs membres
	private String m_login;
	private String m_password;
	
	//// Creation des constructeurs
	
	//Constructeur par d�faut
	public MessageConnection (){

	}
	//Overload Constructeur 
	public MessageConnection (String login, String password){
		super();
		this.m_login = login;
		this.m_password = password;
	}
	
	public MessageConnection(String message) {
		super(message);
		decompose(message);
	}
	//Constructeur par copie
	public MessageConnection (MessageConnection mc){
		this.m_login = mc.getLogin();
		this.m_password = mc.getPassword();
	}
	
	
	//// Getter et Setter
	public String getLogin (){
		return this.m_login;
	}
	
	public String getPassword (){
		return this.m_password;
	}
	
	public void setLogin (String login){
		this.m_login = login;
	}
	
	public void setPassword (String password){
		this.m_password = password;
	}
	@Override
	public Message decompose(String message) {
		MessageConnection messConnection = new MessageConnection(m_message[1], m_message[2]);
		
		return (Message)messConnection;
	}
	
	@Override
	public String toString() {
		return this.getId() + token + this.getLogin() + token + this.getPassword();
	}
	
}
