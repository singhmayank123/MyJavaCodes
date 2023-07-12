/** This programs displays a GUI of growth rings of 5 year old tree */

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene; 
import javafx.scene.Group;
import javafx.scene.paint.Color; 
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;

/* Main class */

public class GrowthRings extends Application {

/** main driver method that calls the static method launch to 
 * run the GUI application */
	public static void main(String[] args) throws Exception {
		
		launch(args);
	}

	@Override // for stating the method overriding 

	public void start(Stage stage){

		final double CENTER_X = 300; // for the X coordinate of ring center
		final double CENTER_Y = 300; // for the Y coordinate of ring center

	// FOr group different controls 
		Group group = new Group();

		for(int i = 5; i > 0; i--){

			// create Circle object for drawing the ring 
			Circle rings = new Circle(CENTER_X, CENTER_Y, 40*i);

			// switch statement to give different color shade to each ring 
			switch(i){
				case 1:
					rings.setFill(Color.rgb(245, 193, 140));
					break;

				case 2:
					rings.setFill(Color.rgb(179, 105, 27));		
					break;
				case 3:
					rings.setFill(Color.rgb(245, 175, 105));
					break;

				case 4:
					rings.setFill(Color.rgb(219, 132, 44));
					break;

				case 5:
					rings.setFill(Color.rgb(99, 54, 8));
					
					break;

			}
			
			// text node displaying the age of each ring  
			Text text = new Text((rings.getCenterX() - rings.getRadius() + 5), rings.getCenterY() + 10, (""+i+"yr"));
			text.setFont(new Font(16));
			// add the rings into group lists
			group.getChildren().add(rings);
			// add the text node into group lists
			group.getChildren().add(text);
	
		}

		// Create a Scene object
		Scene scene = new Scene(group, 600, 600, Color.BLACK);
		// set the scene to the stage object 
		stage.setScene(scene);

		// set the title of the stage 
		stage.setTitle("Growth Rings of a Tree");
		// call the show method to display the stage 
		stage.show();		
	
	}
	
}