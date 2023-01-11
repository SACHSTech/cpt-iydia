package cpt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.GridPane;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;

public class Main extends Application {

    private LineChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    

    public Parent createContent() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        //grid.setGridLinesVisible(true);

        int[] years;
        for(int i = 0; i < 181; i++){
            data.getYear = years[i];
        }

        xAxis = new NumberAxis("Years", years[0], years.length-1, 10d);
        yAxis = new NumberAxis("Gini Coefficient", 0.0d, 1.0d, 0.2d);

        ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
            new LineChart.Series("Disposable Income",
            FXCollections.observableArrayList(
            )),
            new LineChart.Series("Market Income",
            FXCollections.observableArrayList(
            ))
        );
        chart = new LineChart(xAxis, yAxis, areaChartData);
        return chart;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Income Inequality Database");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
