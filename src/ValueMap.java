
public class ValueMap {

	private float[] values;

	public ValueMap(int size) {
		values = new float[size];
	}

	public float get(int index) {
		return values[index];
	}

	public void set(int index, float value) {
		values[index] = value;
	}

}
