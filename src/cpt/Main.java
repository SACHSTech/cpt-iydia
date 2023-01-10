package cpt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.AreaChart;

public class Main extends Application {

    private AreaChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;

    public Parent createContent() {
        int[] years = {1981, 1985, 1989, 1995, 2001, 2003, 2008, 2010};

        xAxis = new NumberAxis("Years", years[0], years[7], 10d);
        yAxis = new NumberAxis("Gini Coefficient", 0.0d, 1.0d, 0.2d);

        ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
            new AreaChart.Series("Disposable Income",
            FXCollections.observableArrayList(
                new AreaChart.Data(years[0], 0.282),
                new AreaChart.Data(years[1], 0.293),
                new AreaChart.Data(years[2], 0.304),
                new AreaChart.Data(years[3], 0.311),
                new AreaChart.Data(years[4], 0.32),
                new AreaChart.Data(years[5], 0.316),
                new AreaChart.Data(years[6], 0.336),
                new AreaChart.Data(years[7], 0.334)
            )),
            new AreaChart.Series("Market Income",
            FXCollections.observableArrayList(
                new AreaChart.Data(years[0], 0.405),
                new AreaChart.Data(years[1], 0.44),
                new AreaChart.Data(years[2], 0.44),
                new AreaChart.Data(years[3], 0.483),
                new AreaChart.Data(years[4], 0.498),
                new AreaChart.Data(years[5], 0.487),
                new AreaChart.Data(years[6], 0.491),
                new AreaChart.Data(years[7], 0.492)
            ))
        );
        chart = new AreaChart(xAxis, yAxis, areaChartData);
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
