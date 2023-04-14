module com.example.TicTacToe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.TicTacToe to javafx.fxml;
    exports com.example.TicTacToe;
}