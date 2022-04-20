/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        Validation validator = new Validation();
        View view = new View();
        while (true) {
            showMenu();
            int option = validator.getInt("Enter your option: ", "Option[1-5]", 1, 5);
            switch (option) {
                case 1:
                    view.addStudent();
                    break;
                case 2:
                    view.FindAndSort();
                    break;
                case 3:
                    view.UpdateOrDelete();
                    break;
                case 4:
                    view.Report();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void showMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.Create\n"
                + "2.Find and Sort\n"
                + "3.Update/Delete\n"
                + "4.Report\n"
                + "5.Exit");
    }
}
