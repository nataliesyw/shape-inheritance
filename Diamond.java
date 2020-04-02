
/**
 * The subclass of shape
 * The Diamond class is used to represent the shape in a Diamond pattern
 * @author natalie
 *
 */
public class Diamond extends Shape {
	/**
	 * Constructor, create a diamond shape with the specific size
	 * @param size the integer value of the size of the diamond shape
	 */
	public Diamond(int size) {
		
		super(new boolean[size*2-1][size*2-1]);
		//initialize the number of row of the diamond
		int row = size * 2 - 1;
		//initialize the mid point of the diamond 
		int mid  = row / 2;
		//initialize the count number of asterisk in each row
		int count;
		
		//initialize the whole square to be false
		//fill in the spaces
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				super.pattern[i][j] = false;
			}
		}
		
		//generate an integer array that store the number of asterisk in each row
		int num_star[] = new int [row];
		
		//assign the number of asterisk to the corresponding row
		//upper part
		for (int i = 0; i <= mid; i++) {
			num_star[i] = i*2+1;
		}
		//lower part
		for(int i = mid+1; i < row; i++) {
			num_star[i] = num_star[row-1-i];
		}
		//fill the pattern
		for (int i = 0 ; i < row; i++) {
			
			//the number of asterisk in the row
			count = num_star[i];
			//fill in the mid point first
			super.pattern[i][mid] = true;
			
			//fill in the nearby 
			for (int j = 1; j <= count/2; j++) {
				super.pattern[i][mid-j] = true;
				super.pattern[i][mid+j] = true;
			}
		}
	    }
	}



