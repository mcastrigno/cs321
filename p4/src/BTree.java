
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
	
	//the indexing on this method may not be correct. I change to 0-based index from 1-based in the class notes
	/**
	 * Searches for the given key in the given node. Returns the
	 * tree object if it is found. Returns null if the key is not
	 * in the tree.
	 * 
	 * @param node Node to be searched
	 * @param targetKey Key to be searched for
	 * @return TreeObject if the target key is found
	 * @return null if the target key is not in the tree
	 */
	public TreeObject search(BTreeNode node, TreeObject targetKey) {
		int i = 0;
		while(i < node.getObjectCount() && targetKey.getData() > node.keyAt(i).getData()) {
			i++;
		}
		if(i < node.getObjectCount() && targetKey.getData() == node.keyAt(i).getData()) {
			return node.keyAt(i); //This return may need to be changed to something else. I don't know if TreeObject is what we want
		}
		else if(!node.isLeaf()) {
			return null;
		}
		else {
			node = storage.nodeRead(node.getChildAt(i));
			return search(node, targetKey);
		}
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
