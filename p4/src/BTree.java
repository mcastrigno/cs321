
/**
 * @author James Brooks
 *
 */
public class BTree {
	private int degree;
	private int sequenceLength;
	private BTreeNode root;
	private Storage storage;
	
	public BTree(int degree, int sequenceLength, String fileName) {
		if(degree < 2) {
			this.degree = findOptimumDegree();
		}
		else {
			this.degree = degree;
		}
		this.sequenceLength = sequenceLength;
		root = new BTreeNode();
		root.setLeaf(true);
		storage = new Storage(fileName);
		storage.nodeWrite(root);
	}

	/**
	 * Estimates the optimum degree for the BTree assuming
	 * the disk block size is 4096 bytes. Taken from
	 * class notes
	 * 
	 * @return optimum degree for BTree
	 */
	private int findOptimumDegree() {
		int optimumDegree = 2;
		while((5 + (((2*optimumDegree) - 1) * 12) + (((2*optimumDegree) - 1) * 4)) <= 4096){
			optimumDegree++;
		}
		return optimumDegree;
	}
	
	public TreeObject search(BTreeNode node, TreeObject targetKey) {
		//TODO
		return null;
	}
	
	public void insert(TreeObject key) {
		//TODO
	}
	
	private void splitChild(BTreeNode currentNode, int childIndex, BTreeNode childNode) {
		//TODO
	}
	
	private void insertNonfull(BTreeNode currentNode, TreeObject key) {
		//TODO
	}
}
