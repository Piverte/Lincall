package Message;

public class KeepAlive extends Message{

	/* Constructor's Creation */
	
	// Default constructor
	public KeepAlive(){
	}
	
	//Overload constructor
	public KeepAlive(String message) {
		super(message);
		decompose(message);
	}

	@Override
	public Message decompose(String message) {
		KeepAlive kA = new KeepAlive();
		return kA;
	}
	
	@Override
	public String toString() {
		return this.getId() +"";
	}
}