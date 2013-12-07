package loic_test;

import org.apache.log4j.Logger;

public class myThread implements Runnable{
	private Logger log4j;
	
	public myThread() {
		// TODO Auto-generated constructor stub
		log4j = (new myLogger()).getLogger();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Test loic");
		log4j.info("log4j in thread");
		
	}

}
