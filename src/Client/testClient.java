package Client;

public class testClient {
	public static void main(String[] agrs){
		int port = 2000;
		String ipAdress = "localhost";
		new Client("djeco", "password", ipAdress, port);
}
}
