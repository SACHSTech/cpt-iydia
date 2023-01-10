package cpt;

public class Data {
    String strCountry;
    String strCode;
    int intYear;
    double dblMarket;
    double dblDisposable;

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
}
