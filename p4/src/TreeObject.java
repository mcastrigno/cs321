
/**
 * @author James Brooks
 * @author Matthew Castrigno added toString for testing purposes
 */
public class TreeObject {
	private long data;
	private int frequency;

	public TreeObject(long data) {
		this.data = data;
		frequency = 1;
	}

	public long getData() {
		return data;
	}

	public int getFrequency() {
		return frequency;
	}

	public void incrementFrequency() {
		frequency++;
	}

	public void decrementFrequency() {
		frequency--;
	}
	public String toString() {
		String returnString = Long.toString(data) + " " + Integer.toString(frequency);
		return returnString;
	}

}
