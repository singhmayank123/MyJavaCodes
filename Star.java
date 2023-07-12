/** This programs displays a GUI of a sample star that 
 * includes a text for the name within it */

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.text.Text;
import javafx.scene.shape.Polygon;

/* Main class */

public class Star extends Application {

/** main driver method that calls the static method launch to 
 * run the GUI application */
	public static void main(String[] args) throws Exception {
		
		launch(args);
	}

	@Override // for stating the method overriding 

	public void start(Stage stage){

		// Create a Polygon object for drawing the star
		Polygon star = new Polygon(

				400, 100,
				450, 200,
				550, 200,
				465, 250,
				495, 335,
				400, 285,
				295, 335,
				325, 250,
				250, 200,
				350, 200,
				400, 100
			);
		// fill the polygon with white color
		star.setFill(Color.WHITE);
		// set the border stroke
		star.setStroke(Color.BLACK);
		// set the width of the stroke
		star.setStrokeWidth(5);

		// create a Text node for embedding into the star
		Text text = new Text();
		// set the text with the name 
		text.setText("Person P");
		// set the coordinates of text to place it in between the star
		text.setX(375);
		text.setY(225);

		// embed the nodes into the Pane object
		Pane pane = new Pane(star, text);

		// Create a Scene object
		Scene scene = new Scene(pane, 800, 600, Color.rgb(135,206,235));
		// set the scene to the stage object 
		stage.setScene(scene);

		// set the title of the stage 
		stage.setTitle("Star");
		// call the show method to display the stage 
		stage.show();		
	
	}
	
}