package cpt;

public class Data extends DataCollection{
    private int intYear;
    private int intAnnualGrowth;

    public Data(int intYear, int intAnnualGrowth) {
        this.intYear = intYear;
        this.intAnnualGrowth = intAnnualGrowth;
    }

    public int getYear(){
        return intYear;
    }

    public int getAnnualGrowth(){
        return intAnnualGrowth;
    }

    public String toString(){
        return this.intYear + "," + this.intAnnualGrowth;
    }
}
