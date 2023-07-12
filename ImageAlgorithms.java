/** This program uses javafx functionality and should be 
 * tested with appropriate javafx plugins and other requirements
 *  */


/** For using the Application class which is the foundation
 * of all JavaFx applications. Every JavaFx application class 
 * must extend this class */
import javafx.application.Application; 
/** for using the Scene class which contains the collection 
 * of GUI objects */
import javafx.stage.Stage;
/** For using the Stage class which display a Application 
 * window on which the Scene is displayed */
import javafx.scene.Scene; 
/** for using Insets class through which can we apply padding 
 * between nodes */
import javafx.geometry.Insets;
/** for the Button class for clicking event */
import javafx.scene.control.Button;
/** for the TextField class for creating a text field at the bottom */ 
import javafx.scene.control.TextField;
/** for VBox class which positions the nodes vertically */
import javafx.scene.layout.VBox;
/** for HBox class which positions the node horizontally */
import javafx.scene.layout.HBox;
/** for FileChooser class that opens a window to choose a file */
import javafx.stage.FileChooser;
/** for filling the colors */
import javafx.scene.paint.Color;
/** for detecting the event listener when a button clicks */
import javafx.event.ActionEvent;
/* for referencing an image file */
import javafx.scene.image.Image;
/** for displaying an image to the GUI application */
import javafx.scene.image.ImageView;
/** for using WritableImage class to interact with the image pixels */
import javafx.scene.image.WritableImage;
/** for applying effects to the node object */
import javafx.scene.effect.BoxBlur;
/** for reading a pixel from an image */
import javafx.scene.image.PixelReader;
/** for modifying the image pixel */
import javafx.scene.image.PixelWriter;
/** for providing filtered extensions for the choosing a file */
import javafx.stage.FileChooser.ExtensionFilter;
/** for the File class */
import java.io.File; 
import javax.imageio.ImageIO;
// 	for reading and writing to an Image file 
import java.awt.image.BufferedImage;
/** for converting an image to the BufferedImage */
import javafx.embed.swing.SwingFXUtils;

// Main application class 
public class ImageAlgorithms extends Application {

	private int zoomLevel = 1; // for zooming factor 
	private double newWidth, newHeight, oldWidth, oldHeight; // for the image height and width of the main image viewer
	private File file = null; // for referencing to an image filw
	private Image inputImage = null; // for the main image 

	// main drived method 
	public static void main(String[] args) {
	
	// static method of application class 	
		launch(args);

	}

