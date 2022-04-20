/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class View {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private Validation validator = new Validation();
    private Management manager = new Management();

    void addStudent() {
        int count = manager.getListSize();
        while (true) {
            if (count > 10) {
                String choice = validator.getString("Do you want to continue (Y/N)?\nYour Choice : ", "Choice(y/n)", "^[yYnN]");
                if (choice.equalsIgnoreCase("n")) {
                    break;
                }
            }
            int id = validator.getInt("Enter ID: ", "ID must be positive integer and not digits", 1, Integer.MAX_VALUE);
            int indexStudentById = manager.findStudentById(id);
            String name = "";
            if (indexStudentById == -1) { // nếu id student không có trong list thì create tên mới không thì lấy tên cũ
                name = validator.getString("Enter Student name: ", "Student name invalid", "^[a-zA-Z ]+");
            } else {
                Student oldStudent = manager.getStudentByIndex(indexStudentById);
                name = oldStudent.getName();
            }
            int semester = validator.getInt("Enter semester: ", "Semester [1-9]", 1, 9);
            System.out.println("Course : java,.net,c/c++");
            String course = validator.checkInpuCourse("Enter course: ", "Course(java,.net,c/c++)");
            if (manager.isStudentExisted(id, name, semester, course) == true) {
                System.out.println("Information is dupplicates");
                continue;
            } else {
                manager.addStudent(id, name, semester, course);
            } 
            System.out.println("Add Successfully");
            count++;
            continue;
        }
    }

    void FindAndSort() {
        String keyWord = validator.getString("Enter Name to Find and Sort : ", "Student name invalid", "[a-zA-Z ]+");
        manager.FindAndSort(keyWord);
    }

    void UpdateOrDelete() {
        if (manager.checkListIsEmpty() == -1) {
            System.out.println("List is empty");
            return;
        }
        List<Student> listStudentsUpdate = new ArrayList<>();
        int id = validator.getInt("Enter ID: ", "ID must be positive integer and not digits", 1, Integer.MAX_VALUE);
        if (manager.checkIdExisted(id) == -1) {
            System.out.println("Student not exist");
        } else {
            for (Student s : manager.getList()) {
                if (s.getId() == id) {
                    listStudentsUpdate.add(s);
                }
            }
            manager.displayStudentByIndex(listStudentsUpdate);
            int index = validator.getInt("Choose index you want to update: ", "Student not exist", 1, listStudentsUpdate.size());
            int indexStudent = manager.findStudent(listStudentsUpdate.get(index - 1));
            Student studentUpdate = manager.getStudentByIndex(indexStudent);
            String choice = validator.getString("Do you want to update (U) or delete (D) student? \nYour Choice: ", "You must enter (U/D)", "[UuDd]");
            if (choice.equalsIgnoreCase("u")) {
                String oldName = studentUpdate.getName();
                System.out.print("Enter Name: ");
                String newName = Validation.getUpdateName();
                if (newName.isEmpty()) {
                    newName = studentUpdate.getName();
                }
                System.out.print("Enter Semester: ");
                int newSemester = Validation.getUpdateSemester();
                if (newSemester == -1) {
                    newSemester = studentUpdate.getSemester();
                }
                System.out.print("Enter Course Name: ");
                String newCourse = Validation.getUpdateCourseName();
                if (newCourse.isEmpty()) {
                    newCourse = studentUpdate.getCourse();
                }
                if (manager.isStudentExisted(id, newName, newSemester, newCourse) == true) { //Nếu mà trùng thông tin cũ thì duplicates 
                    System.out.println("Dupplicates Information");
                    return;
                } else if (checkUpdateStudentExisted(id, newSemester, newCourse) == false) {//Nếu khác thông semester,course cũ
                    for (Student st : listStudentsUpdate) {
                        if (st.getName().equals(oldName)) {
                            st.setName(newName);
                        }
                    }
                    studentUpdate.setSemester(newSemester);
                    studentUpdate.setCourse(newCourse);
                } else {
                    for (Student st : listStudentsUpdate) {
                        if (st.getName().equals(oldName)) {
                            st.setName(newName);
                        }
                    }
                }
                manager.displayStudentByIndex(listStudentsUpdate);
                System.out.println("Update Successfully");
                System.out.println("");
            } //Delete
            else {
                manager.removeStudent(indexStudent);
                System.out.println("Delete Successfully");
            }
            manager.UpdateOrDelete(indexStudent, studentUpdate);
        }
    }

    void Report() {
        if (manager.checkListIsEmpty() == -1) {
            System.out.println("List is empty");
            return;
        }
        manager.Report();
    }

    private boolean checkUpdateStudentExisted(int id, int newSemester, String newCourse) {
        for (Student st : manager.getList()) {
            if (st.getId() == id && st.getSemester() == newSemester && st.getCourse().equals(newCourse)) {
                return true;
            }
        }
        return false;
    }
}
