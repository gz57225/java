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
	private boolean isExtended;
	
	public Snake(int initX, int initY, Color c, MovementKey keys) {
		this.body = new ArrayList<Point>(Arrays.asList(new Point(initX, initY)));
		this.keys = keys;
		this.color = c;
		this.headingTo = Direction.NOT_A_DIRECTION;
		this.isExtended = false;
	}
	
	public void draw(Graphics g, int l) {
		GameFrame.coloredOperation(g, color, () -> body.forEach(p -> g.drawRect(p.x * l, p.y * l, l, l)));
	}
	
	public void storeAction(char ch) {
		if (keys.getDirection(ch) != Direction.NOT_A_DIRECTION) {
			headingTo = keys.getDirection(ch);
		}
	}
	
	public void move() {
		if (headingTo.notADirection()) {
			return;
		}
		Point point = getHeadPos();
		System.out.println("Snake " + color + " Moved Successfully! From " + point + " To " + newPoint);
		body.add(new Point(point.x + headingTo.offsetX, point.y + headingTo.offsetY));
		body.remove(0);
		return;
	}
	
	public boolean isBodyPart(Point p) {
		return body.contains(p);
	}
	
	public boolean isCrashed(Stream<Snake> snakes) {
		return snakes.anyMatch(snake -> snake.isBodyPart(body.getHeadPos()));
	}

	public boolean isOverStar(Star star) {
		return getHeadPos().equals(star);
	}

	public void eatTheStar() {
		isExtended = true;
	}
	
	public Point getHeadPos() {
		return body.get(body.size() - 1);
	}
}
