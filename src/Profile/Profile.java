// ***** Class Profile *****

package Profile;

import java.net.Socket;

public class Profile {
	
	//Declarations
	protected String m_login;
	protected String m_password;
	protected String m_statut;
	protected Socket m_s;
	
	//Constructors
	
	//Defaut constructor
	public Profile (){
		this("test", "azertyuiop");
	}
	//Overrided constructors
	public Profile (String login, String password){
		this.m_login = login;
		this.m_password = password;
		this.m_statut = "Online";
		this.m_s = null;
	}
	
	public Profile (String login, String password, String state){
		this.m_login = login;
		this.m_password = password;
		this.m_statut = state;
		this.m_s = null;
	}
	//Constructor by copy
	public Profile (Profile p){
		this(p.getLogin(), p.getPass(), p.getStatut());
	}
	//Constructor by tab of 3 elements login, password, state
	public Profile (String[] str){
		this(str[0], str[1], str[2]);
	}
	
	//Getters and Setters
	public String getLogin() {
		return m_login;		
	}
	
	public void setLogin(String login) {
		this.m_login = login;
	}
	
	public String getPass() {
		return m_password;		
	}
	
	public void setPass(String password){
		this.m_password = password;
	}
	
	public String getStatut() {
		return m_statut;		
	}
	
	public void setStatut(String statut){
		this.m_statut = statut;
	}

	public Socket getSocket() {
		return m_s;		
	}
	
	public void setSocket(Socket p_socket){
		this.m_s = p_socket;
	}

}
