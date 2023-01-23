package cpt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Charts {
    private DataCollection collection = new DataCollection();
    private int intThisYear = 2023;

    public LineChart.Series<Integer, Integer> currentGrowthLineChart() {
        ObservableList<XYChart.Data<Integer, Integer>> currentGrowthLineChart = FXCollections.observableArrayList();

        for(int i = 0; i <= collection.getCurrentYear(); i++) {
            currentGrowthLineChart.add(new XYChart.Data<>(collection.getCurrentData(intThisYear).get(i).getYear(), collection.getCurrentData(intThisYear).get(i).getPopulationGrowth()));
        }

        LineChart.Series<Integer, Integer> lineChart = new LineChart.Series<>("Annual Population Growth", currentGrowthLineChart);

        return lineChart;
    }

    public LineChart.Series<Integer, Integer> futureGrowthLineChart() {
        ObservableList<XYChart.Data<Integer, Integer>> futureGrowthLineChart = FXCollections.observableArrayList();

        for(int i = collection.getCurrentYear(); i <= collection.getFileLength(); i++) {
            futureGrowthLineChart.add(new XYChart.Data<>(collection.getData().get(i).getYear(), collection.getData().get(i).getPopulationGrowth()));
        }

        LineChart.Series<Integer, Integer> newLineChart = new LineChart.Series<>("Future Population Growth", futureGrowthLineChart);

        return newLineChart;
    }

    public ScatterChart.Series<Integer, Integer> currentGrowthScatterPlot(){
        final Series<Integer, Integer> currentGrowthScatterPlot = new Series<>();
        currentGrowthScatterPlot.setName("Annual Population Growth");

        for(int i = 0; i <= collection.getCurrentYear(); i++) {
            currentGrowthScatterPlot.getData().add(new XYChart.Data<>(collection.getCurrentData(intThisYear).get(i).getYear(), collection.getCurrentData(intThisYear).get(i).getPopulationGrowth()));
        }

        return currentGrowthScatterPlot;
    }

    public ScatterChart.Series<Integer, Integer> futureGrowthScatterPlot(){
        final Series<Integer, Integer> futureGrowthScatterPlot = new Series<>();
        futureGrowthScatterPlot.setName("Future Population Growth");

        for(int i = collection.getCurrentYear(); i <= collection.getFileLength(); i++) {
            futureGrowthScatterPlot.getData().add(new XYChart.Data<>(collection.getData().get(i).getYear(), collection.getData().get(i).getPopulationGrowth()));
        }

        return futureGrowthScatterPlot;
    }
}
