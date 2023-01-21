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
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class Database extends Application {

    // tabpane
    private TabPane tabPane;
    private Tab tab1;
    private Tab tab2;
    
    // tab1 stuff
    private LineChart chart1;
    private NumberAxis xAxis1;
    private NumberAxis yAxis1;

    // tab2 stuff
    private ScatterChart chart2;
    private NumberAxis xAxis2;
    private NumberAxis yAxis2;

    //DataCollection collection = new DataCollection();

    public Parent createContent() {
        //Each tab illustrates different capabilities
        tabPane = new TabPane();
        tabPane.setSide(Side.LEFT);
        tabPane.setPrefSize(900, 650);
        tabPane.setMinSize(TabPane.USE_PREF_SIZE, TabPane.USE_PREF_SIZE);
        tabPane.setMaxSize(TabPane.USE_PREF_SIZE, TabPane.USE_PREF_SIZE);

        // Make tabs
        tab1 = new Tab();
        tab2 = new Tab();

        tabPane.setRotateGraphic(false);
        // Makes tabs uncloseable
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); 
        tabPane.setSide(Side.TOP);
        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setTranslateX(10);
        vbox.setTranslateY(10);

        // Line Chart Tab
        tab1.setText("Line Chart");
        tab1.setContent(vbox);
        // Mini vbox
        final VBox vboxTab1 = new VBox();
        vboxTab1.setSpacing(10);
        vboxTab1.setTranslateX(10);
        vboxTab1.setTranslateY(10);
            
        xAxis1 = new NumberAxis("Values for X-Axis", 0, 3, 1);
        yAxis1 = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData =
            FXCollections.observableArrayList(
                new LineChart.Series<>("Series 1",
                                       FXCollections.observableArrayList(
                    new XYChart.Data<>(0.0, 1.0),
                    new XYChart.Data<>(1.2, 1.4),
                    new XYChart.Data<>(2.2, 1.9),
                    new XYChart.Data<>(2.7, 2.3),
                    new XYChart.Data<>(2.9, 0.5))),
                new LineChart.Series<>("Series 2",
                                       FXCollections.observableArrayList(
                    new XYChart.Data<>(0.0, 1.6),
                    new XYChart.Data<>(0.8, 0.4),
                    new XYChart.Data<>(1.4, 2.9),
                    new XYChart.Data<>(2.1, 1.3),
                    new XYChart.Data<>(2.6, 0.9)))
            );
        chart1 = new LineChart(xAxis1, yAxis1, lineChartData);

        // Add all the stuff to the tabpane
        vboxTab1.getChildren().addAll(chart1);
        tab1.setContent(vboxTab1);
        tabPane.getTabs().add(tab1);
        
        // Bar Chart Tab
        tab2.setText("Bar Chart");
        tab2.setContent(vbox);
        // Mini Vbox
        final VBox vboxTab2 = new VBox();
        vboxTab2.setSpacing(10);
        vboxTab2.setTranslateX(10);
        vboxTab2.setTranslateY(10);

        xAxis2 = new NumberAxis("X-Axis", 0d, 8.0d, 1.0d);
        yAxis2 = new NumberAxis("Y-Axis", 0.0d, 5.0d, 1.0d);
        final Series<Number, Number> series = new Series<>();
        series.setName("Series 1");
        series.getData().addAll(new Data(0.2, 3.5),
                                new Data(0.7, 4.6),
                                new Data(1.8, 1.7),
                                new Data(2.1, 2.8),
                                new Data(4.0, 2.2),
                                new Data(4.1, 2.6),
                                new Data(4.5, 2.0),
                                new Data(6.0, 3.0),
                                new Data(7.0, 2.0),
                                new Data(7.8, 4.0));
        chart2 = new ScatterChart(xAxis2, yAxis2);
        chart2.getData().add(series);

        // Add all the stuff to the tabpane
        vboxTab2.getChildren().addAll(chart2);
        tab2.setContent(vboxTab2);
        tabPane.getTabs().add(tab2);

        // Checkboxes
        CheckBox cb1 = new CheckBox("Show predicted population changes");
        CheckBox cb2 = new CheckBox("Show predicted population changes");
        vboxTab1.getChildren().add(cb1);
        vboxTab2.getChildren().add(cb2);

        if(cb1.isSelected()){
        }

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