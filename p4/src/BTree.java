
/**
 * @author James Brooks
 * @author Matthew Castrigno
 */
public class BTree {
	private int degree;
	private int sequenceLength;			//Even though the BTree does not need this info it may be good to store in case the user 
										//attempts to search a sequence length different than what was stored as an error check
	private BTreeNode root;
	//private Storage storage;			//For use when real storage is ready
	public TreeStorage storage;
	private int numOfTreeNodes = 0;
	private int treeStorageNumOfNodes = 0; // Used to track that the number of nodes in storage matches the number of nodes the tree object has
	
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
		this.sequenceLength = sequenceLength;							//Once this constructor is called 
		this.storage = new TreeStorage(degree, sequenceLength);			//There is storage allocated with
		this.degree = degree;											//one node in it.
																			
//		Storage storage = new TreeStorage(degree, sequenceLength);		//Once the "real" disk storage is ready
														 
		root = allocateNode();
		root.setLeaf(true);
	}

	public BTreeNode allocateNode() {
		BTreeNode newNode;
		numOfTreeNodes++;
		newNode = new BTreeNode(numOfTreeNodes,  degree);
		treeStorageNumOfNodes = storage.nodeAdd(newNode);				//
		System.out.println("The Tree number of Nodes is :" + treeStorageNumOfNodes + " and the TreeStorage number of nodes is: " + numOfTreeNodes);
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
		while(i < node.numOfObjects() && targetKey.getData() > node.keyObjectAt(i).getData()) {
			i++;
		}
		if(i < node.numOfObjects() && targetKey.getData() == node.keyObjectAt(i).getData()) {
			return node.keyObjectAt(i); //This return may need to be changed to something else. I don't know if TreeObject is what we want
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
		//if(numOfTreeNodes == 0) createRoot(key); break;
		BTreeNode oldRoot = root;
		if(root.numOfObjects() == ((2*degree) - 1)) {
			BTreeNode node = allocateNode();  
			root = node;
			root.setLeaf(false);
			root.setChildPointer(1, oldRoot.getNodePointer());
			splitChild(root, 1);
			insertNonfull(root, key);
		}
		else {
			insertNonfull(root, key);
		}
	}
	
	private void insertNonfull(BTreeNode currentNode, TreeObject key) {
		int i = currentNode.numOfObjects();
		if(currentNode.isLeaf()) {
			while((i >= 1) && (key.getData() < currentNode.keyObjectAt(i).getData())){
				currentNode.putObject((i+1), currentNode.keyObjectAt(i));
				i--;
			}
			currentNode.putObject(i+1, key);
			//pseudo code say to increase number of nodes by one but that happens automatically in the putObjects method
			storage.nodeWrite(currentNode);
		}else {
			while((i >= 1) && (key.getData() < currentNode.keyObjectAt(i).getData())){
				i--;	
			}

			i++;
			BTreeNode currentNodeChildAtI = storage.nodeRead(currentNode.getChildPointer(i)); // get the child indexed at i

			if(currentNodeChildAtI.numOfObjects() == ((2*degree) - 1)) {
				splitChild(currentNode, i);
				if(key.getData() > currentNode.keyObjectAt(i).getData()) {
					i++;
				}
			}
			insertNonfull(currentNodeChildAtI ,key );
		}
	}
	private void splitChild(BTreeNode currentNode, int childIndex) {
		BTreeNode z = allocateNode();
		BTreeNode y = storage.nodeRead(currentNode.getChildPointer(childIndex));
		z.setLeaf(y.isLeaf());
		//book say to set number of z objects to degree - 1 but I don't think that
		//makes sense here since the node has an arrayList of objects
		for (int j = 1; j <= (degree -1); j++)
			z.putObject(j, y.removeKeyObjectAt(j+degree));
		
		if (!y.isLeaf()){										//only comes into play if node is not a leaf 
			for (int j = 1; j <= (degree); j++) 				//you move the child pointers over to the new half of the split
				z.setChildPointer(j, y.getChildPointer(j+degree));			
		//book say to set number of y object  to degree - 1 but I don't think that
		//makes sense here since the node has an arrayList of objects	
		}
		
		for(int j = currentNode.numOfObjects() + 1; j >= childIndex +1; j--) 
			currentNode.setChildPointer(j+1, currentNode.getChildPointer(j));
		
		currentNode.setChildPointer(childIndex+1, z.getNodePointer());				//update the child pointer of parent 
		
		for (int j = currentNode.numOfObjects(); j >= childIndex; j--)
			currentNode.putObject(j+1, currentNode.removeKeyObjectAt(j));
	
		currentNode.putObject(childIndex, y.removeKeyObjectAt(degree));
		//book say to set number of x objects  to number of x objects + 1 but I don't think that
		//makes sense here since the node has an arrayList of objects
		storage.nodeWrite(currentNode);
		storage.nodeWrite(y);
		storage.nodeWrite(z);
	}		
	
	public int getNumOfTreeNodes() {
		return numOfTreeNodes;
	}
}
