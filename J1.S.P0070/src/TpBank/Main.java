/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class Main {
    private static Validation validator = new Validation();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit");
            int option = validator.getInt("Enter your option: ", "Option[1-3]", 1, 3);
            ResourceBundle bundle;
            switch(option){
                case 1:
                    bundle = ResourceBundle.getBundle("Tpbank.language_vi_VN");
                    login(bundle);
                    break;
                case 2:
                    bundle = ResourceBundle.getBundle("Tpbank.language_en_US");
                    login(bundle);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void login(ResourceBundle bundle) {
       getAccount(bundle);
       getPassWord(bundle);
       getCaptcha(bundle);
        System.out.println(bundle.getString("success"));
    }

    private static void getAccount(ResourceBundle bundle) {
        String accNumber = validator.getString(bundle.getString("account") , bundle.getString("account.error") , "[0-9]{10}");
    }

    private static void getPassWord(ResourceBundle bundle) {
        try {
            while(true){
            System.out.print(bundle.getString("password"));
            String passWord = in.readLine();
            if(passWord.length() < 8 || passWord.length() > 31){
                System.out.println(bundle.getString("password.error"));
                continue;
                }
            // Bắt buộc phải có chữ hoặc số 
            if(!passWord.matches("[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*")){ 
                    System.out.println(bundle.getString("password.error"));
                    continue;
                }
            if(!passWord.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")){
                    System.out.println(bundle.getString("password.error"));
                    continue;
                }
                break;
            }
            
        } catch (IOException ex) {
           System.out.println(bundle.getString("password.error"));
        }
       
    }

    private static void getCaptcha(ResourceBundle bundle) {
        while (true) {            
        String captcha = generateCaptcha();
        System.out.println("Captcha: " + captcha);
        String enterCaptcha = validator.getString(bundle.getString("captcha"),bundle.getString("captcha.error"), "[a-zA-Z0-9]{1,5}");
        if(!captcha.contains(enterCaptcha)){
            System.out.println(bundle.getString("captcha.incorrect"));
            continue;
            }
        break;
        }
    }

    private static String generateCaptcha() {
        Random random = new Random();
        String s = "";
        String captcha = "";
        for(char i = 'a' ; i <= 'z'; i++){
            s = s + i;
        }
        for(char i = 'A' ; i <= 'Z'; i++){
            s = s + i;
        }
        for(char i = '0' ; i <= '9'; i++){
            s = s + i;
        }
        
        for (int i = 0; i < 6; i++) {
            captcha += s.charAt(random.nextInt(s.length()));
        }
        return captcha;
    }
}
