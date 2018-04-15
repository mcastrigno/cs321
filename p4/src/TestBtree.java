
public class TestBtree {

	public static void main(String[] args) {
		
		//Test Case # 1 insert 3 objects in a tree of degree 2
		
		long A,B,C, D, E, F, G, H, I, J, K, L, M, N;
		A = 8;
		B = 1;
		C = 5;
		D = 2;
		E = 6;
		F = 7;
		G = 3;
		H = 4;
		I = 9;
		J = 10;
		K = 11;
		L = 12;
		M = 13;
		N = 14;
		
		int degree = 3;
		int sequenceLength = 3;
		TreeObject ObjectA, ObjectB, ObjectC, ObjectD, ObjectE, ObjectF, ObjectG, ObjectH, 
				   ObjectI, ObjectJ, ObjectK, ObjectL, ObjectM, ObjectN;
		
		ObjectA = new TreeObject(A);
		ObjectB = new TreeObject(B);
		ObjectC = new TreeObject(C);
		ObjectD = new TreeObject(D);
		ObjectE = new TreeObject(E);
		ObjectF = new TreeObject(F);
		ObjectG = new TreeObject(G);
		ObjectH = new TreeObject(H);
		ObjectI = new TreeObject(I);
		ObjectJ = new TreeObject(J);
		ObjectK = new TreeObject(K);
		ObjectL = new TreeObject(L);
		ObjectM = new TreeObject(M);
		ObjectN = new TreeObject(N);
		
		BTree testTree1 = new BTree(degree, sequenceLength);
		
		testTree1.insert(ObjectA); 
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}			
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectB);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}	
		System.out.println("----------------------------------------------------\n");		
		
		testTree1.insert(ObjectC);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectD);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");

		testTree1.insert(ObjectE);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");		
		
		testTree1.insert(ObjectF);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");
	
		
		testTree1.insert(ObjectG);		
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");
		
		
		testTree1.insert(ObjectH);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");
				
		testTree1.insert(ObjectI);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectJ);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectK);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");		
		
		testTree1.insert(ObjectL);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");	
		
		testTree1.insert(ObjectM);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");	
		
		testTree1.insert(ObjectN);
		for(int i = 1; i <= testTree1.getNumOfTreeNodes(); i++) {
			System.out.println(testTree1.storage.nodeRead(i).toString());
		}
		System.out.println("----------------------------------------------------\n");	
		
	}

}
