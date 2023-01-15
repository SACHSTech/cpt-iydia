package cpt;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Database extends Application{
    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Income Inequality Database");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setGridLinesVisible(false);

        Menu home = new Menu("Home");
        Menu charts = new Menu("Charts");

        MenuItem lineChart = new MenuItem("Line Chart");
        MenuItem barChart = new MenuItem("Bar Chart");
        
        charts.getItems().add(lineChart);
        charts.getItems().add(barChart);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(home);
        menuBar.getMenus().add(charts);

        grid.add(menuBar, 0, 0, 2, 1); //(columnIndex, rowIndex, columnSpan, rowSpan)
        
        lineChart.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Line Chart Pressed");
                
                    Text scenetitle = new Text("Welcome");
                    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                    grid.add(scenetitle, 1, 1, 1, 1);
    
                    Label userName = new Label("Line Chart Page");
                    grid.add(userName, 1, 2);
            }
        });

        barChart.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Bar Chart Pressed");

                Text test = new Text("Bar Chart Page");
                grid.add(test, 1, 3, 1, 1);
            }
        });

        Scene scene = new Scene(grid, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }    
}
