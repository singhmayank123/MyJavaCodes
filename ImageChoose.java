/** This programs displays a GUI of an Image chooser buttton
 * and 4 sliders to change the hue, contrast, saturation and brightnesss */

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene; 
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color; 
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import java.io.File;
import javafx.scene.effect.ColorAdjust; 
/** for the File class */
import java.io.File; 
import javax.imageio.ImageIO;
//  for reading and writing to an Image file 
import java.awt.image.BufferedImage;
/** for converting an image to the BufferedImage */
import javafx.embed.swing.SwingFXUtils;
/* Main class */

public class ImageChoose extends Application {

/** main driver method that calls the static method launch to 
 * run the GUI application */
    public static void main(String[] args) throws Exception {
        
        launch(args);
    }

    @Override // for stating the method overriding 

    public void start(Stage stage){

        // create an object of FileChooser to choose a file from local system
        FileChooser fileChooser = new FileChooser();
        // create an object of ImageView for viewing the image file
        ImageView imageViewer = new ImageView();

        // Button for choosing an image from local system
        Button openButton = new Button("Choose an Image");
        // register an event handler for the openButton
        openButton.setOnAction((ActionEvent e) -> {

        // open the local system files to choose an image in open mode 
            File file = fileChooser.showOpenDialog(stage);
        // if file exists 
            if (file != null) {
            
            /** Pass the file to the object type of Image
             * and convert the file to the string representing its URL
             * beacause the Image constructor expects a String value */ 
                Image inputImage = new Image(file.toURI().toString());
            /* Set the image to the image viewer */
                imageViewer.setImage(inputImage);
            /* Set the view port ratio for the Image viewer */
                imageViewer.setFitWidth(300);
                imageViewer.setFitHeight(300);
            }
        });

        Button saveBtn = new Button("Save image");
       /** register the on click event for the save button */
        saveBtn.setOnAction((ActionEvent event) -> {

        // get the reflected image file from the main image viewer 
            Image image = imageViewer.getImage();

            FileChooser imageSaver = new FileChooser();
        // set the title of the save window 
            imageSaver.setTitle("Save Image File");
        // set initial directory of the save window 
            imageSaver.setInitialDirectory(new File("C:\\"));

        // apply the selected image extensions to the save window 
            imageSaver.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG Files", "*.png"),
                new FileChooser.ExtensionFilter("BMP Files", "*.bmp"),
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
        
        /** create an instance of ColorAdjust class for setting hue, contrast,
         * saturation and brightness of the image */

        ColorAdjust colorAdjust = new ColorAdjust();

        /** Create a slider for hue with max value 100 and minimum value -100, 
         * starts from 0 */
        Slider hue = new Slider(-100.0, 100.0, 0);
        hue.setShowTickMarks(true); // show the vertical lines on the slider 
        hue.setShowTickLabels(true); // show the numbers on the slider 
        hue.setMinorTickCount(10); // set the line counts between numbers 
        /* Register an event listener for the slider */
        hue.valueProperty().addListener(

            (observeable, oldvalue, newvalue) ->{

            /** get the value of hue. Hue lies in between
             * -1 to 1 for which divide the return value by 100 */
                double hueVal = (double)hue.getValue()/100;
            /* set the image hue */
                colorAdjust.setHue(hueVal);

                //Applying coloradjust effect to the ImageView node 
                imageViewer.setEffect(colorAdjust);
            }
        );

        Label l1 = new Label("Hue Slider"); // create an label for hue 
    
        /** slider for saturation */
        Slider saturation = new Slider(-100.0, 100.0, 0);
        saturation.setShowTickMarks(true); // show the vertical lines on the slider 
        saturation.setShowTickLabels(true); // show the numbers on the slider 
        saturation.setMinorTickCount(10); // set the line counts between numbers 

        /* Register an event listener for the slider */
        saturation.valueProperty().addListener(

            (observeable, oldvalue, newvalue) ->{

            /** get the value of saturation. saturation lies in between
             * -1 to 1 for which divide the return value by 100 */
                double satVal = (double)saturation.getValue()/100;
            /* set the image saturation */
                colorAdjust.setSaturation(satVal);

                //Applying coloradjust effect to the ImageView node 
                imageViewer.setEffect(colorAdjust);
            }
        );

        Label l2 = new Label("Saturation Slider"); // saturation label 
    
    // slider for brightness 
        Slider brightness = new Slider(-100.0, 100.0, 0);
        brightness.setShowTickMarks(true); // show the vertical lines on the slider 
        brightness.setShowTickLabels(true); // show the numbers on the slider 
        brightness.setMinorTickCount(10); // set the line counts between numbers 
      
              /* Register an event listener for the slider */
        brightness.valueProperty().addListener(

            (observeable, oldvalue, newvalue) ->{

            /** get the value of brightness. brightness lies in between
             * -1 to 1 for which divide the return value by 100 */
                double brightVal = (double)brightness.getValue()/100;
            /* set the image brightness */
                colorAdjust.setBrightness(brightVal);

                //Applying coloradjust effect to the ImageView node 
                imageViewer.setEffect(colorAdjust);
            }
        );

        Label l3 = new Label("Brightness Slider"); // brightness label
    
        // slider for contrast
        Slider contrast = new Slider(-100.0, 100.0, 0);
        contrast.setShowTickMarks(true); // show the vertical lines on the slider 
        contrast.setShowTickLabels(true); // show the numbers on the slider 
        contrast.setMinorTickCount(10); // set the line counts between numbers 

        /* Register an event listener for the slider */
        contrast.valueProperty().addListener(

            (observeable, oldvalue, newvalue) ->{

            /** get the value of contrast. contrast lies in between
             * 0 to 1 for which divide the return value by 100 */
                double conVal = (double)contrast.getValue()/100;
            /* set the image contrast */
                colorAdjust.setContrast(conVal);

                //Applying coloradjust effect to the ImageView node 
                imageViewer.setEffect(colorAdjust);
            }
        );

        Label l4 = new Label("Constrast Slider"); // label for contrast 
        // embed the nodes into the Pane object
        HBox hbox = new HBox (20, openButton , saveBtn);
        VBox vbox = new VBox(10, hbox, imageViewer, hue,
        l1, saturation, l2, brightness, l3, contrast, l4);
        vbox.setAlignment(Pos.CENTER); // set the Vbox in center 
        vbox.setPadding(new Insets(50, 50, 50, 50)); // set the padding
       
        // Create a Scene object
        Scene scene = new Scene(vbox, 800, 600, Color.BLACK);
        // set the scene to the stage object 
        stage.setScene(scene);

        // set the title of the stage 
        stage.setTitle("Image Color Adjuster");
        // call the show method to display the stage 
        stage.show();       
    
    }
    
}