
public class TestBtree {

	public static void main(String[] args) {
		
		//Test Case # 1 insert 3 objects in a tree of degree 2
		
		long A,B,C, D;
		A = 3;
		B = 1;
		C = 5;
		D = 2;
		
		int degree = 2;
		int sequenceLength = 2;
		TreeObject ObjectA, ObjectB, ObjectC, ObjectD;
		
		ObjectA = new TreeObject(A);
		ObjectB = new TreeObject(B);
		ObjectC = new TreeObject(C);
		ObjectD = new TreeObject(D);
		
		BTree testTree1 = new BTree(degree, sequenceLength);
		
		testTree1.insert(ObjectA); 
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		testTree1.insert(ObjectB);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		
		
		testTree1.insert(ObjectC);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		
		testTree1.insert(ObjectD);
		
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}

	}

}
