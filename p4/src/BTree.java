
/**
 * @author James Brooks
 * @author Matthew Castrigno
 */
public class BTree {
	private int degree;
	private int sequenceLength;
	private BTreeNode root;
	//private Storage storage;			//For use when real storage is ready
	private TreeStorage storage;
	private int numOfTreeNodes = 0;
	
	//Creating a tree requires creating a file structure on disk.
	//TreeStorage class emulates that file.
	//The actual disk version of the class is called Storage.
	//Migration will occur once Storage is written and tested.
	//In both classes the process is to create the "file" and 
	//then store nodes in it. The process of writing the Node to disk
	//allocates the space and gives its location (nodePointer) which 
	//should never change, what node points to it will, but a node
	//will always have the same location on disk
	
	public BTree(int degree, int sequenceLength) {	
		this.sequenceLength = sequenceLength;								//Once this constructor is called 
		TreeStorage storage = new TreeStorage(degree, sequenceLength);		//There is storage allocated with
																			//one node in it.
//		Storage storage = new TreeStorage(degree, sequenceLength);			//Once the "real" disk storage is ready
		
		numOfTreeNodes++;													 
		root = allocateNode();
		root.setLeaf(true);
	}

	public BTreeNode allocateNode() {
		BTreeNode newNode;
		numOfTreeNodes++;
		newNode = new BTreeNode(numOfTreeNodes);
		int treeStorageNumOfNodes = storage.nodeAdd(newNode);
		System.out.println("The Tree number of Nodes is :" + treeStorageNumOfNodes + "and the TreeStorage number of nodes is: " + numOfTreeNodes);
		return newNode;
		
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
		int i = 1;
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
			node = storage.nodeRead(node.getChildPointer(i));
			return search(node, targetKey);
		}
	}
	
	public void insert(TreeObject key) {
		BTreeNode oldRoot = root;
		if(root.numOfObjects() == ((2*degree) - 1)) {
			BTreeNode node = allocateNode();  
			root = node;
			root.setLeaf(false);
			root.setChildAt(1, oldRoot);
			splitChild(root, 1);
			insertNonfull(root, key);
		}
		else {
			insertNonfull(root, key);
		}
	}
	
	private void insertNonfull(BTreeNode currentNode, TreeObject key) {
		int i = currentNode.getObjectCount();
		if(currentNode.isLeaf()) {
			while((i >= 1) && (key.getData() < currentNode.keyAt(i).getData())){
				currentNode.putObject((i+1), currentNode.keyAt(i));
				i--;
			}
			currentNode.putObject(i+1, key);
			//pseudo code say to increase number of nodes by one but that happens automatically in the putObjects method
			storage.nodeWrite(currentNode);
		}else {
			while((i >= 1) && (key.getData() < currentNode.keyAt(i).getData())){
				i--;	
			}
			//other statements
			i++;
			BTreeNode currentNodeChildAtI = storage.nodeRead(currentNode.getChildPointer(i)); // get the child indexed at i
			//other statements
			if(currentNodeChildAtI.getObjectCount() == ((2*degree) - 1)) {
				splitChild(currentNode, i);
				if(key.getData() > currentNode.keyAt(i).getData()) {
					i++;
				}
			}
			insertNonfull(currentNodeChildAtI ,key );
		}
	}
	private void splitChild(BTreeNode currentNode, int childIndex) {
		//TODO
	}
	

}
