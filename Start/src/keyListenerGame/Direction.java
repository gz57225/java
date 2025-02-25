package keyListenerGame;

public enum Direction {
    NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0), NOT_A_DIRECTION(0, 0);
	
	int offsetX;
	int offsetY;
	private Direction(int i, int j) {
		offsetX = i;
		offsetY = j;
	}
	
	public boolean notADirection() {
		return offsetX == 0 && offsetY == 0;
	}
}