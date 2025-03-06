package keyListenerGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Snake bug1 = new Snake("Alba", 5, 5, Color.BLUE, new MovementKey('w', 's', 'd', 'a'));
		Snake bug2 = new Snake("Ninja", 10, 10, Color.DARK_GRAY, new MovementKey('i', 'k', 'l', 'j'));
		GameFrame game = new GameFrame(new ArrayList<>(Arrays.asList(bug1, bug2)));
		game.setDefaultCloseOperation(GameFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		
		InjectionCenter center = new InjectionCenter(
				new ArrayList<>(Arrays.asList(game::summonStarNotify, game::moveNotify)), 
				game::isGameOver);
		center.run();

	}

}
