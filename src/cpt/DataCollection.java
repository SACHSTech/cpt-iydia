package cpt;

import java.io.*;
import java.io.FileReader;

public class DataCollection{
    public static void main(String[] args) throws IOException{
        int intCount = 0;
        String strCountry;
        String strCode;
        int intYear;
        double dblMarket;
        double dblDisposable;
        String strLine;

        BufferedReader file = new BufferedReader(new FileReader("src/cpt/income-inequality-before-and-after-taxes.csv"));
        Data[] data = new Data[180];

        for(intCount = 0; intCount < 180; intCount++){
            strLine = file.readLine();
            String[] records = strLine.split(",");
    
            strCountry = records[0];
            strCode = records[1];
            intYear = Integer.parseInt(records[2]);
            dblMarket = Double.parseDouble(records[3]);
            dblDisposable = Double.parseDouble(records[4]);

            Data elements = new Data(strCountry, strCode, intYear, dblMarket, dblDisposable);
            data[intCount] = elements;

            System.out.println(records[0] + "," + records[1] + "," + records[2] + "," + records[3] + "," + records[4]);
        }
        file.close();
    }
}
