
/**
 * @author James Brooks
 *
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
}
