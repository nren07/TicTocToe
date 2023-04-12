package com.example.firstproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class HelloApplication extends Application {
    private Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(500.00,100.00);
        return root;
    }
    @Override

    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello Nren07!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}