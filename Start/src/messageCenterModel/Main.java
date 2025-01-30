package messageCenterModel;

public class Main {
	public static void main(String[] args) {
		MessageCenter msgCenter = MessageCenter.getInstance();
		msgCenter.add(MessageTypes.CatMeow, (vars) -> {
			Object obj = vars.getOrDefault("sound", "Not available!");
			if (obj instanceof String) {
				System.out.println("PRINT");
			} else {
				System.out.println("NOT A STRING");
			}
		});
		System.out.println("before");
		msgCenter.publish(MessageTypes.CatMeow);
		System.out.println("after");
		msgCenter.publish(MessageTypes.DogBark);
		System.out.println("after all");
	}

}
