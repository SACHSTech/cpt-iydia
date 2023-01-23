package cpt;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private LineChart newChart1;
    private NumberAxis xAxis1;
    private NumberAxis yAxis1;
    private NumberAxis newXAxis1;
    private NumberAxis newYAxis1;

    // tab2 stuff
    private ScatterChart chart2;
    private NumberAxis xAxis2;
    private NumberAxis yAxis2;

    public Parent createContent() {
        DataCollection collection = new DataCollection();
        int intThisYear = 2023;

        //Each tab illustrates different capabilities
        tabPane = new TabPane();
        tabPane.setSide(Side.LEFT);
        tabPane.setPrefSize(900, 700);
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

        // Tab1 set content
        tab1.setText("Line Chart");
        tab1.setContent(vbox);
        final VBox vboxTab1 = new VBox();
        vboxTab1.setSpacing(10);
        vboxTab1.setTranslateX(10);
        vboxTab1.setTranslateY(10);
            
        // Tab1 checkbox
        CheckBox cb1 = new CheckBox("Show predicted population changes");
        vboxTab1.getChildren().add(cb1);

        // Tab1 charts
        xAxis1 = new NumberAxis("Years", collection.getData().get(0).getYear(), collection.getCurrentData(intThisYear).get(collection.getCurrentYear()).getYear(), 1);
        yAxis1 = new NumberAxis("Annual Population Growth", 43808256, 92471810, 1000000);
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

        // Tab1: if checkbox is clicked
        cb1.setOnAction(new EventHandler<ActionEvent>() {
            int intCount = 0;
            @Override
            public void handle(ActionEvent event) {
                intCount++;
                System.out.println(intCount);
                if(intCount%2==1){
                    vboxTab1.getChildren().remove(chart1);
                    newXAxis1 = new NumberAxis("Years", collection.getData().get(0).getYear(), collection.getData().get(collection.getFileLength()).getYear(), 1);
                    newYAxis1 = new NumberAxis("Annual Population Growth", -10946560, 92471810, 1000000);
                    newChart1 = new LineChart(newXAxis1, newYAxis1, lineChartData);

                    // Add all the stuff to the tabpane
                    vboxTab1.getChildren().addAll(newChart1);
                    tab1.setContent(vboxTab1);

                } else if(intCount%2==0){
                    vboxTab1.getChildren().remove(newChart1);
                    vboxTab1.getChildren().addAll(chart1);
                    tab1.setContent(vboxTab1);
                }
            }
        });
        
        // Tab2 Set Content
        tab2.setText("Scatter Plot");
        tab2.setContent(vbox);
        final VBox vboxTab2 = new VBox();
        vboxTab2.setSpacing(10);
        vboxTab2.setTranslateX(10);
        vboxTab2.setTranslateY(10);

        // Tab2 Checkbox
        CheckBox cb2 = new CheckBox("Show predicted population changes");
        vboxTab2.getChildren().add(cb2);

        // Tab2 Charts
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