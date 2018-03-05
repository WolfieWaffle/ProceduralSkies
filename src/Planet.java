import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Planet extends SkyObject {
	protected int radius;
	protected int x;
	protected int y;
	Random rand = new Random();

	public Planet(int x, int y, Color color, int radius) {
		super(color);
		this.radius = radius;
		this.x = x;
		this.y = y;
	}

	public Planet(int x, int y, int minSize, int maxSize) {
		super(ColorTools.randomColor());
		this.x = x;
		this.y = y;

		radius = (int) (Math.random() * (maxSize - minSize) + 1) + minSize;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
		System.out.println("DRAW AT Y: " + y);
	}

	@Override
	public String toString() {
		return x + " " + y + " " + radius;
	}

}
