/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1Sp0104;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public String inputText(String msg) {
        String txt = "";
        System.out.print(msg);
        while (true) {
            Scanner sc = new Scanner(System.in);
            txt = sc.nextLine();
            if (txt.trim().isEmpty()) {
                System.out.print("Can not null, please input again: ");
            } else {
                break;
            }
        }
        return txt;
    }

    public void search(File file, String txt) {
        try {
            Scanner sc = new Scanner(file);
            int count = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();// đọc dữ liệu từng dòng 
                String arr[] = line.split(" ");
                for (String keyword : arr) {
                    if (keyword.toLowerCase().contains(txt.toLowerCase())) {
                        count++;
                        if (count == 1) {
                            System.out.println("\nSearch results: ");
                        }
                        System.out.println("    " + keyword);
                    }
                }
            }
            if (count == 0) {
                System.out.println("Not found");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        String searchFile = m.inputText("Please enter directory of file: ");
        File file = new File(searchFile);
        String txt = m.inputText("Please enter string to search: ");
        m.search(file, txt);

    }
}
