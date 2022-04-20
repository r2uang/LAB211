/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quang
 */
public class Main {

    public static void main(String[] args) {
        ManagementEmployees manager = new ManagementEmployees();
        Validation validator = new Validation();

        while (true) {
            showMenu();
            int option = validator.getInt("Enter your option: ", "Option[1-6]", 1, 6);
            switch (option) {
                case 1:
                    manager.addEmployees();
                    break;
                case 2:
                    manager.updateEmployees();
                    break;
                case 3:
                    manager.removeEmployees();
                    break;
                case 4:
                    manager.searchEmployees();
                    break;
                case 5:
                    manager.sortEmployees();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }

        }
    }

    private static void showMenu() {
        System.out.println("1.Add employees \n"
                + "2.Update employees\n"
                + "3.Remove employees\n"
                + "4.Search employees\n"
                + "5.Sort employees by salary\n"
                + "6.Exit\n");
    }
}
