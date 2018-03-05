import java.awt.Color;

public class ColorTools {

	public static Color randomColor() {

		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = (float) (Math.random() / 2f + 0.5f);
		float g = (float) (Math.random() / 2f + 0.5f);
		float b = (float) (Math.random() / 2f + 0.5f);

		return new Color(r, g, b);
	}

}
