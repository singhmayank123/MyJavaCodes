import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene; 
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.event.*;

/* Main class */

public class Menu extends Application {

	private CheckBox []checkBoxes = new CheckBox[4];
	private Label result; 

	class RadioButtonListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e){

			double total = 0; 

			for(int i = 0; i<4; i++){

				if(checkBoxes[i].isSelected()){
					String value = checkBoxes[i].getText();
					String[] values = value.split("[:$]");
					
					total += Double.parseDouble(values[2]);
				}

				result.setText(String.format("total price: %.2f", total));
				
			}
		}
	}

/** main driver method that calls the static method launch to 
 * run the GUI application */
	public static void main(String[] args) throws Exception {
		
		launch(args);
	}

	@Override // for stating the method overriding 

	public void start(Stage stage){

		String items[] = {"Biscuits: $20", "Milk: $25", "Maggi: $12", "Chocolate: $20"};

		VBox vbox = new VBox(10);

		for(int i = 0; i<4; i++){
			checkBoxes[i] = new CheckBox(items[i]);
			vbox.getChildren().add(checkBoxes[i]);
		}

		Button calc = new Button("Calculate total");

		calc.setOnAction(new RadioButtonListener());

		vbox.getChildren().add(calc);

		result = new Label();
		
		vbox.getChildren().add(result);

		vbox.setAlignment(Pos.CENTER);
		
		// Create a Scene object
		Scene scene = new Scene(vbox , 500, 500, Color.rgb(135,206,235));
		// set the scene to the stage object 
		stage.setScene(scene);

		// set the title of the stage 
		stage.setTitle("Menu bars");
		// call the show method to display the stage 
		stage.show();		
	
	}
	


}