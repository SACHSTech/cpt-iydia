package cpt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Charts {
    private NumberAxis xAxis;
    private NumberAxis yAxis;

    private DataCollection collection = new DataCollection();

    public Charts(NumberAxis xAxis, NumberAxis yAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    /**
     * Method creates LineChart with integer axis for the filtered dataset of empirical data
     * @return the LineChart for the filtered dataset of empirical data
     */
    public ObservableList<Series<Integer, Integer>> lineChartCurrent() {
        ObservableList<XYChart.Data<Integer, Integer>> currentGrowthLineChart = FXCollections.observableArrayList();

        for(int i = 0; i <= collection.getCurrentYear(); i++) {
            currentGrowthLineChart.add(new XYChart.Data<>(collection.getCurrentData().get(i).getYear(), collection.getCurrentData().get(i).getPopulationGrowth()));
        }

        LineChart.Series<Integer, Integer> lineChart = new LineChart.Series<>("Annual Population Growth", currentGrowthLineChart);

        ObservableList<XYChart.Series<Integer,Integer>> lineChartData =
        FXCollections.observableArrayList();

        lineChartData.add(lineChart);

        return lineChartData;
    }

    /**
     * Method creates LineChart with integer axis for the filtered dataset of future values
     * @return the LineChart for the filtered dataset of future values
     */
    public ObservableList<Series<Integer, Integer>> lineChartFuture() {
        ObservableList<XYChart.Data<Integer, Integer>> currentGrowthLineChart = FXCollections.observableArrayList();
        ObservableList<XYChart.Data<Integer, Integer>> futureGrowthLineChart = FXCollections.observableArrayList();

        for(int i = 0; i <= collection.getCurrentYear(); i++) {
            currentGrowthLineChart.add(new XYChart.Data<>(collection.getCurrentData().get(i).getYear(), collection.getCurrentData().get(i).getPopulationGrowth()));
        }

        for(int i = collection.getCurrentYear(); i <= collection.getFileLength(); i++) {
            futureGrowthLineChart.add(new XYChart.Data<>(collection.getData().get(i).getYear(), collection.getData().get(i).getPopulationGrowth()));
        }

        LineChart.Series<Integer, Integer> lineChart = new LineChart.Series<>("Annual Population Growth", currentGrowthLineChart);
        LineChart.Series<Integer, Integer> newLineChart = new LineChart.Series<>("Future Population Growth", futureGrowthLineChart);

        ObservableList<XYChart.Series<Integer,Integer>> newLineChartData = FXCollections.observableArrayList();

        newLineChartData.add(lineChart);
        newLineChartData.add(newLineChart);

        return newLineChartData;
    }

    /**
     * Method creates ScatterChart with integer axis for the filtered dataset of empirical data
     * @return the ScatterChart for the filtered dataset of empirical data
     */
    public ScatterChart.Series<Integer, Integer> scatterChartCurrent(){
        final Series<Integer, Integer> currentGrowthScatterPlot = new Series<>();
        currentGrowthScatterPlot.setName("Annual Population Growth");

        for(int i = 0; i <= collection.getCurrentYear(); i++) {
            currentGrowthScatterPlot.getData().add(new XYChart.Data<>(collection.getCurrentData().get(i).getYear(), collection.getCurrentData().get(i).getPopulationGrowth()));
        }

        return currentGrowthScatterPlot;
    }

    /**
     * Method creates ScatterChart with integer axis for the filtered dataset of future values
     * @return the ScatterChart for the filtered dataset of future values
     */
    public ScatterChart.Series<Integer, Integer> scatterChartFuture(){
        final Series<Integer, Integer> futureGrowthScatterPlot = new Series<>();
        futureGrowthScatterPlot.setName("Future Population Growth");

        for(int i = collection.getCurrentYear(); i <= collection.getFileLength(); i++) {
            futureGrowthScatterPlot.getData().add(new XYChart.Data<>(collection.getData().get(i).getYear(), collection.getData().get(i).getPopulationGrowth()));
        }

        return futureGrowthScatterPlot;
    }

    public NumberAxis getXAxis(){
        return xAxis;
    }

    public NumberAxis getYAxis(){
        return yAxis;
    }

}
