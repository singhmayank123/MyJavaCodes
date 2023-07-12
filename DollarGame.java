import javafx.application.Application; // for Application class 

import javafx.stage.Stage;
/** for using the Scene class which contains the collection 
 * of GUI objects */
import javafx.scene.Scene; 
import javafx.scene.layout.VBox; // for VBox class 
import javafx.scene.layout.HBox; // for HBox class 
import javafx.geometry.Pos; // for Pos class
import javafx.geometry.Insets; // for Insets class 
import javafx.scene.control.Label; // for Label class 
import javafx.event.EventHandler; // for EventHandler class 
import javafx.scene.image.Image; // for Image class 
import javafx.scene.image.ImageView; // for ImageView clas 
import javafx.scene.text.Text; // for Text class 
import javafx.scene.paint.Color;  // for Color class 
import javafx.scene.text.Font; // for Font clas 

public class DollarGame extends Application
{

   private  Text countsText = null; // displays the current count of each coin 
   private Text total = new Text(); // displays the total collected coins in dollors 
   private int pennyCounts = 0; // for penny coins count 
   private int nickelCounts = 0; // for nickel coins count 
   private int dimeCounts = 0; // for dime coins count 
   private int quarterCounts = 0; // for quarter coins count 

/** update the counts of each coin **/
   public void updateCount(){

      countsText.setText
      (String.format("Penny counts: %d\n"+"Nickel counts: %d\n" 
         +"Dime counts: %d\nQuarter counts: %d" ,
         pennyCounts, nickelCounts, dimeCounts, quarterCounts));
   }

   // main driver method 
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
     /** initialize the Text object for displaying initial counts **/
     countsText = new Text
      (String.format("Penny counts: %d\n"+"Nickel counts: %d\n" 
         +"Dime counts: %d\nQuarter counts: %d" ,
         pennyCounts, nickelCounts, dimeCounts, quarterCounts));

      /** open each coin image **/
      Image penny = new Image("penny.png");
      Image nickel = new Image("nickel.png");
      Image dime = new Image("dime.png");
      Image quarter = new Image("quarter.png");

      /*** place each coin image in the imageView object to display them **/
      ImageView pennyView = new ImageView(penny);
      ImageView nickelView = new ImageView(nickel);
      ImageView dimeView = new ImageView(dime);
      ImageView quarterView = new ImageView(quarter);

      /** set the aspect ratio **/
      pennyView.setFitWidth(70);
      pennyView.setFitHeight(70);
      pennyView.setPreserveRatio(true);
      
      nickelView.setFitWidth(70);
      nickelView.setFitHeight(70);
      nickelView.setPreserveRatio(true);
      
      dimeView.setFitWidth(70);
      dimeView.setFitHeight(70);
      dimeView.setPreserveRatio(true);
      
      quarterView.setFitWidth(70);
      quarterView.setFitHeight(70);
      quarterView.setPreserveRatio(true);

      /** register the event handler for the on click event on penny image viewer **/
      pennyView.setOnMouseClicked(event ->{
         /* for each click increment the count of penny coins by 1 **/
         pennyCounts++;
         /** call the method to update the count on the board **/
         updateCount();
      });

      /** register the event handler for the on click event on nickel image viewer **/
  
      nickelView.setOnMouseClicked(event ->{
         nickelCounts++;
         updateCount();
      });

      /** register the event handler for the on click event on dime image viewer **/
   
      dimeView.setOnMouseClicked(event ->{
         dimeCounts++;
         updateCount();
      });

      /** register the event handler for the on click event on quarter image viewer **/

      quarterView.setOnMouseClicked(event ->{
         quarterCounts++;
         updateCount();
      });
      /* set the font of count board text **/
      countsText.setFont(new Font("Times New Roman", 20));

      /* create a new Text object ***/
      Text text = new Text("Count Change");

      /** register the event handler for text **/
      text.setOnMouseClicked(event -> {
            
            /*** calculate each coin amount in dollor **/
            double pennyInDollars = pennyCounts * 0.01;
            double nickelInDollars = nickelCounts * 0.05;
            double dimeInDollars = dimeCounts * 0.10;
            double quarterInDollar = quarterCounts * 0.25;

            /** calculate the total sum of coins **/
            double sum = pennyInDollars + nickelInDollars + dimeInDollars + quarterInDollar;

            /* display the sum on the total object **/
            total.setText(String.format("You have collected total $%.2f !!", sum));
            total.setFont(new Font("Arial", 15));

            /** if sum is 1 the display user wins **/
            if(sum == 1){

               text.setText("You win!!");
            }

            /* otherwise user lose **/
            else{

               text.setText("You lose!!");
               /** reset the counts **/
               pennyCounts = 0;
               nickelCounts = 0;
               dimeCounts = 0;
               quarterCounts = 0;
               /** call to apply the reset effect **/
               updateCount();

            }

      });

      text.setFont(new Font("Times New Roman", 18));
      text.setFill(Color.BLUE);

      VBox vbox = new VBox(20, pennyView, nickelView, dimeView, quarterView, countsText);

      vbox.setAlignment(Pos.CENTER);

      VBox vbox2 = new VBox(40, countsText, total, text);

      vbox2.setAlignment(Pos.CENTER);

      HBox hbox = new HBox(80, vbox, vbox2);

      hbox.setAlignment(Pos.CENTER);

      hbox.setPadding(new Insets(20, 0, 0 , 20));

      Scene scene = new Scene(hbox, 400, 400);

      primaryStage.setScene(scene);

      primaryStage.show();
   }
}