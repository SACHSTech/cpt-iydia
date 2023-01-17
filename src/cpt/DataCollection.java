package cpt;

import java.io.*;
import java.util.*;

public class DataCollection{
    static ArrayList<Data> byCountry = new ArrayList<Data>();
    static int[] filteredRows;

    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("src/cpt/income-inequality-before-and-after-taxes.csv"));
        ArrayList<Data> data = new ArrayList<Data>();

        for(int i = 0; i < 180; i++){
            String[] records = file.readLine().split(",");
    
            Data elements = new Data(records[0], records[1], Integer.parseInt(records[2]), Double.parseDouble(records[3]), Double.parseDouble(records[4]));
            data.add(elements);
            //System.out.println(elements.toString());
            filterByCountry("Canada");
        }
        file.close();
    }

    public static void filterByCountry(String strCountry) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("src/cpt/income-inequality-before-and-after-taxes.csv"));

        for(int i = 0; i < 180; i++){
            String[] records = file.readLine().split(",");

            if(records[0].equals(strCountry)){
                Data dataByCountry = new Data(records[0], records[1], Integer.parseInt(records[2]), Double.parseDouble(records[3]), Double.parseDouble(records[4]));
                //byCountry.add(dataByCountry);
                System.out.println(dataByCountry.toString());
            }
        }
    }
}