package cpt;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class Database extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Income Inequality Database");

        Menu menu1 = new Menu("Home");
        Menu menu2 = new Menu("Charts");

        MenuItem menuItem1 = new MenuItem("Line Chart");
        MenuItem menuItem2 = new MenuItem("Bar Chart");
        
        menu2.getItems().add(menuItem1);
        menu2.getItems().add(menuItem2);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        
        VBox vBox = new VBox(menuBar);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }    
}
