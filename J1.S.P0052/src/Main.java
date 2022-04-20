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
          Validation validator = new Validation();
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        while (true) {
            System.out.println("1. Enter the information for 11 countries in Southeast Asia.\n"
                    + "2. Display already information.\n"
                    + "3. Search the country according to the entered country's name.\n"
                    + "4. Display the information increasing with the country name.\n"
                    + "5. Exit.");
            int option = validator.getInt("Enter your option: ", "Option[1-5]", 1, 5);
            switch(option){
                case 1:
                    manager.createCountry();
                    break;
                case 2:
                    manager.displayAllCountry();
                    break;
                case 3:
                    manager.searchCountry();
                    break;
                case 4:
                    manager.sortContry();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
