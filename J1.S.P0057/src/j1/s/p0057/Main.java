/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

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
        Management manager = new Management();
        Validation validator = new Validation();
        while (true) { 
             System.out.println("");
             System.out.println("====== USER MANAGEMENT SYSTEM ======");
             showMenu();
             int option = validator.getInt("Enter your option: ", "Option[1-3]", 1, 3);
             switch(option){
                 case 1:
                     manager.createAccount();
                     break;
                 case 2: 
                     manager.loginSystem();
                     break;
                 case 3: 
                     System.exit(0);
                     break;
             }
        }
    }

    private static void showMenu() {
        System.out.println("1: Create new account");
        System.out.println("2: Login System");
        System.out.println("3: Exit the program");
    }
    
}
