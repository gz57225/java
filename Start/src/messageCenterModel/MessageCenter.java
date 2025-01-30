package messageCenterModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;

public class MessageCenter {
	private static MessageCenter instance = new MessageCenter();
	private HashMap<MessageTypes, HashSet<Consumer<HashMap<String, Object>>>> messageTable = new HashMap<>();
	
	private MessageCenter() {
		
	}
	
	public void add(MessageTypes type, Consumer<HashMap<String, Object>> function) {
		if (!messageTable.containsKey(type)) {
			messageTable.put(type, new HashSet<>());
		}
		messageTable.get(type).add(function);
		return;
	}
	
	public void publish(MessageTypes type) {
		if (!messageTable.containsKey(type)) {
			return;
		}
		for (Consumer<HashMap<String, Object>> function : messageTable.get(type)) {
			function.accept(type.getVars());
		}
	}
	
	public static MessageCenter getInstance() {
		return instance;
	}
}
