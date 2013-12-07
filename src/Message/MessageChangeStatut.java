package Message;

public class MessageChangeStatut extends Message{

	/* Definition of members attributs */
	protected String m_contact;
	protected String m_statut;
	
	
	/* Constructor's Creation */
	
	// Default constructor
	public MessageChangeStatut(){
		this("toto","oneline");
	}
	
	// Overload constructor
	public MessageChangeStatut(String contact, String statut){
		this.m_contact = contact;
		this.m_statut = statut;
	}
	
	public MessageChangeStatut(String message) {
		super(message);
		decompose(message);
	}
	
	// Copy constructor
	public MessageChangeStatut (MessageChangeStatut mc){
		this.m_contact = mc.getM_contact();
		this.m_statut = mc.getM_statut();
	}
	
	
	/* Getter and Setter */
	public String getM_contact() {
		return m_contact;
	}
	
	public void setM_contact(String m_contact) {
		this.m_contact = m_contact;
	}
	
	public String getM_statut() {
		return m_statut;
	}
	
	public void setM_statut(String m_statut) {
		this.m_statut = m_statut;
	}

	@Override
	public Message decompose(String message) {
		MessageChangeStatut messChangeStatut = new MessageChangeStatut(m_message[1], m_message[2]);
		return messChangeStatut;
	}
	
	@Override
	public String toString() {
		return this.getId() + token + this.getM_contact() + token + this.getM_statut();
	}
}
