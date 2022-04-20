/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

/**
 *
 * @author Quang
 */
public class Main {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        // TODO code application logic here
        //https://docs.google.com/document/d/1JpwKwLJATKaMds3KVXzNDXE-qMGt618k/edit
        
        Validation validator = new Validation();
        ManagementDoctor manager = new ManagementDoctor();
        while (true) {
            System.out.println("========= Doctor Management ========");
            showMenu();
            int option = validator.getInt("Enter your option: ", "Option[1-5]", 1, 5);
            switch (option) {
                case 1:
                    manager.addDoctor();
                    break;
                case 2:
                    manager.updateDoctor();
                    break;
                case 3:
                    manager.deleteDoctor();
                    break;
                case 4:
                    manager.searchDoctor();                       
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("1.Add Doctor\n"
                + "2.Update Doctor\n"
                + "3.Delete Doctor\n"
                + "4.Search Doctor\n"
                + "5.Exit");
    }

}
