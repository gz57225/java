package keyListenerGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		GameFrame.Snake bug1 = new GameFrame.Snake(5, 5, Color.BLUE, new MovementKey('w', 's', 'd', 'a'));
		GameFrame.Snake bug2 = new GameFrame.Snake(10, 10, Color.DARK_GRAY, new MovementKey('i', 'k', 'l', 'j'));
		GameFrame game = new GameFrame(new ArrayList<>(Arrays.asList(bug1, bug2)));
		game.setDefaultCloseOperation(GameFrame.EXIT_ON_CLOSE);
		game.setVisible(true);

	}

}
