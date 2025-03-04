package keyListenerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Star extends Point {
	private static final Color color = new Color(128, 128, 0);
	public Star(int x, int y) {
		super(x, y);
	}
		
	public void draw(Graphics g, int sideLength) {
		GameFrame.coloredOperation(g, color, () -> g.drawOval(x * sideLength, y * sideLength, sideLength, sideLength));
	}
}