package cpt;

import java.io.*;
import java.util.*;

public class DataCollection{
    ArrayList<Data> data = new ArrayList<Data>();

    public DataCollection(){

        try (BufferedReader file = new BufferedReader(new FileReader("src/cpt/annual-population-growth.csv"))) {
            int fileLength = 150;

            for(int i = 0; i < fileLength; i++){
                String[] elements = file.readLine().split(",");
                Data records = new Data(elements[0], elements[1], Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
                data.add(records);
            }
            file.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Data> getData(){
        return data;
    }
}