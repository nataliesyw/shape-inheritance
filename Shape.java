
/**
 * The rectangle class is used to represent the shape in a corresponding shape patterns
 * @author natalie
 *
 */
public class Shape {
	
		//initialize the empty shape with a 2D boolean array
		boolean [][] pattern = new boolean[0][0];
		
		/**
		 * The Shape method is used to generate the 2D boolean array 
		 * @param pattern 2D boolean array to store the pattern of the shape
		 */
		public Shape(boolean[][] pattern){
			this.pattern = pattern;
		}
		
		
	
		
		
		/** convert the boolean value in the array into string
		 * @return return a drawing of the shape as a String 
		 */
		public String toString() {
			String str = "";
			for (int row = 0; row < pattern.length; row++) {
				for (int col = 0; col < pattern[0].length; col++) {
					
					if (pattern[row][col]) {
						str += "*";
					}
					else {
						str+=" ";			
					}
				}
			str+= "\n";
			}
			//eliminate the unnecessary space line
			str = str.substring(0, str.length()-1);
			return str;
		}
		
		
		/**
		 * count the area of the shape 
		 * @return Return the integer value of the area, i.e., the number of "*" in the shape.
		 */
		public int getArea() {
			int area = 0;
			for (int row = 0; row < pattern.length; row++) {
				for (int col = 0; col < pattern[0].length; col++) {
					if (pattern[row][col]) {
						area++;
					}
				}
			}
			return area;
		}
		
		
		/**
		 * Finding the intersection of this shape object and another shape object
		 * @param s Shape object to be pass through for the intersection comparison 
		 * @return Return a new Shape object representing the intersection of this Shape object and s
		 */
		public Shape intersect(Shape s) {
			
			//initialize the result row and column size of the intersection 
			int result_row = 0, result_col = 0;
			
			//smaller pattern row length to be the result row
			if (this.pattern.length > s.pattern.length) {
				result_row = s.pattern.length;
			}
			else {
				result_row = this.pattern.length;
			}
			//smaller pattern col length to be the result col
			if (this.pattern[0].length > s.pattern[0].length) {
				result_col = s.pattern[0].length;
			}
			else {
				result_col = this.pattern[0].length;
			}
			 
			boolean [][] result = new boolean [result_row][result_col];
			for (int row = 0; row < result_row; row ++) {
				for (int col = 0; col < result_col; col++) {
					//intersect if both are true
					if (this.pattern[row][col] && s.pattern[row][col]) {
						result[row][col] = true;
					}
					else {
						result[row][col] = false;
					}
				}
			}
			Shape result_arr = new Shape(result);
			return result_arr;
		}
		
		/**
		 * Finding the union of this shape object and another shape object
		 * @param s shape object to be pass through for the union comparison 
		 * @return Return a new Shape object representing the union of this Shape object and s.
		 */
		public Shape union(Shape s) {
			
			//initialize the result row and column size of the union 
			int result_row = 0, result_col = 0;
			
			//smaller row is used for the union comparison
			//larger row is used for result row
			if (this.pattern.length > s.pattern.length) {
				result_row = this.pattern.length;
			}
			else {
				result_row = s.pattern.length;
			}
			//smaller column is used for the union comparison
			//larger column is used for result column
			if (this.pattern[0].length > s.pattern[0].length) {
				result_col = this.pattern[0].length;
			}
			else {
				result_col = s.pattern[0].length;
			}
			
			boolean [][] result = new boolean [result_row][result_col];
			
			//initialize the whole pattern to be false for the spaces
			for (int i = 0; i < result_row; i++) {
				for (int j = 0; j < result_col; j++) {
					result[i][j] = false;
				}
			}
			
			//this Shape object
			for (int i = 0; i < this.pattern.length; i++) {
				for (int j = 0; j < this.pattern[0].length; j++) {
					if (this.pattern[i][j]==true) {
						result [i][j] = true;
					}
				}
			}
			
			//s Shape object
			for (int i = 0; i < s.pattern.length; i++) {
				for (int j = 0; j < s.pattern[0].length; j++) {
					if (s.pattern[i][j]==true) {
						result[i][j] = true;
					}
				}
			}
			
			Shape result_arr = new Shape(result);
			return result_arr;
		}
	}


