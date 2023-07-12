import java.awt.*; // import all classes from this package 

public class PP5{

// Static method that draws horizontal bars 
	public static void drawHorizontalFigures(Graphics g, int x, int y, int boxSize, int pairs){

		for(int i = 0; i < 2*pairs; i++){

			g.setColor(Color.BLACK); // reset the color for each square box

		/* Set the white color of panel for every alternate square box */
			if((i+1) % 2 == 0)
				g.setColor(Color.WHITE);
			// Draw the square box 				
			g.fillRect(x + boxSize*i, y,  boxSize, boxSize);

			// mark blue cross on boxes at odd place
			if((i+1) % 2 == 1){

				g.setColor(Color.BLUE);
				// draws the lower-diagonal 
				g.drawLine(x + boxSize*i, y, x + boxSize*(i+1), y + boxSize);
				// draws the upper diagonal 
				g.drawLine(x + boxSize*(i+1), y, x + boxSize*i, y + boxSize);
				
			}
			
		}

	}

// Static method for drawing the grid of square boxes 
	public static void drawGrid(Graphics g, int x, int y, int boxSize, int rowOffSet, int pairs){

		final int VERTICAL_GAP = 2; // set the vertical space between two rows 

		for(int i = 0; i<2*pairs; i++){		
		// for adding row offset to even number of rows  
			if((i + 1) % 2 == 0)
				drawHorizontalFigures(g, x + rowOffSet, y + boxSize*i + VERTICAL_GAP*i, boxSize, pairs);
		// No need to add offset to odd number of rows  
			else
				drawHorizontalFigures(g, x, y + boxSize*i + VERTICAL_GAP*i, boxSize, pairs);
		}

	}

	// main driver method 

	public static void main(String[] args) {
		
		DrawingPanel panel = new DrawingPanel(650, 400); // create a panel of size 650x400
		panel.setBackground(Color.GRAY); // set the background color of panel as gray 

		Graphics g = panel.getGraphics(); // get the graphics using getGgraphics method 

		// for Cafe wall of upper left position 
		final int UPPER_LEFT_X = 0;
		final int UPPER_LEFT_Y = 0;
		final int UPPER_LEFT_PAIRS = 4;
		final int UPPER_LEFT_BOX_SIZE = 20; 

		// for Cafe wall of middle left position
		final int MID_LEFT_X = 50;
		final int MID_LEFT_Y = 70;
		final int MID_LEFT_PAIRS = 4;
		final int MID_LEFT_BOX_SIZE = 30;

		// for Cafe wall of lower left position
		final int LOWER_LEFT_X = 10;
		final int LOWER_LEFT_Y = 150;
		final int LOWER_LEFT_PAIRS = 4;
		final int LOWER_LEFT_BOX_SIZE = 25;
		final int LOWER_LEFT_OFFSET = 0; 

		// for cafe wall of lower middle position 
		final int LOW_MID_X = 250;
		final int LOW_MID_Y = 200;
		final int LOW_MID_PAIRS = 3;
		final int LOW_MID_BSIZE = 25;
		final int LOW_MID_OFFSET = 10; 

		// for Cafe wall of lower right position
		final int LOW_RIGHT_X = 425; 
		final int LOW_RIGHT_Y = 180;
		final int LOW_RIGHT_BOX_SIZE = 20;
		final int LOW_RIGHT_OFFSET = 10;
		final int LOW_RIGHT_PAIRS = 5;

		// for Cafe wall of upper right position
		final int UP_RIGHT_X = 400;
		final int UP_RIGHT_Y = 20;
		final int UP_RIGHT_BOX_SIZE = 35;
		final int UP_RIGHT_OFFSET = 35;
		final int UP_RIGHT_PAIRS = 2;

		//  draw the cafe wall of upper left position 
		drawHorizontalFigures(g, UPPER_LEFT_X, UPPER_LEFT_Y, UPPER_LEFT_BOX_SIZE, UPPER_LEFT_PAIRS);
		//  draw the cafe wall of middle left position 
		drawHorizontalFigures(g, MID_LEFT_X, MID_LEFT_Y, MID_LEFT_BOX_SIZE, MID_LEFT_PAIRS);

		//  draw the cafe wall of lower left position
		drawGrid(g, LOWER_LEFT_X, LOWER_LEFT_Y, LOWER_LEFT_BOX_SIZE, LOWER_LEFT_OFFSET, LOWER_LEFT_PAIRS);
		//  draw the cafe wall of lower middle position
		drawGrid(g, LOW_MID_X, LOW_MID_Y, LOW_MID_BSIZE, LOW_MID_OFFSET, LOW_MID_PAIRS);
		//  draw the cafe wall of lower right position
		drawGrid(g, LOW_RIGHT_X, LOW_RIGHT_Y, LOW_RIGHT_BOX_SIZE, LOW_RIGHT_OFFSET, LOW_RIGHT_PAIRS);
		//  draw the cafe wall of upper right position
		drawGrid(g, UP_RIGHT_X, UP_RIGHT_Y, UP_RIGHT_BOX_SIZE, UP_RIGHT_OFFSET, UP_RIGHT_PAIRS);

	}
}