import java.awt.*; // import the all classes from java.awt package 

public class PP2{

	// main driver method 
	public static void main(String[] args) {

		// create a drawing panel of size 200x200	
		DrawingPanel panel = new DrawingPanel(200, 200);

		// call the getGraphics method to draw on the panel 
		Graphics g = panel.getGraphics();

		// pass the graphics object to the drawFigure to draw the given figure 
		drawFigure(g);

	}

	// Static method that draws the given fugure 

	public static void drawFigure(Graphics g){

		final int ROWS = 3; // for no. of rows 
		final int COLS = 3; // for no. of columns 

		/* The loop runs ROws * COLS times */
		for (int i = 0; i<ROWS; i++) {

			for(int j = 0; j<COLS; j++){
		/** start drawing the square box from (10, 10), keep size 50x50 for
		 * each box, which X and Y cordinates changes by 50 pixel for each box */
				int x = 10 + 50*j; 
				int y = 10 + 50*i;
		/* Set the Black color for the panel */
				g.setColor(Color.BLACK);
		/* draw each square box for each iteration of the loop */
				g.drawRect(10 + 50*i, 10 + 50*j, 50, 50);
		/* Check for the indices. If they matches for the box that contains texts then 
		run the statements of this block */
				if((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)){
					// set the font for the texts 
					g.setFont(new Font("SansSerif", Font.BOLD, 15));
				// set the color of each box text 
					if((i == 1 && j == 1))
						g.setColor(Color.LIGHT_GRAY);
					if((i == 2 && j == 0))
						g.setColor(Color.GRAY);
					if((i == 0 && j == 2))
						g.setColor(Color.DARK_GRAY);
				// write the below text in the square box 
					g.drawString("I", x+25, y+15);
					g.drawString("Love", x+10, y+27);
					g.drawString("Java", x+10, y+42);
					
				}
		/* for ladder-type patterns */
				if((i == 0 && j == 1) || (i == 1 && j == 0) || (i == 2 && j == 2)){
				// set the different colors to each matched box contents 
					if((i == 2 && j == 2))
						g.setColor(Color.LIGHT_GRAY);
					if((i == 0 && j == 1))
						g.setColor(Color.GRAY);
					if((i == 1 && j == 0))
						g.setColor(Color.DARK_GRAY);
			// run another for-loop to draw the pattern
					for(int k = 1; k <= 4; k++){

						g.drawLine(x + 5*k, y + 5*(k-1), x + 5*k, y + (50 - 5*k));
						g.drawLine(x + 5*k, y + 5*k, x + (50 - 5*(k-1)), y + 5*k);
						g.drawLine( x + (50 - 5*k), y + (50 - 5*(k-1)), x + (50 - 5*k), y + 5*(k));
						g.drawLine( x + 5*(k-1) , y + (50 - 5*k), x + (50 - 5*k), y + (50 - 5*k));
						g.drawLine( x + 25, y + 20, x + 25, y + 30);
						g.drawLine( x + 20, y + 25, x + 30, y + 25);
					}
					
				
				}

				// for ellipses and circles figure 

				if((i == 0 && j == 0) || (i == 1 && j == 2) || (i == 2 && j == 1)) {

					g.drawOval(x + 3,  y + 3, 20, 44); // draw first ellipse-type oval 
					g.drawOval(x + 27, y + 3, 20, 44); // draw second ellipse-type oval 
					

					if(i == 0 && j == 0)
						g.setColor(Color.LIGHT_GRAY);
					if(i == 1 && j == 2)
						g.setColor(Color.GRAY);
					if(i == 2 && j == 1)
						g.setColor(Color.DARK_GRAY);

					// draw and fill circles within the ellipse-type ovals 
					g.fillOval(x + 3,  y + 20, 20, 20);
					g.fillOval(x + 27, y + 20, 20, 20);
										
				}
			}						
		}
	}
}