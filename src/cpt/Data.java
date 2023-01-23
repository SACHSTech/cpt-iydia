package cpt;

public class Data extends DataCollection{
    private int intYear;
    private int intPopulationGrowth;

    public Data(int intYear, int intPopulationGrowth) {
        this.intYear = intYear;
        this.intPopulationGrowth = intPopulationGrowth;
    }

    public int getYear(){
        return intYear;
    }

    public int getPopulationGrowth(){
        return intPopulationGrowth;
    }

    public String toString(){
        return this.intYear + "," + this.intPopulationGrowth;
    }
}
