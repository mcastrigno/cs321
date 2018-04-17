import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 * 
 * @author Matthew Castrigno
 *
 */
public class DiskStorage {
	
		private RandomAccessFile rafObject;
		private final String mode = "rw";
		private String fileName;
		private int degree;
		private int sequenceLength;
		
		public DiskStorage(String BaseFileName, int degree, int sequenceLength) {
			this.degree = degree;
			this.sequenceLength = sequenceLength;
			this.fileName = "BaseFileName" +".btree.data." + sequenceLength + "." + degree;
			try {
				rafObject = new RandomAccessFile(fileName, mode);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void nodeWrite(BTreeNode root) {
			// TODO Auto-generated method stub
			
		} 
		
		public BTreeNode nodeRead(int location){
			//TODO 
			return null;
		}
	}

