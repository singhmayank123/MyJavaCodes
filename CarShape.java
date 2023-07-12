/** This program allows to display a GUI of CAR */

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.layout.Pane; 
import javafx.scene.paint.Color; 
import javafx.scene.shape.*;
         
public class CarShape extends Application {

// Overridden method  
   @Override 
   public void start(Stage stage) { 

        final int SCENE_WIDTH = 600; // for width of scene
        final int SCENE_HEIGHT = 600; // for height of scene 

        // two Circle class objects for drawing wheels 

        Circle wheel1 = new Circle(150, 400, 30, Color.rgb(114, 114, 114));
        Circle wheel2 = new Circle(350, 400, 30, Color.rgb(114, 114, 114));

        // A Polygon class object for the car's roof, which is trapezium 
        Polygon carRoof = new Polygon(
                150, 350,
                200, 275,
                300, 275,
                350, 350
        );

        // set the color of the roof 
        carRoof.setFill(Color.rgb(255, 74, 74));

        // create two rectangle class object for the car's window 
        Rectangle window1 = new Rectangle(200, 300, 50, 50);
        // set the window color 
        window1.setFill(Color.rgb(125, 221, 255));
        Rectangle window2 = new Rectangle(260, 300, 50, 50);
        window2.setFill(Color.rgb(125, 221, 255));

        // create a Rectangle class object for the car's body
        Rectangle rect = new Rectangle(100, 350, 300, 50);
        //set the color 
        rect.setFill(Color.rgb(255, 74, 74));
        
        // Pass each node to the object type of pane class 
        Pane pane = new Pane(carRoof, window1, window2, rect, wheel1, wheel2);

        // Pass the pane object to the Scene object type 
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT, Color.BLACK);
        //Setting title to the Stage
        stage.setTitle("Drawing a Car"); 

        //Adding scene to the stage 
        stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}
