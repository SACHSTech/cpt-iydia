package cpt;

import java.io.*;
import java.util.*;

public class DataCollection {
    private int fileLength = 150;
    private int intCurrentYear;

    ArrayList<Data> data;
    ArrayList<Data> currentData;

    int[] annualGrowth;
    
    public ArrayList<Data> getData(){
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/cpt/annual-population-growth.csv"));

            ArrayList<Data> data = new ArrayList<Data>();

            // Adding elements to an array
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

    public ArrayList<Data> getCurrentData(int intThisYear){
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/cpt/annual-population-growth.csv"));

            ArrayList<Data> currentData = new ArrayList<Data>();

            // Adding elements to an array
            for(int i = 0; i < fileLength; i++){
                String[] elements = file.readLine().split(",");
                Data records = new Data(Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
                if(Integer.parseInt(elements[2])<=intThisYear){
                    currentData.add(records);
                    intCurrentYear = i;
                }
            }
            this.currentData = currentData;
            file.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return currentData;
    }

    public int getFileLength(){
        return fileLength-1;
    }

    public int getCurrentYear(){
        return intCurrentYear;
    }

    public int getSmallestGrowth(ArrayList<Data> arr){
        int temp;
        int[] annualGrowth = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++){
            annualGrowth[i] = arr.get(i).getPopulationGrowth();
        }

        for (int i = 0; i < arr.size(); i++){  
            for (int j = i + 1; j < arr.size(); j++){  
                if (annualGrowth[i] > annualGrowth[j]){  
                    temp = annualGrowth[i];  
                    annualGrowth[i] = annualGrowth[j];  
                    annualGrowth[j] = temp;  
                }  
            }  
        }  

        return annualGrowth[0];
    }

    public int getLargestGrowth(ArrayList<Data> arr){
        int temp;
        int[] annualGrowth = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++){
            annualGrowth[i] = arr.get(i).getPopulationGrowth();
        }

        for (int i = 0; i < arr.size(); i++){  
            for (int j = i + 1; j < arr.size(); j++){  
                if (annualGrowth[i] > annualGrowth[j]){  
                    temp = annualGrowth[i];  
                    annualGrowth[i] = annualGrowth[j];  
                    annualGrowth[j] = temp;  
                }  
            }  
        }  

        return annualGrowth[arr.size()-1];
    }

}