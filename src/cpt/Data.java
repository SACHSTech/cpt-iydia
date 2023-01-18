package cpt;

public class Data extends DataCollection{
    private String strCountry;
    private String strCountryCode;
    private int intYear;
    private int intAnnualGrowth;

    public Data(String strCountry, String strCode, int intYear, int intAnnualGrowth){
        this.strCountry = strCountry;
        this.strCountryCode = strCode;
        this.intYear = intYear;
        this.intAnnualGrowth = intAnnualGrowth;
    }

    public String getCountry(){
        return strCountry;
    }

    public String getCode(){
        return strCountryCode;
    }

    public int getYear(){
        return intYear;
    }

    public double getAnnualGrowth(){
        return intAnnualGrowth;
    }

    public String toString(){
        return this.strCountry + "," + this.strCountryCode + "," + this.intYear + "," + this.intAnnualGrowth;
    }
}
