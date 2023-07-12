/** This program uses javafx functionality and should be 
 * tested with appropriate javafx plugins and other requirements
 *  */

/** This program changes the image when a mouse hovers on it and
 * gets change to initial image when the mouse exits **/


import javafx.application.Application; 
/** for using the Scene class which contains the collection 
 * of GUI objects */
import javafx.scene.Scene; 
/** For using the Stage class which display a Application 
 * window on which the Scene is displayed */
import javafx.stage.Stage;
/* For using Pane class */
import javafx.scene.layout.Pane;
/* for Label class **/
import javafx.scene.control.Label;
/* For using VBox class which provides a vertical layout */
import javafx.scene.layout.VBox;
/* For using HBox class which provides a horizontal layout */
import javafx.scene.layout.HBox;
/* for referencing an image file */
import javafx.scene.image.Image;
/** for displaying an image to the GUI application */
import javafx.scene.image.ImageView;
/** for Color class **/
import javafx.scene.paint.Color; 
/** for Pos class **/
import javafx.geometry.Pos;
/** for Font class **/
import javafx.scene.text.Font;


/* RockPaperScissorGame class that implements the Application class 
for the required JavaFx application */

public class RockPaperScissorGame extends Application{


	public Label selectLabel = null; // labels that show computer selection
	public Label winLabel = null; // label that shows the winner 
	public ImageView resultView = new ImageView();

	/** method that checks the winner and print the name **/
	public void checkWhoWins(int compChoice, int userChoice){

		/** b/w rock and rock **/
		if(compChoice == 0 && userChoice == 0){
			selectLabel.setText("Computer chooses rock.");
			resultView.setImage(null);
			winLabel.setText("It's a TIE!!");
		}
		// b/w rock and paper 
		if(compChoice == 0 && userChoice == 1){
			selectLabel.setText("Computer chooses rock.");
			resultView.setImage(new Image("pvs.png"));
			winLabel.setText("You win!!");
		}
		// rock and scissor 
		else if(compChoice == 0 && userChoice == 2){
			selectLabel.setText("Computer chooses rock.");
			resultView.setImage(new Image("rvs.png"));
			winLabel.setText("You lose..");
		}
		// paper and rock 
		else if(compChoice == 1 && userChoice == 0){

			selectLabel.setText("Computer chooses paper.");
			resultView.setImage(new Image("pvs.png"));
			winLabel.setText("You lose..");
		}

		// paper and paper
		else if(compChoice == 1 && userChoice == 1){
			selectLabel.setText("Computer chooses paper.");
			resultView.setImage(null);
			winLabel.setText("It's a TIE!!");
		}

		// paper and scissor
		else if(compChoice == 1 && userChoice == 2){
			selectLabel.setText("Computer chooses paper.");
			resultView.setImage(new Image("svp.png"));
			winLabel.setText("You win!!");
		}

		// scissor and rock 
		else if(compChoice == 2 && userChoice == 0){
			selectLabel.setText("Computer chooses scissor.");
			resultView.setImage(new Image("rvs.png"));
			winLabel.setText("You win!!");
		}

		// scissor and paper 
		else if(compChoice == 2 && userChoice == 1){
			selectLabel.setText("Computer chooses scissor.");
			resultView.setImage(new Image("svp.png"));
			winLabel.setText("You lose..");
		}
		// scissor and scissor 
		else if(compChoice == 2 && userChoice == 2){
			selectLabel.setText("Computer chooses scissor.");
			resultView.setImage(null);
			winLabel.setText("It's a TIE!!");
		}
	}

	/** returns a random value b/w 0 to 2 **/

	public int getComputerChoice(){

		int max = 2, min = 0;

		int value = (int)(Math.floor(Math.random()*(max-min+1)+min));
		return value;
	}

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

		/** for rock Image **/
		
		Image rock = new Image("rock.png");
		ImageView rockView = new ImageView(rock);
		rockView.setFitWidth(50);
		rockView.setFitHeight(50);
		rockView.setPreserveRatio(true);

		/** for Paper image **/
		Image paper = new Image("paper.png");
		ImageView paperView = new ImageView(paper);
		paperView.setFitWidth(50);
		paperView.setFitHeight(50);
		paperView.setPreserveRatio(true);

		/* for Scissor Image **/
		Image scissor = new Image("scissors.png");
		ImageView scissorView = new ImageView(scissor);
		scissorView.setFitWidth(50);
		scissorView.setFitHeight(50);
		scissorView.setPreserveRatio(true);

		/** initialize the labels with initial string values **/
		selectLabel = new Label("Click on any Image");
		winLabel = new Label("");
		/** set the fonts of labels **/
		selectLabel.setFont(new Font("Arial", 20));
		winLabel.setFont(new Font("Arial", 15));

		/** Event handler to the rockView **/
		rockView.setOnMouseClicked((e) -> {
			int compChoice = getComputerChoice(); // 0 to 2 
			checkWhoWins(compChoice, 0);

		});

		/** event handler to the paperview **/
		paperView.setOnMouseClicked((e) -> {
			int compChoice = getComputerChoice(); // 0 to 2 
			checkWhoWins(compChoice, 1);

		});

		/** event handler for the scissorView **/
		scissorView.setOnMouseClicked((e) -> {
			int compChoice = getComputerChoice(); // 0 to 2 
			checkWhoWins(compChoice, 2);

		});

		/** align images horizontally with an horizontal gap of 20 pixels **/
		HBox images = new HBox(20, rockView, paperView, scissorView);
		/* place in center **/
		images.setAlignment(Pos.CENTER);

		/* align vertically **/
		VBox vbox = new VBox(20, images, selectLabel, resultView, winLabel);
		/** place the entire vbox in center **/
		vbox.setAlignment(Pos.CENTER);

		// Pass the imageViewer object to the Scene object type 
        Scene scene = new Scene(vbox, 400, 400);

        //Setting title to the Stage
        stage.setTitle("Rock Paper Scissor Game"); 

        //Adding scene to the stage 
        stage.setScene(scene); 
         
	      //Displaying the contents of the stage 
	    stage.show(); 
	}
}