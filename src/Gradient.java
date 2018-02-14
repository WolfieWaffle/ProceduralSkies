import java.awt.Color;
import java.util.ArrayList;

public class Gradient {

	ArrayList<GradientPoint> points;

	public Gradient(GradientPoint... points) {
		for (GradientPoint point : points) {
			this.points.add(point);
		}
	}

	public Ramp interpolate(int size) {
		ArrayList<Color> colors = new ArrayList<>();

		for (GradientPoint point : points) {
			colors.add(Math.round(size / point.percent), point.color);
		}

		return new Ramp(colors);
	}

}
