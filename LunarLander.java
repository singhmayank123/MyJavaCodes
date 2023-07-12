/** This program uses javafx functionality and should be 
 * tested with appropriate javafx plugins and other requirements
 *  */

import javafx.application.Application; 
/** for using the Scene class which contains the collection 
 * of GUI objects */
import javafx.scene.Scene; 
/** For using the Stage class which display a Application 
 * window on which the Scene is displayed */
import javafx.stage.Stage;
/* For using Group class which groups the collection of objects */
import javafx.scene.layout.Pane;
/* for referencing an image file */
import javafx.scene.image.Image;
/** for displaying an image to the GUI application */
import javafx.scene.image.ImageView;
/** for KeyEvent class **/
import javafx.scene.input.KeyEvent;
/** for EventHandler class**/
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

/* ImageChanger class that implements the Application class 
for the required JavaFx application */

public class LunarLander extends Application{

	private int WIDTH = 400; // for the width and height of the scene 
	private int initialY = WIDTH/2; // for positioning initial Y coordinate of lander
	private int initialX = WIDTH/3; // for initial Y 
	
	// main driver method 
	public static void main(String[] args) {
		
		/** A static method defined in the Application class that 
		 * internally invokes the start method and pass the object of
		 * Stage object */
		launch(args);
	}

	/* An overridden method of Application class that is invoked by 
	the launch method */
	@Override
	public void start(Stage stage){

		// open the lunar surface image 	
		Image img1 = new Image("lunar_surface.png");
		// set the image on image viewer 
		ImageView imageViewer1 = new ImageView(img1);

		imageViewer1.setFitWidth(WIDTH);
		imageViewer1.setFitHeight(WIDTH);

		// open the lunar lander image 
		Image img2 = new Image("lunar_lander.png");
		// set the image on image viewer 
		ImageView imageViewer2 = new ImageView(img2);

		// set the x and y coordinates of the lunar lander image  
		imageViewer2.setX(initialX);
		imageViewer2.setY(initialY);
	
		/** set the image viewer in the pane object **/
		Pane pane = new Pane(imageViewer1, imageViewer2);
		// Pass the imageViewer object to the Scene object type 
        Scene scene = new Scene(pane, WIDTH, WIDTH);

		// Register a KEY_PRESSED handler for the scene.
		scene.setOnKeyPressed(event ->
		{		
			// check if space bar is pressed 
			if(event.getCode() == KeyCode.SPACE){
				
				/* if so, then decrement the y coordinate by 20 for each occured event to 
				move the lunar lander image up by 20 pixels  **/
				initialY -= 20;
				/** set the y coordinate to apply the effect on the imageViewer2 **/
				imageViewer2.setY(initialY);
			}
		});
           //Adding scene to the stage 
        stage.setScene(scene); 

         
        //Setting title to the Stage
        stage.setTitle("Image Changer"); 

	      //Displaying the contents of the stage 
	    stage.show(); 
	}
}