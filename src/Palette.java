import java.awt.Color;
import java.awt.Graphics;

public class Palette {

	public int size;
	private Ramp basicRamp;

	public Palette(int size, Ramp basicRamp) {
		this.basicRamp = basicRamp;
		this.size = size;
	}

	public Color getBasicColor(int index) {
		return basicRamp.get(index);
	}

}
