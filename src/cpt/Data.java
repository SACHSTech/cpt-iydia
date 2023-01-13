package cpt;

public class Data extends DataCollection{
    private String strCountry;
    private String strCode;
    private int intYear;
    private double dblMarket;
    private double dblDisposable;

    public Data(String strCountry, String strCode, int intYear, double dblMarket, double dblDisposable){
        this.strCountry = strCountry;
        this.strCode = strCode;
        this.intYear = intYear;
        this.dblMarket = dblMarket;
        this.dblDisposable = dblDisposable;
    }

    public String getCountry(){
        return strCountry;
    }

    public String getCode(){
        return strCode;
    }

    public int getYear(){
        return intYear;
    }

    public double getMarket(){
        return dblMarket;
    }

    public double getDisposable(){
        return dblDisposable;
    }

    public String tostring(){
        return this.strCountry + "," + this.strCode + "," + this.intYear + "," + this.dblMarket + "," + this.dblDisposable;
    }
}
