/** Packages for the used classes in the program *****/
import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class CarRacing extends Application {
	
	// main driver method 
	public static void main(String[] args) {	
		launch(args);

	}

	// overidden method of Application class 
	@Override
	public void start(Stage stage){

/** Use Circle class to draw car's wheels **/
		Circle wheel1 = new Circle(90, 110, 10);
		Circle wheel2 = new Circle(140, 110, 10);
		Circle wheel3 = new Circle(90, 220, 10);
		Circle wheel4 = new Circle(140, 220, 10);
		Circle wheel5 = new Circle(90, 320, 10);
		Circle wheel6 = new Circle(140, 320, 10);

/** Use polygon class to draw car's body **/		
		Polygon car1 = new Polygon(100, 60,
								   130, 60,
								   150, 80,
								   180, 80,
								   180, 110,
								   50, 110,
								   50, 80,
								   80, 80,
								   100, 60);
		
		Polygon car2 = new Polygon(100, 170,
								   130, 170,
								   150, 190,
								   180, 190,
								   180, 220,
								   50,  220,
								   50,  190,
								   80,  190,
								   100, 170);
		
		Polygon car3 = new Polygon(100, 270,
								   130, 270,
								   150, 290,
								   180, 290,
								   180, 320,
								   50, 320,
								   50, 290,
								   80, 290,
								   100, 270);
		
/** Use setFill method to fill the color within the car's body **/	
/** Use setStroke method fill the outline of the car's body **/
		car1.setFill(Color.rgb(255, 165, 0));
		car1.setStroke(Color.BLUE);
		car2.setFill(Color.GREEN);
		car2.setStroke(Color.RED);
		car3.setFill(Color.BLUE);
		car3.setStroke(Color.RED);

/** Use line class to draw separators **/	
		Line line1 = new Line(50, 140, 1050, 140);
		line1.setStroke(Color.BLUE);
		
		Line line2 = new Line(50, 240, 1050, 240);
		line1.setStroke(Color.BLUE);
		
		Line line3 = new Line(50, 340, 1050, 340);
		line1.setStroke(Color.BLUE);
/*** Push all the shapes in the Pane object **/				
		Pane pane1 = new Pane(car1, car2, car3, wheel1, wheel2, 
								wheel3, wheel4, wheel5, wheel6, 
								line1, line2, line3);
		
		Scene scene = new Scene(pane1, 1100, 370);
		// set the scene in the stage 
		stage.setScene(scene);
/** Window title **/
		stage.setTitle("Car Racing");
		stage.show();
	}
}