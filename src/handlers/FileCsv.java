/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Depoula
 */
public class FileCsv {
    
    private String csvFile;
    private ArrayList<String[]> fields;
    
    public FileCsv(String file){
        this.csvFile = file;
        this.fields = new ArrayList<String[]>();
    }
    public ArrayList<String[]> read() {        

        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";"; // Use comma as CSV columns separator

        try {
            br = new BufferedReader(new FileReader(csvFile));
            String s1[] = null;
            int i = 0;
                                   
            while ((line = br.readLine()) != null) {

                if (i > 0) { 
                    s1 = line.split(cvsSplitBy);
                   this.fields.add(s1);                    
                }
                i++;
            }
            br.close();
            return this.fields;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    
}
