package keyListenerGame;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InjectionCenter extends Thread {
	private ArrayList<IMoveNotify> i;
	private IEndNotify iEndNotify;
	
	InjectionCenter(ArrayList<IMoveNotify> i, IEndNotify iEndNotify) {
		this.i = i;
		this.iEndNotify = iEndNotify;
	}
	
	
	@Override
    public void run() {
        while (!iEndNotify.apply()) {
            try {
                Thread.sleep(500); // Every 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            i.forEach(process -> process.apply());
            
            System.out.println("Called!");
        }
    }
	
	@FunctionalInterface
	interface IMoveNotify {
	    void apply();
	}
	
	@FunctionalInterface
	interface IEndNotify {
	    boolean apply();
	}
}