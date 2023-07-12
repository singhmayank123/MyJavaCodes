import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;

public class App extends Application{
    public static void main(String[] args) throws Exception { launch(args); }

    @Override
    public void start(Stage stage){
        Label dataLabel = new Label("Select any data plans");
        Label phoneLabel = new Label("Select any mobile phone model");
        Label optionalLabel = new Label("Optional benifits");

        // Required controls for the data plans menu and storing them in an VBox
        ComboBox<String> dataComboBox = new ComboBox<>();
        dataComboBox.getItems().addAll("8 gigabytes per month: $45.00 per month",
        "16 gigabytes per month: $65.00 per month","20 gigabytes per month: $99.00 per month");

        Button dataButton = new Button("Get Selection");
        dataButton.setOnAction(event -> {
            dataLabel.setText(dataComboBox.getValue());
        });

        VBox dataVBox = new VBox(10,dataLabel,dataComboBox,dataButton);
        dataVBox.setPadding(new Insets(10));
        dataVBox.setAlignment(Pos.CENTER);


        // Required controls for the phone menu and storing them in an VBox
        ComboBox<String> phoneComboBox = new ComboBox<>();
        phoneComboBox.getItems().addAll("Model 100: $299.95",
        "Model 110: $399.95", "Model 200: $499.95");

        Button phoneButton = new Button("Get Selection");
        phoneButton.setOnAction(event -> {
            phoneLabel.setText(phoneComboBox.getValue());
        });

        VBox phoneVBox = new VBox(10,phoneLabel,phoneComboBox,phoneButton);
        phoneVBox.setPadding(new Insets(10));
        phoneVBox.setAlignment(Pos.CENTER);


        // Required controls for the optional menu and storing them in an VBox
        ComboBox<String> optionalComboBox = new ComboBox<>();
        optionalComboBox.getItems().addAll("Phone replacement insurance:$5.00 per month",
        "WiFi hotspot capability:$10.00 per month");

        Button optionalButton = new Button("Get Selection");
        optionalButton.setOnAction(event -> {
            optionalLabel.setText(optionalComboBox.getValue());
        });

        VBox optionalVBox = new VBox(10,optionalLabel,optionalComboBox,optionalButton);
        optionalVBox.setPadding(new Insets(10));
        optionalVBox.setAlignment(Pos.CENTER);


        //Storing all three VBoxes in one HBox
        HBox mainStorage = new HBox(20,dataVBox,phoneVBox,optionalVBox);
        mainStorage.setPadding(new Insets(25));
        mainStorage.setAlignment(Pos.CENTER);


        //Creating a scene to display the application
        Scene scene = new Scene(mainStorage);
        stage.setTitle("Smartphone Packages");
        stage.setScene(scene);
        stage.show();
    }
}