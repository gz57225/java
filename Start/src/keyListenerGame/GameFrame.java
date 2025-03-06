package keyListenerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private final int sideLength;
	private final ArrayList<Snake> snakes;
	private final char summonStarChar = '/';
	private Star star = null;
	private static Random rand = new Random();
	private KeyListener myKeyAdapter = new MyKeyAdapter();
	private GameState state = GameState.ONGOING;
	
	private int restrictedX;
	private int restrictedY;
	
	public GameFrame(int sideLength, int width, int height, ArrayList<Snake> bugs) {
		this.sideLength = sideLength;
		this.snakes = bugs != null? bugs : new ArrayList<Snake>();
		this.setSize(width, height);
		this.setBackground(Color.WHITE);
		this.addKeyListener(myKeyAdapter);
		
		this.restrictedX = getWidth() / sideLength - 3;
		this.restrictedY = getHeight() / sideLength - 3;
	}
	
	public GameFrame(ArrayList<Snake> snakes) {
		this(20, 500, 500, snakes);
	}
	
	@Override
	public void paint(Graphics g) {
		clean(g);
		if (state == GameState.GAME_OVER) {
			gameOverPaint(g);
		} else if (state == GameState.ONGOING) {
			ongoingPaint(g);
		} else {
			throw new UnsupportedOperationException("Unsupported Operation!");
		}
		
	}
	
	public void gameOverPaint(Graphics g) {
		coloredOperation(g, Color.RED, () -> {
			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
			g.drawString("GAME OVER!", 50, 100);
			System.out.println("BOOM!");
		});
	}
	
	public void ongoingPaint(Graphics g) {
		snakes.forEach(snake -> snake.draw(g, sideLength));
		if (star != null) {
			star.draw(g, sideLength);
		}
	}

	private void clean(Graphics g) {
		coloredOperation(g, Color.WHITE, () -> g.fillRect(0, 0, getWidth(), getHeight()));
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("Key Pressed: " + e.getKeyChar());
			
//			if (e.getKeyChar() == summonStarChar && star != null) {
//				star = new Star(rand.nextInt(width / sideLength - 3), rand.nextInt(height / sideLength - 3));
//			}
			
			moveNotify(e);
        }
	}
	
	public void moveNotify() {
		snakes.forEach(currSnake -> currSnake.move());
		snakes.forEach(currSnake -> {
			if (currSnake.isOverStar(star)) {
				currSnake.eatTheStar();
				star = null;
			}});
		state = GameState.setIfGameOver(isSnakeCrashed());
		repaint();
	}

	public void summonStarNotify() {
		System.out.println("Star Summon Process Notified!");
		if (rand.nextInt(5) == 1 && star == null) {
			System.out.println("Star Summoned!");
			star = new Star(rand.nextInt(restrictedX), rand.nextInt(restrictedY)); 
		}
	}
	
	public static void coloredOperation(Graphics g, Color color, Runnable runable) {
		Color previousColor = g.getColor();
		g.setColor(color);
		runable.run();
		g.setColor(previousColor);
	}
	
	private void moveNotify(KeyEvent e) {
		snakes.forEach(currSnake -> currSnake.storeAction(e.getKeyChar()));
	}

	private GameOverReason isSnakeCrashed() {
		 if (snakes.stream().anyMatch(currSnake -> currSnake.isCrashed(snakes.stream().filter(snake -> snake != currSnake), restrictedX, restrictedY))) {
			 return new GameOverReason
		 } else {
			 return new GameOverReason();
		 }
	}
	
	public boolean isGameOver() {
		return state == GameState.GAME_OVER;
	}
}
