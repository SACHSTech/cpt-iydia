package cpt;

import java.io.*;
import java.util.*;

public class DataCollection {
    private int fileLength = 150;

    ArrayList<Data> data;

    public DataCollection() {

    }
    
    public ArrayList<Data> getAllData(){
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/cpt/annual-population-growth.csv"));

            ArrayList<Data> data = new ArrayList<Data>();

            for(int j = 0; j < fileLength; j++){
                String[] elements = file.readLine().split(",");
                Data records = new Data(Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
                data.add(records);
            }
            this.data = data;
            file.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return data;
    }

    public ArrayList<Data> getEmpiricalData(int intThisYear){
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/cpt/annual-population-growth.csv"));

            ArrayList<Data> data = new ArrayList<Data>();

            for(int j = 0; j < fileLength; j++){
                String[] elements = file.readLine().split(",");
                Data records = new Data(Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
                data.add(records);
            }
            this.data = data;
            file.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return data;
    }

    public int getFileLength(){
        return fileLength;
    }
}