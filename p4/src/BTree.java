
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

	private int findOptimumDegree() {
		// TODO Auto-generated method stub
		return 0;
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
