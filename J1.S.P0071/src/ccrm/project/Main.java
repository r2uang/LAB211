/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccrm.project;

/**
 *
 * @author Quang
 */
public class Main {
    public static void main(String[] args) {
        Validation validator = new Validation();
        ManagementTask manager = new ManagementTask();
        
        while(true){
            showMenu();
            int option = validator.getInt("Enter your option: ", "Option(1-4)", 1, 4);
            switch(option){
                case 1:
                    manager.addTask();
                    break;
                case 2:
                    manager.deleteTask();
                    break;
                case 3:
                    manager.showTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
                    
            }
        }
    }

    private static void showMenu() {
        System.out.println("======== Task program =========");
        System.out.println("1. Add Task\n" +
                           "2. Delete task\n" +
                           "3. Display task\n" +
                           "4. Exit");
    }
}
