package keyListenerGame;

public enum GameState {
	ONGOING("Ongoing"), GAME_OVER("Game Over");
	String description;
	GameState(String description) {
		this.description = description;
	}
	
}
