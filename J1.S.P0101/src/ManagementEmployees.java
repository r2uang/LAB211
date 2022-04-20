
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
class ManagementEmployees {

    Validation validator = new Validation();
    List<Employees> listEmployees;
    Employees E;
    int NOT_EXISTS = -1;

    public ManagementEmployees() {
        listEmployees = new ArrayList<>();
        listEmployees.add(new Employees("Ep01", "Tien", "Quang", "0832439288", "quangkt123@gmail.com", "Yen Bai", "28-12-2001", "Male", 2000, "CS1"));
        listEmployees.add(new Employees("Ep02", "Duy", "Hiep", "0912369147", "hiepdd100@gmail.com", "Ha Nam", "01-12-2001", "Male", 10000, "CS2"));
        listEmployees.add(new Employees("Ep03", "The", "Ky", "09123456789", "kykt2000@gmail.com", "Vinh", "16-5-2001", "Male", 5000, "CS3"));
    }

    void addEmployees() {
        String id = "";
        do {
            id = validator.getString("Enter code: ", "Code is only numbers or digits", "[a-zA-z0-9 ]+");
            if (indexID( id) != -1) { //nếu mà code nhập vào mà tồn tại trong list thì in ra dòng ở dưới 
                System.out.println("Code is exist,please enter another code");
            }
        } while (indexID(id) != -1);
        String firstName = validator.getString("Enter first name: ", "First name is only digits", "[a-zA-z ]+");
        String lastName = validator.getString("Enter last name: ", "Last name is only digits", "[a-zA-z ]+");
        String phone = validator.getString("Enter phone: ", "Invalid, Please re-enter", "0[0-9]{9,10}");
        String email = validator.getString("Enter email: ", "Invalid email", "[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}");
        String address = validator.getString("Enter address: ", "Invalid address", "[a-zA-Z0-9 ]+");
        String dOb= "";
        do{
            dOb = validator.getDate("Enter date of bird: ", "Invalid date,Date must with format (dd-MM-yyyy)");
            if(dOb.equals("")){
                System.out.println("Invalid date !!");
            }
        }while(dOb.equals(""));
        String sex = "";
        do {            
             sex = validator.getSex("Enter sex: ", "Sex(Male,Female,Other)");
             if(sex.equals("")){
                 System.out.println("Sex(Male,Female,Other)");
             }
        } while (sex.equals(""));  
        double salary = validator.getDouble("Enter salary: ", "Salary must be positive", 0, Double.MAX_VALUE);
        String egency = validator.getString("Enter agency: ", "Invalid angency", "[a-zA-z0-9 ]+");
        Employees eply = new Employees(id, firstName, lastName, phone, email, address, dOb, sex, salary, egency);
        listEmployees.add(eply);
        displayEmployees();
        System.out.println("Add successfully");

    }

    void updateEmployees() {
        if (listEmployees.isEmpty()) {
            System.out.println("List employeese is empty");
        }
        String id = validator.getString("Enter code: ", "Code is only numbers or digits", "[a-zA-z0-9 ]+");
        int index = indexID(id);
        if (index != -1) {
            System.out.println("Note: if you do not want to update any information, press ENTER or SPACE to skip it !");
            String newFirstName = validator.getString("Enter first name: ", "Last name  is only digits", "[a-zA-z ]+|([ ]*)");
            
            if (!newFirstName.trim().equals("")) {
                listEmployees.get(index).setFirstName(newFirstName);
            }
            String newLastName = validator.getString("Enter last name: ", "Name is only digits", "[a-zA-z ]+|([ ]*)");
            if (!newLastName.trim().equals("")) {
                listEmployees.get(index).setLastName(newLastName);
            }
            
            String newPhone = validator.getString("Enter new phone: ", "Invalid, Please re-enter", "0[0-9]{9,10}|([ ]*)");
            if (!newPhone.trim().equals("")) {
                listEmployees.get(index).setPhone(newPhone);
            }
            
            String newEmail = validator.getString("Enter new email: ", "Invalid email", "[a-zA-Z0-9 ]+@[a-zA-Z0-]+(\\.[a-zA-Z]+){1,3}|([ ]*)");
            if (!newEmail.trim().equals("")) {
                listEmployees.get(index).setEmail(newEmail);
            }
            
            String newAddress = validator.getString("Enter address: ", "Invalid address", "[a-zA-Z0-9 ]+|([ ]*)");
            if (!newAddress.trim().equals("")) {
                listEmployees.get(index).setAddress(newAddress);
            }
            
            String newDob = validator.getDate("Enter date of bird: ", "Invalid date,Date must with format (dd-MM-yyyy)");
            if (!newDob.trim().equals("")) {
                listEmployees.get(index).setDOB(newDob);
            }
            
            String newSex = validator.getSex("Enter sex: ", "Sex(Male,Female,Other)");
            if (!newSex.trim().equals("")) {
                listEmployees.get(index).setSex(newSex);
            }
            
            String newSalary = validator.getString("Enter new salary: ", "Please enter a positive number", "([0-9 ]+)|([ ]*)");
            if (!newSalary.trim().equals("")) {
                listEmployees.get(index).setSalary(Double.parseDouble(newSalary));
            }
            
            String newAgency = validator.getString("Enter agency: ", "Invalid angency", "[a-zA-z0-9 ]+|([ ]*)");
            if (!newAgency.trim().equals("")) {
                listEmployees.get(index).setEgency(newAgency);
            }
            
            System.out.println("Update successfully");
        } else {
            System.out.println("Employees id is not exist");
        }

    }

    void removeEmployees() {
        if (listEmployees.isEmpty()) {
            System.out.println("List Employ is empty");
        }
        String id = validator.getString("Enter code: ", "Code is only numbers or digits", "[a-zA-z0-9 ]+");
        int index = indexID(id);
        if (index != -1) {
            listEmployees.remove(index);
            System.out.println("Remove successfully");
        } else {
            System.out.println("Employees id is not exist");
        }
    }

    void searchEmployees() {
        if (listEmployees.isEmpty()) {
            System.out.println("List Employees is empty !");
        }
        int count = 0; 
        String keyWord = validator.getString("Enter First Name or Last Name to search: ", "Invalid, please re enter !\n", "[a-zA-Z0-9 ]+");
        System.out.println("                            --------- Result ------------");
        System.out.format("%-10s%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n", "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employees E : listEmployees) {
            if (E.getFirstName().toLowerCase().contains(keyWord.toLowerCase())||E.getLastName().toLowerCase().contains(keyWord.toLowerCase()) || keyWord.equals(" ")) {
                count++;               
                System.out.println(E);              
            } 
        }
        if(count == 0){
            System.out.println("Not Exist");
        }
        
    }

    void sortEmployees() {
        Collections.sort(listEmployees, new Comparator<Employees>() {
            @Override
            public int compare(Employees o1, Employees o2) { //o1 là đối tượng đứng trước o2 là đối tượng đứng sau
                if (o1.getSalary() > o2.getSalary()) { 
                    return 1; // đổi chỗ 
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1; //không đổi 
                } else {
                    return 0; // không đổi
                }
            }
        });
        displayEmployees();
    }

    public int indexID(String id) {
        for (int i = 0; i < listEmployees.size(); i++) {
            if (listEmployees.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void displayEmployees() {
        System.out.format("%-10s%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n", "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employees listEmployee : listEmployees) {
            System.out.println(listEmployee.toString());
        }
    }
}
