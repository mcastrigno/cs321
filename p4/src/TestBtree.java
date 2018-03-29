
public class TestBtree {

	public static void main(String[] args) {
		
		//Test Case # 1 insert 3 objects in a tree of degree 2
		
		long A,B,C;
		A = 3;
		B = 1;
		C = 5;
		
		int degree = 2;
		int sequenceLength = 2;
		TreeObject ObjectA, ObjectB, ObjectC;
		
		ObjectA = new TreeObject(A);
		ObjectB = new TreeObject(B);
		ObjectC = new TreeObject(C);
		
		BTree testTree1 = new BTree(degree, sequenceLength);
		
		testTree1.insert(ObjectA); 
		testTree1.insert(ObjectB);
		testTree1.insert(ObjectC);
		
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}

	}

}
