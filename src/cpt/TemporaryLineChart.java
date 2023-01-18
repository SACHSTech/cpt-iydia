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
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class TemporaryLineChart extends Application {

    private LineChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    
    public Parent createContent() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        //grid.setGridLinesVisible(true);

        int[] years = {1981, 1985, 1989, 1995, 2001, 2003, 2008, 2010};

        xAxis = new NumberAxis("Years", years[0], years[7], 10d);
        yAxis = new NumberAxis("Gini Coefficient", 0.0d, 1.0d, 0.2d);

        ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
            new LineChart.Series("Disposable Income",
            FXCollections.observableArrayList(
                new LineChart.Data(years[0], 0.282),
                new LineChart.Data(years[1], 0.293),
                new LineChart.Data(years[2], 0.304),
                new LineChart.Data(years[3], 0.311),
                new LineChart.Data(years[4], 0.32),
                new LineChart.Data(years[5], 0.316),
                new LineChart.Data(years[6], 0.336),
                new LineChart.Data(years[7], 0.334)
            )),
            new LineChart.Series("Market Income",
            FXCollections.observableArrayList(
                new LineChart.Data(years[0], 0.405),
                new LineChart.Data(years[1], 0.44),
                new LineChart.Data(years[2], 0.44),
                new LineChart.Data(years[3], 0.483),
                new LineChart.Data(years[4], 0.498),
                new LineChart.Data(years[5], 0.487),
                new LineChart.Data(years[6], 0.491),
                new LineChart.Data(years[7], 0.492)
            ))
        );
        chart = new LineChart(xAxis, yAxis, areaChartData);
        return chart;
    }

    private static final String[] CATEGORIES = {"Alpha", "Beta", "RC1", "RC2", "1.0", "1.1"};
    private LineChart<String, Number> chart1;
    private CategoryAxis xAxis1;
    private NumberAxis yAxis1;

    public Parent createContent1() {
        xAxis1 = new CategoryAxis();
        yAxis1 = new NumberAxis();
        chart1 = new LineChart<>(xAxis1, yAxis1);
        // setup chart
        chart1.setTitle("LineChart with Category Axis");
        xAxis1.setLabel("X Axis");
        yAxis1.setLabel("Y Axis");
        // add starting data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Data Series 1");
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], 50d));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], 80d));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], 90d));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[3], 30d));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[4], 122d));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[5], 10d));
        chart1.getData().add(series);
        return chart1;
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