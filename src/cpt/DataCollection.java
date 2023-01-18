package cpt;

import java.io.*;
import java.util.*;

public class DataCollection{

    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("src/cpt/annual-population-growth.csv"));
        int fileLength = 150;
        
        ArrayList<Data> data = new ArrayList<Data>();

        for(int i = 0; i < fileLength; i++){
            String[] elements = file.readLine().split(",");
    
            data.add(new Data(elements[0], elements[1], Integer.parseInt(elements[2]), Integer.parseInt(elements[3])));
            //System.out.println(records.toString());
        }
        System.out.println(data.toString());
        file.close();
    }
}