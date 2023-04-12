package com.example.firstproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.RoundingMode;

public class TicTacToe extends Application {

    private Button  buttons[][]=new Button[3][3];
    private Label playerXScore,playerOScore;
    private BorderPane createContent(){
        BorderPane root=new BorderPane();
//        title

        Label titleLabel =new Label("Tic Tac Toe");
        titleLabel.setStyle("-fx-font-size : 24pt; -fx-font-weight : bold");
        root.setTop(titleLabel);

//        game Board

        GridPane gridPane=new GridPane();
        gridPane.setStyle("-fx-font-size : 5pt;");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button=new Button("-");
                button.setStyle("-fx-font-size : 24pt;");
//                button.setStyle("-fx-base: " + toCssColor(color) + ";");

                button.setPrefSize(100,100);
                buttons[i][j]=button;
                gridPane.add(button,i,j);
            }
        }
        root.setCenter(gridPane);

//        Score
        HBox scoreBoard=new HBox(20);
        playerXScore=new Label("Player X : 0");
        playerXScore.setStyle("-fx-font-size : 16pt;");
        playerOScore=new Label("Player O : 0");
        playerOScore.setStyle("-fx-font-size : 16pt;");
        scoreBoard.getChildren().addAll(playerXScore,playerOScore);
        root.setBottom(scoreBoard);
        root.setPrefSize(500.00,250.00);
        return root;
    }
    @Override

    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Tic Tac Toe!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}