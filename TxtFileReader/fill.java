/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Maxwell Ray
 */
public class fill  {

    /**
     *
     */
    final public obj objects[];
    public  double nn = 0;  
    
    //constructor for 50 objects, chart only meant for 50days 
    public fill(){
    objects = new obj[50];
    }
        //fill object #, date, and amount
        public void fill(int k,String y, double x){
        objects[k] = new obj(y, x);   
        }
        //Print out all objects        
        public void print(){
        for(int i = 0; i < objects.length; i++){
        System.out.println(objects[i].getdate() + " " + objects[i].price());
             }
        }
               
        public obj[] get(){
            return objects;
        }
        
        
        //reading file and filling up objects
        //Explicit Exception Handling, Method can throw and responsibliity of the 
        //caller to handle. FileNotFound attempt to open the file denoted by a specified pathname has failed.
        //IO means input and output, exceptions include file not being available, no permission
        //to read/write a file, no disk space.
         public void check(String path) throws FileNotFoundException, IOException {
          String Line;
           
          File ugh = new File(path);
          //getting absolute path of file
           String ath = ugh.getAbsolutePath();
           //using absolute path
           File ugh2 = new File(ath);
           //delimiter for spacing, didnt need to use, whitespace is by default
           //next, nextLine, nextByte(scans next token as a byte), nextShort(),nextInt(), nextLong(), nextFloat(), nextDouble()
           Scanner rd = new Scanner(ugh2);//.useDelimiter("\\s");
     
         String token1; //dates
         String token2; //prices
             
         System.out.print("**PROGRAM OUTPUTS** File Exists - " + ugh2.exists());
          System.out.print(" | File Location: " + ath);
         System.out.print(" | File is Readable : " + ugh2.canRead());
         
        //fill up 50 objects 
         int count = 0;
        while( count < objects.length ) {
          token1 = rd.next(); //dates
          token2 = rd.next(); //prices
          //get rid of all commas
        double number = Double.parseDouble(token2.replaceAll(",", ""));
        //Use Fill method(above) 
        fill(count, token1, number);
       
            count++;
        
           }
        
         }
         
         
         //Return 50 day average
         public double fifty(){
            double nn = 0;
          
            for(int i = 0; i < objects.length; i++){
                
                nn += objects[i].price();
            }
              return nn/50;
             
           }
     
    

   
        
}
