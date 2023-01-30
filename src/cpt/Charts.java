package cpt;

import javafx.application.Application;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Charts extends Application{
    private NumberAxis xAxis;
    private NumberAxis yAxis;

    /**
     * Constructor for chart
     * @param theXAxis the horizontal Numberaxis 
     * @param theYAxis the vertical NumberAxis
     */
    public Charts(NumberAxis theXAxis, NumberAxis theYAxis){
        this.xAxis = theXAxis;
        this.yAxis = theYAxis;
    }

    /**
     * Getter method for horizontal Numberaxis
     * @return the horizontal Numberaxis
     */
    public NumberAxis getXAxis(){
        return xAxis;
    }

    /**
     * Getter method for vertical Numberaxis
     * @return the vertical NumberAxis
     */
    public NumberAxis getYAxis(){
        return yAxis;
    }

    /**
     * Inherited abstract methods from parent class
     * @param arg0 the stage
     * @throws Exception
     */
    @Override
    public void start(Stage arg0) throws Exception { 
    }
}
