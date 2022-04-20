/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public Date inputDate() {
        Date d = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false); // check xem ngày có hợp lệ hay không VD:30/02/2021 không hợp lệ
        Scanner sc = new Scanner(System.in);        
        while (true) {
            try {
                d = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid date, please input again: ");
            }
        }
        return d;
        
    }
    
    
    public static void main(String[] args) {
        Date date;
        Main cd = new Main();
        System.out.print("Please enter date with format [dd/mm/yyyy]:");
        date = cd.inputDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); 
        System.out.println("Your day is " + simpleDateformat.format(date));
    }

}
