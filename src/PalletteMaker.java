import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class PalletteMaker {

	private static final float MAX_SAT = 1.0f;
	private static final float MIN_SAT = 0.3f;

	public static Palette makePallet(int size) {
		System.out.println(size);
		Random rand = new Random();
		Ramp basicRamp = new Ramp(size);

		ValueMap hueMap = getRandomSatMap(size);
		ValueMap satMap = getRandomSatMap(size);
		ValueMap briMap = getRandomSatMap(size);

		// Made a random hue map
		float[] hues = new float[size];
		float hue = rand.nextFloat() / 2;
		float hueshift = (1 / size) / 5;
		for (int i = 0; i < size; i++) {
			hueMap.set(i, hue);
			hue = subtractLooped(hue, (rand.nextFloat() * 8f) / 100f);
		}

		return new Palette(size, combineMaps(size, hueMap, satMap, briMap));
	}

	private static ValueMap getRandomSatMap(int size) {
		Random rand = new Random();
		ValueMap vals = new ValueMap(size);
		float max = (rand.nextFloat() * MAX_SAT) - MIN_SAT;

		for (int i = 1; i < size + 1; i++) {
			vals.set(i - 1, (max / i) + MIN_SAT);
		}

		return vals;
	}

	private static float subtractLooped(float f1, float f2) {
		float extra;

		extra = f1 - f2;
		if (extra < 0) {
			extra = 1 - extra;
		}
		return extra;
	}

	private static Ramp combineMaps(int size, ValueMap hueMap, ValueMap satMap, ValueMap briMap) {
		ArrayList<Color> colors = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			int rgb = Color.HSBtoRGB(hueMap.get(i), satMap.get(i), briMap.get(i));
			colors.add(new Color(rgb));
		}

		return new Ramp(colors);
	}

}
