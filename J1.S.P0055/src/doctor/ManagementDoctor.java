/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public class ManagementDoctor {
      
        Validation validator = new Validation();
        List<Doctor> listDoctors;
        Scanner sc = new Scanner(System.in);
        int NOT_EXIST = -1;
        
    public ManagementDoctor() {
          listDoctors = new ArrayList<>(); 
          listDoctors.add(new Doctor("DOC 1","Nghia","Orthopedics", 3));
          listDoctors.add(new Doctor("DOC 2","Phuong","Obstetrics", 2));
          listDoctors.add(new Doctor("DOC 3","Lien","orthodontic", 1));
    }
        
    public void addDoctor() {
        String code = "";
        do{
        code = validator.getString("Enter Code: ", "Code includes letter and digit ", "[a-zA-Z 0-9]+");
        if(indexCode(listDoctors,code) != -1){ //index != -1 ( ton tai khi khac -1 ) index = -1 chua ton tai
            System.out.println("Code is exist,please enter another code !");
            }
        }while(indexCode(listDoctors,code) != -1);
        
        String name = validator.getString("Enter Name: ", "Name includes letter only", "[a-zA-Z ]+");
        String spec = validator.getString("Enter Specialization: ", "Specialization includes letter and digit", "[a-zA-Z0-9 ]+");
        int avail = validator.getInt("Enter Availability: ", "Please enter a positive integer number", 1, Integer.MAX_VALUE);
        Doctor doctor = new Doctor(code, name, spec, avail);
        listDoctors.add(doctor);
        System.out.println("Add Doctor successfully !");
    }

    public void updateDoctor() {
        if(listDoctors.isEmpty()){
            System.out.println("List Empty !");
        }
          String code = validator.getString("Enter Code: ", "Code includes letter and digit ", "[a-zA-Z 0-9]+");
          int index = indexCode(listDoctors,code);
          if(index != -1){
             String newName = validator.getString("Enter new Name: ", "Name includes letter only", "[a-zA-Z ]+");
            if(!newName.trim().equals("")){ //nếu name rỗng thì giữ nguyên giá trị cũ nếu không thì xét lại
                listDoctors.get(index).setName(newName);
            }          
            String newSpec = validator.getString("Enter new specialization: ", "Specialization includes letter and digit", "[a-zA-Z 0-9]+");
              if(!newSpec.trim().equals("")){
                listDoctors.get(index).setSpecialization(newSpec);
            }
            String newAvail = validator.getString("Enter new Availability: ", "Please enter a positive integer number", "([0-9 ]+)|([ ]*)");
            if(!newAvail.trim().equals("")){
                listDoctors.get(index).setAvailability(Integer.parseInt(newAvail));
            }
             System.out.println("Update Doctor successfully");
          }
          else{
              System.out.println("Doctor code doesn’t exist !");
          }    
    }

    public void deleteDoctor() {
        if(listDoctors.isEmpty()){
            System.out.println("List Empty !");
        }
          String code = validator.getString("Enter Code: ", "Code includes letter and digit ", "[a-zA-Z0-9 ]+");
          int index = indexCode(listDoctors, code);
          if(index != -1){
              listDoctors.remove(index);
              System.out.println("Delete succesfully !");
          }
          else{
              System.out.println("Doctor code doesn’t exist !");
          }
    }

    void searchDoctor() {
        if(listDoctors.isEmpty()){
            System.out.println("List Empty !");
        }
        while(!listDoctors.isEmpty()){
        System.out.println("-------- Search Doctor --------");
        System.out.print("Enter Text: ");
        String keyword = sc.nextLine(); 
        System.out.println("-------- Result --------");
        System.out.format("%-8s%-10s%-20s%-20s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor D : listDoctors) {
            if(D.getCode().toLowerCase().contains(keyword.toLowerCase()) || D.getName().toLowerCase().contains(keyword.toLowerCase()) || 
                    D.getSpecialization().toLowerCase().contains(keyword.toLowerCase()) ){
                System.out.println(D);
            }
        }
        break;
        }
    }

    private int indexCode(List<Doctor> listDoctors, String code) { // tim vi tri roi tra ve index
        for (int i = 0; i < listDoctors.size(); i++) {
            Doctor D = listDoctors.get(i);
            if(D.getCode().replaceAll("\\s+", "").equalsIgnoreCase(code.replaceAll("\\s+", ""))){ //index co code bang code nguoi dung nhap 
                return i; // tra ve index
            }
        }
        return -1;
    }
   
}
