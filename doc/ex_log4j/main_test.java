package loic_test;

import org.apache.log4j.Logger;

public class main_test {
		private static Logger log4j;
		private static Thread thread;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log4j = (new myLogger()).getLogger();
		log4j.info("launch thread");
		
		try {
			thread = new Thread(new myThread());
			thread.start();
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

}
