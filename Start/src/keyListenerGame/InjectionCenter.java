package keyListenerGame;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InjectionCenter extends Thread {
	private IMoveNotify i;
	
	InjectionCenter(IMoveNotify i) {
		this.i = i;
	}
	
	
	@Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500); // Every 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            i.apply();
            System.out.println("Call to move!");
        }
    }
	
	@FunctionalInterface
	interface IMoveNotify {
	    void apply();
	}
}