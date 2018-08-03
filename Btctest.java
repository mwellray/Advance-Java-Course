/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btctest;

/**
 *
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;
 
 
public class Btctest {
 static public double netflix = 9.99;
 Date today;
 static String ugh;
 static public double todayprice;
 static public double bitcoin;
 static public double price;
 static public double inputtest;
 static String datetest;
 
 //date format
 public static String dates() throws ParseException{   
   SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
   LocalDateTime now = LocalDateTime.now();
    Date dt = new Date();
    return ft.format(dt);
    }
     
   
 public static void todays() throws MalformedURLException, IOException{
     
    StringBuffer text1 = new StringBuffer();
       URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
       //HTTP basic requests without use of additional libraries
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//Default value is GET, others are POST HEAD OPTIONS PUT DELETE TRACE   


//Set - sets general request property, will overwrite if one exists
   //add - adds general request prop, will not overwrite
   //requestproperty specified by a key=value pair, (String Key, String Value)
     con.addRequestProperty("User-Agent", "USER_AGENT");
   
     BufferedReader rdr = new BufferedReader(new InputStreamReader(con.getInputStream()));
     String line;
     while ((line = rdr.readLine()) != null ) {
                text1.append(line);
            }
    rdr.close();
 
     
            //retrieving price, replacing \ and ,
            int start = text1.indexOf("symbol");
            int end = text1.indexOf("description");
            String no = text1.substring(start + 23 , end - 2);
            no = no.replace("\"","");
            no = no.replace(",","");
            todayprice = Double.parseDouble(no);
            System.out.println("Today: $" + todayprice);
        
 }
 
 //getting historical data
  public static void subscription(String x) throws MalformedURLException, IOException{
  StringBuffer text = new StringBuffer();
         String yy = new String();
               Date date = null;
               
               
               
       URL url = new URL ("https://api.coindesk.com/v1/bpi/historical/close.json?start=" + x + "&end=" + x);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
   
   con.addRequestProperty("User-Agent", "USER_AGENT");
   
     BufferedReader rdr = new BufferedReader(new InputStreamReader(con.getInputStream()));
     String line;
     while ((line = rdr.readLine()) != null ) {
                text.append(line);
            }
    rdr.close(); 
 
    
           
        String nn = new String();
        int n1 = text.indexOf(x); //begining of the date
         int end1 = text.indexOf("}");     
           
    
        String no = text.substring(n1 +11, end1);
          no = no.replace(":", "");
    
        price = Double.parseDouble(no);
    
 
  }
  
  
    
    public static void main(String[] args) throws ParseException, MalformedURLException, IOException {
       Scanner scn = new Scanner(System.in);
     
   String lth = "0";
    String lth2 = null;   
        System.out.println("Day of Bitcoin Bought and Price Today");
         System.out.println("Enter Date Bitcoin was bought:");
        
         while(lth.length() != 10){
         System.out.println("(Examples - > YYYY-MM-DD 2018-01-03  2017-12-01)");
         lth = scn.nextLine();
         }
        datetest = lth;
         System.out.println("Enter USD Amount:");
            System.out.println("(Examples - > 23.43, 500, 1000, ");
         //HOW TO ENTER *****************************************
     
        lth2 = scn.nextLine();
      
 
        inputtest = Double.parseDouble(lth2);
        System.out.println(inputtest);
    
      NumberFormat ter = NumberFormat.getNumberInstance(Locale.US);
      ter.setMaximumFractionDigits(8);
      ter.setMinimumFractionDigits(8);
        
        
        ugh = dates();
      
       todays();
       subscription(datetest);
     
       
       bitcoin = inputtest / price;
   
     
       
        String value1 = ter.format(bitcoin);
        double value = Double.parseDouble(value1);
        String convert = String.format("%.8f", value);  //trouble with scientific notation!
      
        System.out.println("Amount of Bitcoin: " + (convert) + " from " + datetest + " Cost for a Bitcoin = $" + price);
        value = value * todayprice;
        value = (double) Math.round(value*100)/100;
        System.out.println("Today $" + value); 
       
        System.out.println("\nPowered by CoinDesk  " + "https://www.coindesk.com/price/");
        
        
    }
}