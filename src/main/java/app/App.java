package app;

import harvard.AppDriver;
import harvard.exception.AssemblySyntaxError;
import harvard.harvardComputerExceptions.HarvardComputerArchException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class App extends Application{

    private static TextArea outputArea;
    private TextField inputField;
    static int filesName = 0;

    String file = new String();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Luka & Barro GUI");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setStyle("-fx-control-inner-background: black; -fx-text-fill: green;");
        outputArea.setMinHeight(300);

        inputField = new TextField();
        inputField.setMinHeight(30);
        inputField.setStyle("-fx-border-color: green; -fx-focus-color: green; -fx-faint-focus-color: green;-fx-control-inner-background: black; -fx-text-fill: red;");

        inputField.setOnAction(event -> {
            try {
                processInput();
            } catch (IOException | AssemblySyntaxError | HarvardComputerArchException e) {
                throw new RuntimeException(e);
            }
        });


        VBox vbox = new VBox(outputArea);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: black;");

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: black;");
        root.setCenter(vbox);
        root.setBottom(inputField);
        BorderPane.setMargin(inputField, new Insets(10)); // Add margin to the input field
        BorderPane.setAlignment(inputField, javafx.geometry.Pos.BOTTOM_CENTER); // Align input field to the bottom center
        Scene scene = new Scene(root, 800, 500);
        scene.setFill(Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processInput() throws IOException, AssemblySyntaxError, HarvardComputerArchException {
        String input = inputField.getText();
        input = input.toLowerCase();
        if(input.equals("run")) {
            File f = new File((filesName++)+".txt");
            FileWriter fw = new FileWriter(f);
            fw.write(file);
            fw.flush();
            outputArea.clear();
            AppDriver app = new AppDriver();
            app.init();
            app.run((filesName-1)+".txt");
            file = new String();
            f.delete();
        }
        else if (input.equals("clear")) {
            outputArea.clear();
        }
        else {
            outputArea.appendText("> " + input + "\n");
            file += input + "\n";
        }
        inputField.clear();

    }

    public static void output(String print)
    {
        if(print.equals(""))
            return;
        outputArea.appendText("> " + print + "\n");
    }

}
