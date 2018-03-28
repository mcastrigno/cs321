import java.util.ArrayList;
//import java.util.LinkedList;

/**
 * @author James Brooks
 * @author Matthew Castrigno added some methods and instance variables, changed some names to be more descriptive
 *                           added toString for debugging, modified constructor
 *
 */
public class BTreeNode {
	private int objectCount;
	
	private int location; //byte offset of this node in file
	private int nodePointer; //Consistent but descriptive name
	
	//private int degree;
	
	private boolean leaf =  false;  //default value 
//	private LinkedList<TreeObject> objects; //Maybe array is better???	
	private ArrayList<TreeObject> objects;  //Array list was suggest by Yeh and the tutor
	private int parentPointer; //pointer to byte offset location of parent in file
	
	private int[] child; //pointers to byte offset locations of children in file
	private ArrayList<Integer> childPointers = new ArrayList<Integer>(); // May be best to use ArrayList so the size can expand and contract automatically
												
	private TreeObject dummyTreeObject = new TreeObject(0) ;
	
	public BTreeNode(int nodePointer) {
		this.nodePointer = nodePointer;
		this.objects = new ArrayList<TreeObject>();
		objects.add(dummyTreeObject);    	//this is a dummy object so we can index from one
		childPointers.add(0);  				//this is a dummy childPointer so we can index from one 
		

	}
	public int numOfObjects() {
		return objects.size() - 1;
	}
	public int numOfChildren() {
		return childPointers.size() - 1;
	}
	
	public int getNodePointer() {
		return nodePointer;
	}
	
	public int getParentPointer() {
		return parentPointer;
	}
	
	public int getChildPointer(int i) {
		return childPointers.get(i);
	}
	
	/**
	 * 
	 * @param i location in node to put object.
	 * 			When this operation adds an object we use an add operation.
	 * 			If i is in current range then the set operation is used
	 */
	public void putObject(int i, TreeObject newObject) {
		if (i == objects.size()) {
			objects.add(newObject);
		}else if ((i <= 1) && (i < objects.size())) {
			objects.set(i, newObject);
		}
		else {
			System.out.println("Invalid operation, attempted to add object at index : " + i + " but number of nodes is : " + objects.size());
		}
		
	}
	
	
	
	public boolean isLeaf() {
		return leaf;
	}
	

	public void setLeaf(boolean isLeaf) {
		leaf = isLeaf;
	}
	
	public long key(int i) {
		return objects.get(i).getData();
	}
	
	//not sure about this, our objects are more than the key, this returns the object not the key of the object
	public TreeObject keyAt(int i) {
		return objects.get(i);
	}
	
	public int getObjectCount() {
		return objectCount;
	}

	public int getLocation() {
		return location;
	}
	
	public int getChildAt(int i) {
		return child[i]; //not sure if array is the correct approach
	}
	
	public void setChildAt(int i, BTreeNode child) {
		this.child[i] = child.getLocation(); //???? the child array needs to allocated somewhere
	}
	
	public String toString() {
		String returnString = " Node located at pointer "+ nodePointer + " has " + numOfObjects() + " objects and " + numOfChildren() + " children.\n";
		for (int i= 1; i < objects.size(); i++) {  // Deliberately skipping the first one, its a dummy
			returnString = returnString + "Object [" + i + "]" + " has key value of " + key(i) + "\n" ;
		}
		returnString = returnString +"/n";
		for (int i = 1; i < childPointers.size(); i++) {
			returnString = returnString + "ChildPointer [" + i + "]" + " is " +childPointers.get(i) +"\n";
		}
		return returnString;
	}
	
	
}
