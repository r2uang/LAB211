/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.util.Scanner;

/**
 *
 * @author Quang
 */
class Validation {
    Scanner sc = new Scanner(System.in);
    public int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                int num;
                System.out.print(msg);
                num = Integer.parseInt(sc.nextLine());
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
}
