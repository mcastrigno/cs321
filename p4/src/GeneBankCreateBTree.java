
public class GeneBankCreateBTree {

	
	static int sequenceLength;
	static BTree newBTree;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int degree = 0;  // need code to read in degree and other arguements
		
		
		if(degree == 0) {
			degree = findOptimumDegree();
		}
		else if (degree== 1) {
			System.out.println("Invalid degree of 1, fix code to reject at command line");
			System.exit(1); 
		}
		 newBTree = new  BTree(degree, sequenceLength) ;
		
	}

	/**
	 * Estimates the optimum degree for the BTree assuming
	 * the disk block size is 4096 bytes. Taken from
	 * class notes
	 * 
	 * @return optimum degree for BTree
	 */
	static int findOptimumDegree() {
		int optimumDegree = 2;
		while((5 + (((2*optimumDegree) - 1) * 12) + (((2*optimumDegree) - 1) * 4)) <= 4096){
			optimumDegree++;
		}
		return optimumDegree;
	}
	

	
	
}

