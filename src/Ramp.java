import java.util.Arrays;

public class Ramp {

	private float[] vals;
	public int size;

	public Ramp(float[] vals) {
		this.vals = Arrays.copyOf(vals, vals.length);
		this.size = vals.length;
	}

	public Ramp(int size) {
		this(new float[size]);
	}

	public static Ramp add(Ramp ramp1, Ramp ramp2) {
		assert ramp1.size == ramp2.size;

		float[] resultVals;

		resultVals = new float[ramp1.size];

		for (int i = 0; i < ramp1.size; i++) {
			resultVals[i] = Math.min(ramp1.get(i) + ramp2.get(i), 1f);
		}

		return new Ramp(resultVals);
	}

	public float get(int index) {
		if (index < 0) {
			return vals[0];
		} else if (index >= vals.length) {
			return vals[vals.length - 1];
		}
		return vals[index];
	}

	public void put(int index, float val) {
		if (index < 0 || index >= vals.length) {
			return;
		}
		vals[index] = val;
	}

}
