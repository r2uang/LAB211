/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quang
 */
public class EastAsiaCountry extends Country{
    private String countryTerrain;

    public EastAsiaCountry() {
    }

    public EastAsiaCountry(String countryCode, String countryName, float totalArea , String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-10s%-15s%-20s\n",countryCode,countryName,totalArea,countryTerrain);
    }
    
    
}
