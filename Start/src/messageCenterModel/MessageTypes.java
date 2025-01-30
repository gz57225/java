package messageCenterModel;

import java.util.HashMap;

public enum MessageTypes {
	CatMeow(new HashMap<String, Object>(){{put("sound", "Meow");}}),
	DogBark(new HashMap<String, Object>(){{put("sound", new Object(){});}});
	
	private final HashMap<String, Object> vars;
	
	private MessageTypes(HashMap<String, Object> vars) {
		this.vars = vars;
	}
	
	public HashMap<String, Object> getVars() {
		return vars;
	}
}
