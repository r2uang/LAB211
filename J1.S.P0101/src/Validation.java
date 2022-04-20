
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public String getString(String msg, String err, String regex) {
        while (true) {
            try {
                String str;
                System.out.print(msg);
                str = sc.nextLine();
                if (str.matches(regex)) {
                    return str;
                } else {
                    System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public double getDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                double num;
                System.out.print(msg);
                num = Double.parseDouble(sc.nextLine());
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

    public String getSex(String msg, String err) {
        String str = "";
        while (true) {
            System.out.print(msg);
            str = sc.nextLine().trim();
            if (str.equalsIgnoreCase("male")||str.equalsIgnoreCase("female") || str.equalsIgnoreCase("other")) {
                return str;
            }
            else if(str.equals("")){
                return "";
            }
            else {
                System.out.println(err);
            }

        }
    }

    
    public String getDate(String msg, String err) {
        while (true) {
            try {
               Date date;
                String d;
                System.out.print(msg);
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                df.setLenient(false);
                d = sc.nextLine().trim();
                if (d.equals("")) {
                    return "";
                }
                date = df.parse(d);
                return df.format(date);
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
}
