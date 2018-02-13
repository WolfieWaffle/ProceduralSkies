import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Palette {

	private Ramp HRamp;
	private Ramp SRamp;
	private Ramp SMask = new Ramp(new float[] { 0.1f, 0.45f, 0.6f, 0.45f, 0.3f, 0.05f, 0.0f });
	private Ramp BMask = new Ramp(new float[] { 0.9f, 0.8f, 0.7f, 0.6f, 0.5f, 0.4f, 0.3f });
	private Ramp DaySMask = new Ramp(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.025f, 0.05f, 0.075f });
	private Ramp DayBMask = new Ramp(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.025f, 0.05f, 0.075f });
	public int size;

	private static final float MIN_SAT = 0.3f;
	private static final float MAX_SAT = 0.9f;

	public Palette(int size) {
		Random rand = new Random();
		this.size = size;
		this.HRamp = new Ramp(size);
		this.SRamp = getRandomSatMap();

		// Made a random hue ramp
		float[] hues = new float[size];
		float hue = rand.nextFloat();
		float hueshift = (1 / size) / 5;
		for (int i = 0; i < size; i++) {
			HRamp.put(i, hue);
			System.out.println();
			hue = subtractLooped(hue, (rand.nextFloat() * 8f) / 100f);
			System.out.println(hue);
		}
		
		SRamp = Ramp.add(SRamp, DaySMask);
		BMask = Ramp.add(BMask, DayBMask);
	}

	public Color getColor(int index) {
		int rgb = Color.HSBtoRGB(HRamp.get(index), SRamp.get(index), BMask.get(index));
		// int rgb = Color.HSBtoRGB(HRamp.get(index), SRamp.get(index),
		// BRamp.get(index));
		return new Color(rgb);
	}

	private Ramp getRandomSatMap() {
		Random rand = new Random();
		float[] vals = new float[size];
		float max = (rand.nextFloat() * MAX_SAT) - MIN_SAT;

		for (int i = 1; i < size + 1; i++) {
			vals[i - 1] = (max / i) + MIN_SAT;
		}

		return new Ramp(vals);
	}

	private float subtractLooped(float f1, float f2) {
		float extra;

		extra = f1 - f2;
		if (extra < 0) {
			extra = 1 - extra;
		}
		return extra;
	}

}
