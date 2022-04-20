/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class Main {
    //https://docs.google.com/document/d/1bfq7ruDNSXQFk3ufwXgmAcID1WvaP1LJ/edit
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
        Date f, s;
        Main cd = new Main();
        System.out.print("Please enter the first date:");
        f = cd.inputDate();
        System.out.print("Please enter the second date:");
        s = cd.inputDate();
        if (f.before(s)) {
            System.out.println("Date1 is before Date2");
        } else if (s.before(f)) {
            System.out.println("Date2 is before Date1");
        } else {
            System.out.println("Date2 is equal Date1");
        }
    }
}
