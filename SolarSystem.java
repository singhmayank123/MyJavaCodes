/** This programs displays a GUI of the solor system */

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene; 
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;
import javafx.scene.effect.DropShadow;

/* Main class */

public class SolarSystem extends Application {

/** main driver method that calls the static method launch to 
 * run the GUI application */
	public static void main(String[] args) throws Exception {
		
		launch(args);
	}

	@Override // for stating the method overriding 

	public void start(Stage stage){

		final int SCENE_WIDTH = 700;  // set the scene width
		final int SCENE_HEIGHT = 600; // for scene height

	// for labelling the GUI 
		Text text = new Text("The Solar System");
		text.setFill(Color.BLUE); // set the text color as blue 
		text.setStyle("-fx-font-size:30px"); // set the font-sie 30px
		text.setX(SCENE_WIDTH/3); // set the X-cordinate of text
		text.setY(SCENE_HEIGHT/5); // set the Y-cordinate of text

	// for dropping a shadow to the sun 
		DropShadow shadow = new DropShadow();
		shadow.setSpread(0.6); // set the spread value for spread the sun's rays 
		shadow.setRadius(100); // set the radius of spread 
		shadow.setColor(Color.rgb(254, 247, 144)); // set the color of spread 

	// create an object of Circle to draw sun 
		Circle sun = new Circle(0, SCENE_HEIGHT/2, 50, Color.rgb(246, 166, 17));
	// set the strokes to sun
		sun.setStroke(Color.rgb(254, 247, 144));
	// set the stroke width 
		sun.setStrokeWidth(4);
	// set the shadow effect to the sun 
		sun.setEffect(shadow);

	// create name of each planet 
		Text planetNames[] = { 
			new Text("Mercury"), new Text("Venus"), new Text("Earth"),
			new Text("Mars"), new Text("Jupiter"), new Text("Saturn"), 
			new Text("Uranus"), new Text("Neptune"), new Text("Pluto")
			 };
	// set the alignment of planet names 
		for(int i = 1; i<=planetNames.length; i++){
			planetNames[i-1].setX(SCENE_WIDTH/12 + 60*i);
			if(i >= 5)
				planetNames[i-1].setX(SCENE_WIDTH/12 + 60*i + 50);
			planetNames[i-1].setY(((double)SCENE_HEIGHT/2.5));
			planetNames[i-1].setRotate(-45);
			planetNames[i-1].setFill(Color.WHITE);
		}

		int RAD1 = 20; // used for the radius of first planet 
		int RAD2 = 0; // used for the radius of SECOND planet
		int SPACE = 0; // used for spacing between two planets 
		int width = SCENE_WIDTH/6; // set the initial width of the planet 

		final int NUM_PLANETS = 9; // for number of planets 

		// create an array of Circle for drawing each planet 
		Circle planets[] = new Circle[NUM_PLANETS];

		for(int i = 0; i<NUM_PLANETS; i++){

		// set the radius and spaces for smalller planets.
		/* setting different radii because some planets are smaller and 
		 some are bigger */
			if((i >= 1 && i < 4) || i > 5){
				RAD1 = RAD2 = SPACE = 20;
			}
		/* raidus and space for the 4th index planet */	
			if(i == 4){
				RAD1 = 40;
				RAD2 = 35;
				SPACE = 5;
			}
		/* for 5th index planet */
			if(i == 5){

				RAD1 = 35;
				RAD2 = 20;
				SPACE = 30;

			}
		// for pluto 
			if(i == 8){
				RAD1 = 10;
			}
		/** this width will contain the initial point for the first planet,
		 * keep adding the previous covered width to align the center of X
		 * coordinate for the new planet */
		 
			width += (RAD1 + RAD2 + SPACE);
		/** initialize the Circle object with parameters width as X-cordinate of center, 
		 * second parameter as the Y-cordinate and third one is for the radius */
			planets[i] = new Circle(width, SCENE_HEIGHT/2, RAD1);
					
		}

		/* Set the color of each planet */

		planets[0].setFill(Color.rgb(151, 151, 159));
		planets[1].setFill(Color.rgb(239, 239, 239));
		planets[2].setFill(Color.rgb(59, 93, 56));
		planets[3].setFill(Color.rgb(142, 106, 90));
		planets[4].setFill(Color.rgb(64, 68, 54));
		planets[5].setFill(Color.rgb(123, 120, 105));
		planets[6].setFill(Color.rgb(187, 225, 228));
		planets[7].setFill(Color.rgb(62, 102, 249));
		planets[8].setFill(Color.rgb(255, 241, 213));
		/* embed each node to the pane */
		Pane pane = new Pane(text, sun);
		pane.getChildren().addAll(planetNames);
		pane.getChildren().addAll(planets);

		// Create a Scene object
		Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT, Color.BLACK);
		// set the scene to the stage object 
		stage.setScene(scene);

		// set the title of the stage 
		stage.setTitle("The Solar System");
		// call the show method to display the stage 
		stage.show();		
	
	}
	
}