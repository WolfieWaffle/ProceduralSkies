import java.awt.Color;
import java.awt.Graphics;

public class Sun extends Planet {

	public Sun(int x, int y, int minSize, int maxSize) {
		super(x, y, minSize, maxSize);
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

}
