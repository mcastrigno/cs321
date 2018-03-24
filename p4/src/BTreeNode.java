import java.util.LinkedList;

/**
 * @author James Brooks
 *
 */
public class BTreeNode {
	private int objectCount;
	private int location; //byte offset of this node in file
	private boolean leaf;
	private LinkedList<TreeObject> objects; //Maybe array is better???
	private int parent; //pointer to byte offset location of parent in file
	private int[] child; //pointers to byte offset locations of children in file
	
	
	public BTreeNode() {
		this.objectCount = 0;
	}
	
	public int getObjectCount() {
		return objectCount;
	}

	public int getLocation() {
		return location;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	
	public void setLeaf(boolean isLeaf) {
		leaf = isLeaf;
	}
	
	public int getParent() {
		return parent;
	}

}
