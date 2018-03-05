import java.awt.Color;
import java.util.ArrayList;

public class Ramp {

	private Color[] vals;
	public int size;

//	public Ramp(Color startingColor, Color endingColor) {
//		this.vals = new Color[colors.size()];
//		this.size = colors.size();
//		for (int i = 0; i < colors.size(); i++) {
//			vals[i] = colors.get(i);
//		}
//	}
//
//	public Ramp(int size) {
//		this(new ArrayList<Color>(size));
//	}

	/*
	 * public static Ramp add(Ramp ramp1, Ramp ramp2) { assert ramp1.size ==
	 * ramp2.size;
	 * 
	 * Color[] resultVals;
	 * 
	 * resultVals = new float[ramp1.size];
	 * 
	 * for (int i = 0; i < ramp1.size; i++) { resultVals[i] =
	 * Math.min(ramp1.get(i) + ramp2.get(i), 1f); }
	 * 
	 * return new Ramp(resultVals); }
	 */

	public Color get(int index) {
		if (index < 0) {
			return vals[0];
		} else if (index >= vals.length) {
			return vals[vals.length - 1];
		}
		return vals[index];
	}

	public void put(int index, Color val) {
		if (index < 0 || index >= vals.length) {
			return;
		}
		vals[index] = val;
	}

}
