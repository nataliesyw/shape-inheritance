
/**
 * The subclass of shape
 * The Rectangle class is used to represent the shape in a rectangular pattern
 * @author natalie
 *
 */
public class Rectangle extends Shape {
	/**
	 * Constructor, create a rectangle with the specific width and height
	 * @param width integer value of the width of the rectangle
	 * @param height integer value of the height of the rectangle
	 */
	public Rectangle(int width, int height){
		super(new boolean[height][width]);
		//assign the true value to the pattern
		for (int row = 0; row < super.pattern.length; row++ ) {
			for (int col = 0;col < super.pattern[0].length; col++) {
				super.pattern[row][col] = true;
			}
		}
	}
}
