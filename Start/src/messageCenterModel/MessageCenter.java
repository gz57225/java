package messageCenterModel;

import java.util.HashMap;
import java.util.HashSet;

public class MessageCenter {
	private static MessageCenter instance = new MessageCenter();
	private HashMap<MessageTypes, HashSet<Runnable>> messageTable = new HashMap<>();
	
	private MessageCenter() {
		
	}
	
	public void add(MessageTypes type, Runnable function) {
		if (!messageTable.containsKey(type)) {
			messageTable.put(type, new HashSet<>());
		}
		messageTable.get(type).add(function);
		return;
	}
	
	public void publish(MessageTypes type) {
		for (Runnable function : messageTable.get(type)) {
			function.run();
		}
	}
	
	public static MessageCenter getInstance() {
		return instance;
	}
}
