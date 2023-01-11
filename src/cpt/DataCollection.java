package cpt;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

// Entity,Code,Year,Gini equivalised market household income entire pop (Incomes across the Distribution Database (2016)),Gini equivalised disposable household income entire pop (Incomes across the Distribution Database (2016))

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

        while(intCount < 180){
            strLine = file.readLine();
            String[] elements = strLine.split(",");

            strCountry = elements[0];
            strCode = elements[1];
            intYear = Integer.parseInt(elements[2]);
            dblMarket = Double.parseDouble(elements[3]);
            dblDisposable = Double.parseDouble(elements[4]);

            Data what = new Data(strCountry, strCode, intYear, dblMarket, dblDisposable);
            data[intCount] = what;

            intCount++;
            System.out.println(elements[0] + "," + elements[1] + "," + elements[2] + "," + elements[3] + "," + elements[4]);
        }

        file.close();
    }
}
