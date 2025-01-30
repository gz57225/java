package messageCenterModel;

public class Main {
	public static void main(String[] args) {
		MessageCenter msgCenter = MessageCenter.getInstance();
		msgCenter.add(MessageTypes.CatMeow, () -> System.out.println("Meow~"));
		System.out.println("before");
		msgCenter.publish(MessageTypes.CatMeow);
		System.out.println("after");
	}

}
