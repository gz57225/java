package messageCenterModel;

public enum MessageTypes {
	CatMeow("CatMeow"), DogBark("DogBark");
	
	private final String description;
	
	private MessageTypes(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
