import java.awt.Color;
import java.awt.Graphics;

public abstract class SkyObject {
	protected Color color;

	public SkyObject(Color color) {
		this.setColor(color);
	}

	public abstract void draw(Graphics g);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
