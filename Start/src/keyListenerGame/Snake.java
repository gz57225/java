package keyListenerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Snake {
	private Color color;
	private ArrayList<Point> body;
	private MovementKey keys;
	public Direction headingTo;
	private boolean isExtended;
	private String name;
	
	public Snake(String name, int initX, int initY, Color c, MovementKey keys) {
		this.body = new ArrayList<Point>(Arrays.asList(new Point(initX, initY)));
		this.keys = keys;
		this.color = c;
		this.headingTo = Direction.NOT_A_DIRECTION;
		this.isExtended = false;
		this.name = name;
	}
	
	public void draw(Graphics g, int l) {
		GameFrame.coloredOperation(g, color, () -> body.forEach(p -> g.drawRect(p.x * l, p.y * l, l, l)));
	}
	
	public void storeAction(char ch) {
		if (keys.getDirection(ch) != Direction.NOT_A_DIRECTION) {
			headingTo = keys.getDirection(ch);
		}
	}
	
	public boolean move() {
		if (headingTo.notADirection()) {
			return true;
		}
		Point point = getHeadPos();
		body.add(new Point(point.x + headingTo.offsetX, point.y + headingTo.offsetY));
		if (!isExtended) {
			body.remove(0);
		} else {
			isExtended = false;
		}
		System.out.println(this);
		return true;
	}
	
	public boolean isBodyPart(Point p) {
		return body.contains(p);
	}
	
	public GameOverReason isCrashed(Stream<Snake> snakes, int resX, int resY) {
		if (confrontWall(resX, resY)) {
			return new GameOverReason("Confront Wall", this, this);
		} else if (snakes.anyMatch(snake -> snake.isBodyPart(getHeadPos()))) {
			return new GameOverReason("Crashed", this, )
		}
	}

	public boolean isOverStar(Star star) {
		return getHeadPos().equals(star);
	}

	public void eatTheStar() {
		System.out.println("Star Had Eaten by me, " + this.name);
		isExtended = true;
	}
	
	public Point getHeadPos() {
		return body.get(body.size() - 1);
	}
	
	public boolean confrontWall(int resX, int resY) {
		return resX == getHeadPos().x || resY == getHeadPos().y || 0 == getHeadPos().x || 0 == getHeadPos().y;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String res = "";
		for (Point p : body) {
			res += "[" + p.x + ", " + p.y + "]";
		}
		return this.name + " " + res;
	}
}
