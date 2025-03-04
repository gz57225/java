package keyListenerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Snake {
	private Color color;
	private ArrayList<Point> body;
	private MovementKey keys;
	public Direction headingTo;
	
	public Snake(int initX, int initY, Color c, MovementKey keys) {
		this.body = new ArrayList<Point>(Arrays.asList(new Point(initX, initY)));
		this.keys = keys;
		this.color = c;
		this.headingTo = Direction.NOT_A_DIRECTION;
	}
	
	public void draw(Graphics g, int l) {
		GameFrame.coloredOperation(g, color, () -> body.forEach(p -> g.drawRect(p.x * l, p.y * l, l, l)));
	}
	
	public void storeAction(char ch) {
		if (keys.getDirection(ch) != Direction.NOT_A_DIRECTION) {
			headingTo = keys.getDirection(ch);
		}
	}
	
	public boolean move(Stream<Snake> snakes) {
		if (headingTo.notADirection()) {
			return true;
		}
		Point point = getHeadPos();
		Point newPoint = new Point(point.x + headingTo.offsetX, point.y + headingTo.offsetY);
		if (isCrashed(newPoint, snakes)) {
			return false;
		}
		System.out.println("Snake " + color + " Moved Successfully! From " + point + " To " + newPoint);
		body.add(newPoint);
		body.remove(0);
		return true;
	}
	
	
	
	public boolean isBodyPart(Point p) {
		return body.contains(p);
	}
	
	public boolean isCrashed(Point offsetPoint, Stream<Snake> snakes) {
		return snakes.anyMatch(snake -> snake.isBodyPart(offsetPoint));
	}
	
	public Point getHeadPos() {
		return body.get(body.size() - 1);
	}
}
