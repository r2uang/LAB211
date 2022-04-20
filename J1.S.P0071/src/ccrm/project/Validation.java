/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccrm.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Quang
 */
public class Validation {
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                int num;
                System.out.print(msg);
                num = Integer.parseInt(in.readLine());
                if(num<min||num>max){
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }
    
    public double getDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                double num;
                System.out.print(msg);
                num = Double.parseDouble(in.readLine());
                if(num<min||num>max){
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }
    
     public String getString(String msg, String err, String regex) {
        while (true) {
            try {
                String str;
                System.out.print(msg);
                str = in.readLine();
                if (str.matches(regex)) {
                    return str;
                } else {
                    System.out.println(err);
                }
            } catch (IOException e) {
                System.out.println(err);
            }
        }
    }
     
     public String getDate(String msg,String err){
        while(true){
            try {
                Date date;
                System.out.print(msg);              
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
                sdf.setLenient(false);
                date = sdf.parse(in.readLine());
                return sdf.format(date);
            } catch (Exception e) {
                System.out.println(err);
            }
        }
}
    
    public String getIdName(String msg, String err){
        while(true){
            try {
                Validation validator = new Validation();
                String result = null;
                int option = validator.getInt("", err, 1, 4);
                switch(option){
                    case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
                    break;
                }
                return result;
            } 
            catch (Exception e) {
                System.out.println(err);
            }
        }
    }
   
    
}
