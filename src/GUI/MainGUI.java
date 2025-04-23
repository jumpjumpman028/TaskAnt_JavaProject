package src.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainGUI extends Application{
    @Override
    public void start(Stage stage) {
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");

        GridPane grid = new GridPane();
        grid.add(btn1, 0, 0);  // (row 0, col 0)
        grid.add(btn2, 1, 0);  // (row 0, col 1)
        grid.add(btn3, 0, 1);  // (row 1, col 0)

        Scene scene = new Scene(grid, 200, 150);
        stage.setScene(scene);
        stage.setTitle("GridPane Example");
        stage.show();
    }

}

