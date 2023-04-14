package com.example.TicTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Label playerXScoreLabel,playerOScoreLabel;
    private boolean playerXturn=true;
    private int playerXScore=0,playerOScore=0;
    private void buttonClick(Button btn){
        if(btn.getText().equals("")){
            if(playerXturn){
                btn.setText("X");
            }else btn.setText("O");
            playerXturn=!playerXturn;
            checkWinner();
        }
    }

    private void checkWinner(){

    //    row
       for(int row=0;row<3;row++){
           if(  buttons[row][0].getText().equals(buttons[row][1].getText())
                && buttons[row][1].getText().equals(buttons[row][2].getText())
                && !buttons[row][0].getText().isEmpty()){

                String winner=buttons[row][0].getText();
                showDialog(winner);
                updateScore(winner);
                resetBoard();
                return;
           }
       }
    //    col
        for(int col=0;col<3;col++){
            if(  buttons[0][col].getText().equals(buttons[1][col].getText())
                    && buttons[1][col].getText().equals(buttons[2][col].getText())
                    && !buttons[0][col].getText().isEmpty()){

                String winner=buttons[0][col].getText();
                showDialog(winner);
                updateScore(winner);
                resetBoard();
                return;
            }
        }

    //    diagonal
        int row=0;
        int col=0;

        if(  buttons[row][col].getText().equals(buttons[row+1][col+1].getText())
                && buttons[row+1][col+1].getText().equals(buttons[row+2][col+2].getText())
                && !buttons[row][col].getText().isEmpty()){

            String winner=buttons[row][col].getText();
            showDialog(winner);
            updateScore(winner);
            resetBoard();
        }else if( buttons[row][2-col].getText().equals(buttons[row+1][col+1].getText())
                && buttons[row+1][col+1].getText().equals(buttons[row+2][col].getText())
                && !buttons[row][col+2].getText().isEmpty()){
            String winner=buttons[row][col+2].getText();
            showDialog(winner);
            updateScore(winner);
            resetBoard();
            return;
        }

//        check for tie of the match
        for(Button buttonRow[] : buttons){
            for(Button btn : buttonRow){
                if(!btn.getText().equals("")) continue;
                else return;
            }
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Oh No! Match is Tie ! Play Again");
        alert.setHeaderText("");
        alert.setTitle("Tie! Tie! Tie");
        alert.show();
        resetBoard();
        return;

    }
    private void showDialog(String winner){
//        alert shown when there is a winner and it's type is Information
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Congratulations Winner");
        alert.setContentText("The Winner is  "+ winner+" ! You won the game");
        alert.setHeaderText("");
        alert.show();
    }
    private void updateScore(String winner){
        if(winner.equals("X")){
            playerXScore++;
            playerXScoreLabel.setText("Player X : "+playerXScore);
        }else{
            playerOScore++;
            playerOScoreLabel.setText("Player O : "+playerOScore);
        }
    }

    private void resetBoard(){
        for(Button row[] : buttons){
            for(Button btn : row){
                btn.setText("");
            }
        }
    }
    private BorderPane createContent(){
        BorderPane root=new BorderPane();
//        title
        Label titleLabel =new Label("Tic Tac Toe");
        titleLabel.setStyle("-fx-font-size : 24pt; -fx-font-weight : bold");
        root.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.TOP_CENTER);
        BorderPane.setAlignment(titleLabel, Pos.BOTTOM_CENTER);

//        game Board

        GridPane gridPane=new GridPane();
        gridPane.setHgap(20.00);
        gridPane.setVgap(20.00);
        gridPane.setStyle("-fx-font-size : 10pt;");
        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button=new Button();
                button.setStyle("-fx-font-size : 24pt; -fx-font-weight : bold");
//                button.setStyle("-fx-base: " + toCssColor(color) + ";");

                button.setPrefSize(75,75);
                button.setOnAction(actionEvent ->buttonClick(button));
                buttons[i][j]=button;
                gridPane.add(button,j,i);
            }
        }
        root.setPadding(new Insets(20));
        root.setCenter(gridPane);
        BorderPane.setAlignment(gridPane, Pos.CENTER);

//        Score
        HBox scoreBoard=new HBox(20);
        scoreBoard.setAlignment(Pos.CENTER);
        playerXScoreLabel=new Label("Player X : 0");
        playerXScoreLabel.setStyle("-fx-font-size : 16pt;-fx-font-weight : bold;");
        playerOScoreLabel=new Label("Player O : 0");
        playerOScoreLabel.setStyle("-fx-font-size : 16pt; -fx-font-weight : bold;");
        scoreBoard.getChildren().addAll(playerXScoreLabel,playerOScoreLabel);
        root.setBottom(scoreBoard);
//        root.setPrefSize(500.00,250.00);
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