	// An overriden method of Application class 
	@Override
	public void start(Stage stage){

		/** for styling when buttons are not hovered */
		String IDLE_BUTTON_STYLE = "-fx-background-color: none;";
		/** for styling when buttons are hovered */
    	String HOVERED_BUTTON_STYLE = "-fx-outer-border: transparent;";

    	//create an empty text field 
    	TextField text = new TextField("");

        // create an object of FileChooser to choose a file from local system
        FileChooser fileChooser = new FileChooser();
        // create an object of ImageView to display the main image
    	ImageView mainImageView = new ImageView();

/****** load image menu ********/
		Image load = new Image("load.jpg"); // image icon 
        ImageView loadImageView = new ImageView(load); // set image icon
        loadImageView.setFitWidth(50); // icon display width
        loadImageView.setFitHeight(50); // icon display height
        loadImageView.setPreserveRatio(true); //  for avoiding image stretching 
        // set the load image button 
		Button loadBtn = new Button("Load Image",loadImageView);
		// initial style of button 
		loadBtn.setStyle("-fx-background-color: none; ");
		// for styling when user clicks on the button 
		loadBtn.setOnMouseEntered(e -> loadBtn.setStyle(HOVERED_BUTTON_STYLE));
		// styling when user exits the cursor from the button 
        loadBtn.setOnMouseExited(e -> loadBtn.setStyle(IDLE_BUTTON_STYLE));
        
        // Register the on click event of load button 
		loadBtn.setOnAction((ActionEvent event) -> {
			// set the textfield status 
			text.setText("Load Image is applied.");
			// open the local system files to choose an image in open mode 
            file = fileChooser.showOpenDialog(stage);
        // if file exists 
            if (file != null) {
            
            /** Pass the file to the object type of Image
             * and convert the file to the string representing its URL
             * beacause the Image constructor expects a String value */ 
                inputImage = new Image(file.toURI().toString());
            /* Set the image to the image viewer */
                mainImageView.setImage(inputImage);
            /* Set the view port ratio for the Image viewer */
                mainImageView.setFitWidth(400);
                mainImageView.setFitHeight(400);
            }
		});
	/******* Save Image ***********/	
		Image save = new Image("save.jpg");
        ImageView saveImageView = new ImageView(save);
        saveImageView.setFitWidth(50);
        saveImageView.setFitHeight(50);
        loadImageView.setPreserveRatio(true);
        Button saveBtn = new Button("Save Image", saveImageView);
        saveBtn.setStyle("-fx-background-color: none; ");
        saveBtn.setOnMouseEntered(e -> saveBtn.setStyle(HOVERED_BUTTON_STYLE));
        saveBtn.setOnMouseExited(e -> saveBtn.setStyle(IDLE_BUTTON_STYLE));

       /** register the on click event for the save button */
        saveBtn.setOnAction((ActionEvent event) -> {

        // set the text of text field 
			text.setText("Save Image is applied.");

		// get the reflected image file from the main image viewer 
			Image image = mainImageView.getImage();

		    FileChooser imageSaver = new FileChooser();
		// set the title of the save window 
		    imageSaver.setTitle("Save Image File");
		// set initial directory of the save window 
		    imageSaver.setInitialDirectory(new File("C:\\"));

		// apply the selected image extensions to the save window 
		    imageSaver.getExtensionFilters().addAll(
		        new FileChooser.ExtensionFilter("PNG Files", "*.png"),
		        new FileChooser.ExtensionFilter("BMP Files", "*.bmp"),
		        new FileChooser.ExtensionFilter("BMP Files", "*.jpg"),
		        new FileChooser.ExtensionFilter("GIF Files", "*.gif"));

		// get the file reference from the save window 
		    File f1 = imageSaver.showSaveDialog(stage);

			try{

				if (f1 != null) {
					// get the file name 
				    String name = f1.getName();
				    // file extension
				    String extension = name.substring(1+name.lastIndexOf(".")).toLowerCase();
				    // write the MainImageView image to the file f1
				    ImageIO.write(SwingFXUtils.fromFXImage(image, null), extension, f1);
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		        
		});

/********** GrayScale menu *******/
   
		Image grayScale = new Image("neg.jpg");
        ImageView grayScaleImageView = new ImageView(grayScale);
        grayScaleImageView.setFitWidth(50);
        grayScaleImageView.setFitHeight(50);
        loadImageView.setPreserveRatio(true);
		Button gsBtn = new Button("GrayScale", grayScaleImageView);
		gsBtn.setStyle("-fx-background-color: none; ");
		gsBtn.setOnMouseEntered(e -> gsBtn.setStyle(HOVERED_BUTTON_STYLE));
        gsBtn.setOnMouseExited(e -> gsBtn.setStyle(IDLE_BUTTON_STYLE));

    // register the on click event     
        gsBtn.setOnAction((ActionEvent event) -> {

        	// set the textfield status 
			text.setText("GrayScale filter is applied.");

			// get the image of Main Viewer 
			Image mainImage = mainImageView.getImage();

			// for reading the image pixels 
			PixelReader pixelReader = mainImage.getPixelReader();
			// Create WritableImage image 
        	WritableImage wImage = new WritableImage(
			(int)mainImage.getWidth(),
			(int)mainImage.getHeight());

         	PixelWriter pixelWriter = wImage.getPixelWriter();

	         	// Determine the color of each pixel in a specified row
	        for(int readY=0;readY<mainImage.getHeight();readY++){
	            for(int readX=0; readX<mainImage.getWidth();readX++){
	                Color color = pixelReader.getColor(readX,readY);

	                // Now write a brighter color to the PixelWriter.
	                double gray = (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11);

	                pixelWriter.setColor(readX,readY, new Color(gray, gray, gray, 1.0));
	               
	            }
	        }

	         // Display image on screen
        	mainImageView.setImage(wImage);

		});

	/*************** Image Negative ***********/

		Image negative = new Image("neg.jpg");
        ImageView negativeImageView = new ImageView(negative);
        negativeImageView.setFitWidth(50);
        negativeImageView.setFitHeight(50);
        loadImageView.setPreserveRatio(true);
		Button negBtn = new Button("Negative", negativeImageView);
		negBtn.setStyle("-fx-background-color: none; ");
		negBtn.setOnMouseEntered(e -> negBtn.setStyle(HOVERED_BUTTON_STYLE));
        negBtn.setOnMouseExited(e -> negBtn.setStyle(IDLE_BUTTON_STYLE));
        negBtn.setOnAction((ActionEvent event) -> {
			text.setText("Negative filter is applied.");
			// get the image of mainImageView 
			Image mainImage = mainImageView.getImage();
			// get the instance of pixelReader to read image pixels 
			PixelReader pixelReader = mainImage.getPixelReader();
			// Create WritableImage
        	WritableImage wImage = new WritableImage(
			(int)mainImage.getWidth(),
			(int)mainImage.getHeight());
			// get the instance of pixelWriter to write the new pixels to the image 
         	PixelWriter pixelWriter = wImage.getPixelWriter();

	        // Determine the color of each pixel in a specified row
	        for(int readY=0;readY<mainImage.getHeight();readY++){
	            for(int readX=0; readX<mainImage.getWidth();readX++){
	                Color color = pixelReader.getColor(readX,readY);

	                // Subtract the compenent of pixel from the highest value 	
	                double red =   (double)(1 - color.getRed());
	                double green = (double)(1 - color.getGreen());
	                double blue =  (double)(1 - color.getBlue());
	                // update the pixels 
	                pixelWriter.setColor(readX,readY,Color.color(red, green, blue));
	               
	            }
	        }
	         // Display updated image on screen
        	mainImageView.setImage(wImage);
		});

/******** Rotate left *********/

		Image rLeft = new Image("rleft.jpg");
        ImageView rotateLeftImageView = new ImageView(rLeft);
        rotateLeftImageView.setFitWidth(50);
        rotateLeftImageView.setFitHeight(50);
        loadImageView.setPreserveRatio(true);
        Button rLeftBtn = new Button("Rotate Left", rotateLeftImageView);
        rLeftBtn.setStyle("-fx-background-color: none; ");
        rLeftBtn.setOnMouseEntered(e -> rLeftBtn.setStyle(HOVERED_BUTTON_STYLE));
        rLeftBtn.setOnMouseExited(e -> rLeftBtn.setStyle(IDLE_BUTTON_STYLE));
        rLeftBtn.setOnAction((ActionEvent event) -> {
			text.setText("Rotate Left filter is applied.");
			/** set the image rotation by 90 degree in the anti-clockwise direction **/
			mainImageView.setRotate(mainImageView.getRotate() + 90); 
		});

/************* Rotate right ***********/
		
        Image rRight = new Image("rRight.png");
        ImageView rotateRightImageView = new ImageView(rRight);
        rotateRightImageView.setFitWidth(50);
        rotateRightImageView.setFitHeight(50);
        loadImageView.setPreserveRatio(true);
		Button rRightBtn = new Button("Rotate Right", rotateRightImageView);
		rRightBtn.setStyle("-fx-background-color: none; ");
		rRightBtn.setOnMouseEntered(e -> rRightBtn.setStyle(HOVERED_BUTTON_STYLE));
        rRightBtn.setOnMouseExited(e -> rRightBtn.setStyle(IDLE_BUTTON_STYLE));
        rRightBtn.setOnAction((ActionEvent event) -> {
			text.setText("Rotate Right filter is applied.");
			/** set the image rotation by 90 degree in the clockwise direction **/
			mainImageView.setRotate(mainImageView.getRotate() - 90); 
		});

/************ Blur Image ***********/

		Image blur = new Image("blur.png");
        ImageView blurImageView = new ImageView(blur);
        blurImageView.setFitWidth(50);
        blurImageView.setFitHeight(50);
        loadImageView.setPreserveRatio(true);
		Button blurBtn = new Button("Blur", blurImageView);
		blurBtn.setStyle("-fx-background-color: none; ");
		blurBtn.setOnMouseEntered(e -> blurBtn.setStyle(HOVERED_BUTTON_STYLE));
        blurBtn.setOnMouseExited(e -> blurBtn.setStyle(IDLE_BUTTON_STYLE));
        blurBtn.setOnAction((ActionEvent event) -> {
			text.setText("Blur filter is applied.");
			/** create an instance of BoxBlur to apply the blur effects **/
			BoxBlur boxblur = new BoxBlur();
			mainImageView.setEffect(boxblur); // set the blur effect on the image view 
		});

/*********** Zoom In image ************/
		
		Image zoomIn = new Image("zoomin.png");
        ImageView zoomInImageView = new ImageView(zoomIn);
        zoomInImageView.setFitWidth(50);
        zoomInImageView.setFitHeight(50);
        zoomInImageView.setPreserveRatio(true);
		Button zoomInBtn = new Button("Zoom In", zoomInImageView);
		zoomInBtn.setStyle("-fx-background-color: none; ");
		zoomInBtn.setOnMouseEntered(e -> zoomInBtn.setStyle(HOVERED_BUTTON_STYLE));
        zoomInBtn.setOnMouseExited(e -> zoomInBtn.setStyle(IDLE_BUTTON_STYLE));
        zoomInBtn.setOnAction((ActionEvent event) -> {
			text.setText("Zoom in filter is applied.");
			/* get the current width and height of the image view */
			oldWidth = mainImageView.getFitWidth();
		    oldHeight = mainImageView.getFitHeight();

		    /** update the width and height by an increment of 50 pixels on every click */
		    newWidth = oldWidth + zoomLevel * 50;
		    newHeight = oldHeight + zoomLevel * 50;
	    
		    mainImageView.setFitWidth(newWidth);
		    mainImageView.setFitHeight(newWidth);
		    mainImageView.setPreserveRatio(true);
		});
/************** Zoom out Image *****************/

		Image zoomOut = new Image("zoomout.png");
		System.out.println(zoomOut);
        ImageView zoomOutImageView = new ImageView(zoomOut);
        zoomOutImageView.setFitWidth(50);
        zoomOutImageView.setFitHeight(50);
        zoomOutImageView.setPreserveRatio(true);
		Button zoomOutBtn = new Button("Zoom Out", zoomOutImageView);
		zoomOutBtn.setStyle("-fx-background-color: none; ");
		zoomOutBtn.setOnMouseEntered(e -> zoomOutBtn.setStyle(HOVERED_BUTTON_STYLE));
        zoomOutBtn.setOnMouseExited(e -> zoomOutBtn.setStyle(IDLE_BUTTON_STYLE));
        zoomOutBtn.setOnAction((ActionEvent event) -> {
			text.setText("Zoom out filter is applied.");
/* get the current width and height of the image view */
		    oldWidth = mainImageView.getFitWidth();
		    oldHeight = mainImageView.getFitHeight();
 /** update the width and height by an decrement of 50 pixels on every click */
		    newWidth = oldWidth - zoomLevel * 50;
		    newHeight = oldHeight - zoomLevel * 50;

		    mainImageView.setFitWidth(newWidth);
		    mainImageView.setFitHeight(newHeight);
		    mainImageView.setPreserveRatio(true);

		});

// place the menus in the vbox to align them verticaly 
		VBox vbox = new VBox(0, loadBtn, saveBtn, gsBtn,  negBtn,
			rLeftBtn, rRightBtn, blurBtn, zoomInBtn, zoomOutBtn);

// Align the menus and main image viewer horizontally by placing them into HBox
		HBox hbox = new HBox(30, vbox, mainImageView);

		// set the padding 
		hbox.setPadding(new Insets(20, 0 , 0, 20));

		VBox vboxNew = new VBox(20, hbox, text);

		// main scene of the GUI application 
		Scene scene = new Scene(vboxNew, 600, 600, Color.YELLOW);
		
		// set the scene to the stage window 
		stage.setScene(scene);

		stage.setTitle("CS 106A Image Algorithms");

		// for displaying the scene node within the stage window 
		stage.show();
	}
}