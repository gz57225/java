package keyListenerGame;

public class MovementKey {
	private final char NORTH;
	private final char SOUTH;
	private final char EAST;
	private final char WEST;
	
	public MovementKey(final char N, final char S, final char E, final char W) {
		NORTH = N;
		SOUTH = S;
		EAST  = E;
		WEST  = W;
	}
	
	public Direction getDirection(char key) {
		if (key == NORTH) return Direction.NORTH;
		if (key == SOUTH) return Direction.SOUTH;
		if (key == EAST)  return Direction.EAST;
		if (key == WEST)  return Direction.WEST;
		return Direction.NOT_A_DIRECTION;
	}
}
