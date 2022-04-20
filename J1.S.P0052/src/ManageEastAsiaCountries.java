
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quang
 */
public class ManageEastAsiaCountries {
    private List<EastAsiaCountry> listCountry;
    private Validation validator = new Validation();
    public ManageEastAsiaCountries() {
        listCountry = new ArrayList<>();
    }

    public List<EastAsiaCountry> getListCountry() {
        return listCountry;
    }

    public void setListCountry(List<EastAsiaCountry> listCountry) {
        this.listCountry = listCountry;
    }

    void createCountry() {
        String code = ""; 
        while (true) {             
            code= validator.getString("Enter Code of country: ", "Code invalid !","[A-Z]+");
        if(isExist(listCountry,code)){
            System.out.println("Code is exist");
            continue;
            }
        break;
        }
        String name = validator.getString("Enter Name of country: ", "Name invalid !", "^[a-zA-Z ]+");
        float area = validator.getFloat("Enter total area of country: ", "Total area must be greater than 0", 0, Float.MAX_VALUE);
        String terrain = validator.getString("Enter terrain of country: ","Terrain invalid ! ", "[a-zA-z ]+");
        EastAsiaCountry eac = new EastAsiaCountry(code, name, area, terrain);
        listCountry.add(eac);
        System.out.println("Add Country SuccessFully");
        
    }

    void displayAllCountry() {
        System.out.println("List All Country");
        System.out.format("%-10s%-10s%-15s%-20s\n","ID","Name","Total Area","Terrain");
        for (EastAsiaCountry eastAsiaCountry : listCountry) {
            eastAsiaCountry.display();
        }
    } 

    void searchCountry() {
        String keyword = validator.getString("Enter Name to search: ", "Name invalid !", "^[a-zA-Z ]+");
        int count = 0;
        System.out.println("List All Country");
        System.out.format("%-10s%-10s%-15s%-20s\n","ID","Name","Total Area","Terrain");
        for (EastAsiaCountry eastAsiaCountry : listCountry) {
            if(eastAsiaCountry.getCountryName().toLowerCase().contains(keyword.toLowerCase()) || keyword.matches("[\\s]+")){
               count++;
               eastAsiaCountry.display();
            }
        }
        if(count == 0){
            System.out.println("Country is not Exist !!");
        }
    }

    void sortContry() {
        Collections.sort(listCountry,new Comparator<EastAsiaCountry>() {
            @Override
            public int compare(EastAsiaCountry o1, EastAsiaCountry o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
        displayAllCountry();
    }

    private boolean isExist(List<EastAsiaCountry> listCountry, String code) {
         for (EastAsiaCountry eac : listCountry) {
            if (eac.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
    
}
   