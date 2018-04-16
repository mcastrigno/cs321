

public class TestTree2 {

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
		System.out.println(testTree1.toString());			
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectB);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");		
		
		testTree1.insert(ObjectC);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectD);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");

		testTree1.insert(ObjectE);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");		
		
		testTree1.insert(ObjectF);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");
	
		
		testTree1.insert(ObjectG);		
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");
		
		
		testTree1.insert(ObjectH);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");
				
		testTree1.insert(ObjectI);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectJ);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");
		
		testTree1.insert(ObjectK);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");		
		
		testTree1.insert(ObjectL);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");	
		
		testTree1.insert(ObjectM);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");	
		
		testTree1.insert(ObjectN);
		System.out.println(testTree1.toString());
		System.out.println("----------------------------------------------------\n");	
		
		System.out.println(testTree1.toString());
	}

}
