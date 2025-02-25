package keyListenerGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private final int sideLength;
	private final ArrayList<Snake> bugs;
	private final char summonStarChar = '/';
	private Star star = null;
	private static Random rand = new Random();
	private int width;
	private int height;
	private KeyListener myKeyAdapter = new MyKeyAdapter();
	
	public GameFrame(int sideLength, int width, int height, ArrayList<Snake> bugs) {
		this.sideLength = sideLength;
		this.bugs = bugs != null? bugs : new ArrayList<Snake>();
		this.setSize(width, height);
		this.width = width;
		this.height = height;
		this.setBackground(Color.WHITE);
		this.addKeyListener(myKeyAdapter);
	}
	
	public GameFrame(ArrayList<Snake> bugs) {
		this(20, 500, 500, bugs);
	}
	
	@Override
	public void paint(Graphics g) {
		clean(g);
		
		bugs.forEach(bug -> bug.draw(g, sideLength));
		if (star != null) {
			star.draw(g, sideLength);
			
		}
		
	}

	private void clean(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
	}
	
	
	public static class Snake {
		private Color color;
		private ArrayList<Point> body;
		private MovementKey keys;
		
		public Snake(int initX, int initY, Color c, MovementKey keys) {
			this.body = new ArrayList<Point>(Arrays.asList(new Point(initX, initY)));
			this.keys = keys;
			this.color = c;
		}
		
		public void draw(Graphics g, int l) {
			Color previousColor = g.getColor();
			g.setColor(color);
			body.forEach(p -> g.drawRect(p.x * l, p.y * l, l, l));
			g.setColor(previousColor);
		}
		
		public void move(char ch) {
			Direction d = keys.getDirection(ch);
			if (d.notADirection()) {
				return;
			}
			Point point = body.get(body.size() - 1);
			body.add(new Point(point.x + d.offsetX, point.y + d.offsetY));
			
			body.remove(0);
		}
	}
	
	public static class Star extends Point {
		public Star(int x, int y) {
			super(x, y);
		}
			
		public void draw(Graphics g, int sideLength) {
			g.drawOval(x * sideLength, y * sideLength, sideLength, sideLength);
		}
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("Key Pressed: " + e.getKeyChar());
			
			if (e.getKeyChar() == summonStarChar) {
				System.out.println("GOT IT!");
				if (star == null) {
					star = new Star(rand.nextInt(width / sideLength - 3), rand.nextInt(height / sideLength - 3));
				}
			}
			
			bugs.forEach(bug -> {
				bug.move(e.getKeyChar());
			});
			repaint();
        }
	}
}
