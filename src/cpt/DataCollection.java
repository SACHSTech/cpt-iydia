package cpt;

import java.io.*;
import java.io.FileReader;
import java.util.*;

public class DataCollection{
    public static void main(String[] args) throws IOException{
        int intCount = 0;

        BufferedReader file = new BufferedReader(new FileReader("src/cpt/income-inequality-before-and-after-taxes.csv"));
        ArrayList<Data> data = new ArrayList<Data>();

        for(intCount = 0; intCount < 180; intCount++){
            String[] records = file.readLine().split(",");
    
            Data elements = new Data(records[0], records[1], Integer.parseInt(records[2]), Double.parseDouble(records[3]), Double.parseDouble(records[4]));
            data.add(elements);
            System.out.println(elements.toString());
        }
        file.close();
    }
}