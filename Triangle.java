import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene; 
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.geometry.*;
import javafx.event.*;
import java.util.Random;

public class Triangle extends Application {


	public static void main(String[] args) throws Exception {
		
		launch(args);
	}

	@Override

	public void start(Stage stage){

		System.out.println("dj");

		final int SCENE_WIDTH = 320;
		final int SCENE_HEIGHT = 240;

		final double TOP_X = 160; 
		final double TOP_Y = 20;

		final double BOT_LEFT_X = 310;
		final double BOT_LEFT_Y = 220;
		final double BOT_RIGHT_X = 20;
		final double BOT_RIGHT_Y = 220;

		Line line1 = new Line(TOP_X, TOP_Y, BOT_LEFT_X, BOT_LEFT_Y);
		line1.setStroke(Color.WHITE);
		Line line2 = new Line(TOP_X, TOP_Y, BOT_RIGHT_X, BOT_RIGHT_Y);
		line2.setStroke(Color.WHITE);
		Line line3 = new Line(BOT_LEFT_X, BOT_LEFT_Y, BOT_RIGHT_X, BOT_RIGHT_Y);
		line3.setStroke(Color.WHITE);

		Pane pane = new Pane(line1, line2, line3);

		pane.getStyleClass().add("my-pane");

		Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);

		scene.getStylesheets().add("style.css");

		stage.setScene(scene);

		stage.setTitle("Triangle Shape");
		stage.show();
	}
	
}