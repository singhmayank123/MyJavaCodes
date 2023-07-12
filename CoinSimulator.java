/** This programs displays a GUI of an Image chooser buttton
 * and a slider to change the image opacity */

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color; 
import javafx.geometry.Pos;
import javafx.event.*;
import java.io.File;
/* Main class */


public class CoinSimulator extends Application {

/** main driver method that calls the static method launch to 
 * run the GUI application */
    public static void main(String[] args) throws Exception {
        
        launch(args);
    }

    @Override // for stating the method overriding 

    public void start(Stage stage){

        // create an object of ImageView for viewing the image file
        ImageView imageViewer = new ImageView();

        // Button for choosing an image from local system
        Button openButton = new Button("Press here");
      
        // register an event handler for the openButton
        openButton.setOnAction((ActionEvent ae) -> {

            int max = 1, min = 0;
          
            int randNum = (int)(Math.random()*(max-min+1)+min); 
            
            try{

                File file1 = new File("head.png");
                File file2 = new File("tail.png");
                   // for head side of the coin 
                if(randNum == 0){
    
                     /** Pass the file to the object type of Image
                 * and convert the file to the string representing its URL
                 * beacause the Image constructor expects a String value */ 
                    Image headImage = new Image(file1.toURI().toString());
                    imageViewer.setImage(headImage);
                }
                
                // for tail side of the coin 
    
                else if(randNum == 1){
                    Image tailImage = new Image(file2.toURI().toString());
                    imageViewer.setImage(tailImage);
                }
    
            /* Set the view port ratio for the Image viewer */
                imageViewer.setFitWidth(400);
                imageViewer.setFitHeight(400);
                
            }
            
            // for catching the Exceptions when an error encounters 
            
            catch(Exception e){
                
                System.out.println("File not found exception occurs.");
            }

            System.out.println(randNum); // for ensuring the random values 
           
        });

        // embed the nodes into the Pane object
        VBox vbox = new VBox(20, openButton, imageViewer);
        vbox.setAlignment(Pos.CENTER);
       
        // Create a Scene object
        Scene scene = new Scene(vbox, 800, 600, Color.BLACK);
        // set the scene to the stage object 
        stage.setScene(scene);

        // set the title of the stage 
        stage.setTitle("Coin Simulator");
        // call the show method to display the stage 
        stage.show();       
    
    }
    
}