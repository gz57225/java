package cowProject;
import java.awt.*;

import javax.swing.JFrame;
import java.awt.Color;

public class CowFrame extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e);
	
	public CowFrame () {
		init();
	}
	
	public void init() {
		setSize(700,600);
		setBackground(Color.WHITE);
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(0xB2F77D));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.translate(50, 50);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(100, 280, 60, 120);
		g.fillRect(300, 280, 60, 120);
		g.setColor(BISQUE);
		g.fillRect(50, 100, 400, 200);
		g.setColor(Color.white);
		g.fillOval(350, 50, 200, 100);
		g.setColor(Color.BLACK);
		g.drawOval(350, 50, 200, 100);
		g.setColor(new Color(0xD2B48C));
		g.drawLine(90, 120, 10, 160);
		g.setColor(new Color(0x634E34));
		g.fillOval(430, 80, 30, 30);
		g.fillOval(470, 80, 30, 30);
		g.drawArc(420, 60, 160, 80, -80, -82);
		g.setColor(Color.CYAN);
		g.setFont(new Font("Sanserif", Font.ROMAN_BASELINE, 48));
		g.drawString("I'm a cow, moo...", 80, 30);
	}
}