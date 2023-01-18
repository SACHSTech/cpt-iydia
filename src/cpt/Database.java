package cpt;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.GridPane;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;

public class Database extends Application {

    private TabPane tabPane;
    private Tab lineChart;
    private Tab barChart;
    
    private LineChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private static final String[] CATEGORIES = {"Alpha", "Beta", "RC1", "RC2", "1.0", "1.1"};
    private LineChart<String, Number> chart1;
    private CategoryAxis xAxis1;
    private NumberAxis yAxis1;

    public Parent createContent() {
        //Each tab illustrates different capabilities
        tabPane = new TabPane();
        tabPane.setSide(Side.LEFT);
        tabPane.setPrefSize(900, 650);
        tabPane.setMinSize(TabPane.USE_PREF_SIZE, TabPane.USE_PREF_SIZE);
        tabPane.setMaxSize(TabPane.USE_PREF_SIZE, TabPane.USE_PREF_SIZE);
        lineChart = new Tab();
        barChart = new Tab();

        tabPane.setRotateGraphic(false);
        // Makes tabs uncloseable
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); 
        tabPane.setSide(Side.TOP);
        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setTranslateX(10);
        vbox.setTranslateY(10);

        // Line Chart Tab
        lineChart.setText("Line Chart");
        lineChart.setContent(vbox);
        final VBox vboxLineChart = new VBox();
        vboxLineChart.setSpacing(10);
        //vboxLineChart.setTranslateX(0);
        vboxLineChart.setTranslateY(10);
            
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
    
        vboxLineChart.getChildren().add(chart1);
        lineChart.setContent(vboxLineChart);
        tabPane.getTabs().add(lineChart);

        // Bar Chart Tab
        barChart.setText("Bar Chart");
        barChart.setContent(vbox);
        final VBox vboxBarChart = new VBox();
        vboxBarChart.setSpacing(10);
        //vboxBarChart.setTranslateX(0);
        vboxBarChart.setTranslateY(10);

        int[] years = {1981, 1985, 1989, 1995, 2001, 2003, 2008, 2010};

        xAxis = new NumberAxis("Years", years[0], years[7], 10d);
        yAxis = new NumberAxis("Y-Axis", 0.0d, 1.0d, 0.2d);

        ObservableList<AreaChart.Series> areaChartData = FXCollections.observableArrayList(
            new LineChart.Series("Disposable Income",
            FXCollections.observableArrayList(
                new LineChart.Data(years[0], 0.282),
                new LineChart.Data(years[1], 0.293)
            )),
            new LineChart.Series("Market Income",
            FXCollections.observableArrayList(
                new LineChart.Data(years[0], 0.405),
                new LineChart.Data(years[1], 0.44)
            ))
        );
        chart = new LineChart(xAxis, yAxis, areaChartData);

        vboxBarChart.getChildren().add(chart);
        barChart.setContent(vboxBarChart);
        tabPane.getTabs().add(barChart);

        return tabPane;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("World Annual Population Growth Database");
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