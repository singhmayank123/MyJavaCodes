/** This program uses javafx functionality and should be 
 * tested with appropriate javafx plugins and other requirements
 *  */

/** This program changes the image when a mouse hovers on it and
 * gets change to initial image when the mouse exits **/


import javafx.application.Application; 
/** For using the Stage class which display a Application 
 * window on which the Scene is displayed */
import javafx.stage.Stage;
/** for using the Scene class which contains the collection 
 * of GUI objects */
import javafx.scene.Scene; 
/* For using Pane class  */
import javafx.scene.layout.Pane;
/* for referencing an image file */
import javafx.scene.image.Image;
/** for displaying an image to the GUI application */
import javafx.scene.image.ImageView;


/* ImageChanger class that implements the Application class 
for the required JavaFx application */

public class ImageChanger extends Application{


	// main drived method 
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

		// open an image for unhovered state
		Image img = new Image("smiley.png");
		// set the image on image viewer 
		ImageView imageViewer = new ImageView(img);

		// set the aspect ratio of the image viewer
		imageViewer.setFitWidth(400);
		imageViewer.setFitHeight(400);
		// to avoid improper image stretching 
		imageViewer.setPreserveRatio(true);

		/** register an event handler to the imageViewer for the mouse entered event **/
		imageViewer.setOnMouseEntered((e) -> {
			/** open the hovered state image **/
			Image hoveredImg = new Image("gray.png");
			/** set the image that displays when mouse hovers **/
			imageViewer.setImage(hoveredImg);

		});

		/** register an event handler to the imageViewer for the mouse exited event **/
		imageViewer.setOnMouseExited((e) -> {
			/** set the image again that were set at idle state **/
			imageViewer.setImage(img);
			
		});

		/** set the image viewer in the pane object **/
		Pane pane = new Pane(imageViewer);
		// Pass the imageViewer object to the Scene object type 
        Scene scene = new Scene(pane, 400, 400);

        //Setting title to the Stage
        stage.setTitle("Image Changer"); 

        //Adding scene to the stage 
        stage.setScene(scene); 
         
	      //Displaying the contents of the stage 
	    stage.show(); 
	}
}