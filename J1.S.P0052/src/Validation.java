
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
                if (num < min || num > max) {
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }
      
      public float getFloat(String msg, String err, float min, float max) {
        while (true) {
            try {

                float num;
                System.out.print(msg);
                num =  Float.parseFloat(in.readLine());
                if (num <= min || num > max) {
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception ex) {
                System.out.println(err);
            }
        }
    }
      
       public String getString(String msg, String err, String regex){
        while (true) {            
            try {
                String str;
                System.out.print(msg);
                str=in.readLine();
                if(str.matches(regex)){
                    return str;
                }else{
                    System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
}
