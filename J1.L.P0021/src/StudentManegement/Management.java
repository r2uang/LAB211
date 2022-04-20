/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Quang
 */
public class Management {

    private List<Student> listStudents;
    private final int NOT_EXIST = -1;
    private Validation validator = new Validation();

    public Management() {
        listStudents = new ArrayList<>();
        listStudents.add(new Student(1, "Nguyen Van A", 1, "java"));
        listStudents.add(new Student(1, "Nguyen Van A", 2, "java"));
        listStudents.add(new Student(2, "Nguyen Van B", 1, "java"));
        listStudents.add(new Student(3, "Nguyen Van C", 2, ".net"));
        listStudents.add(new Student(3, "Nguyen Van C", 1, "c/c++"));
        listStudents.add(new Student(6, "Nguyen Van D", 2, "java"));
        listStudents.add(new Student(7, "Nguyen Van E", 1, "c/c++"));
        listStudents.add(new Student(8, "Nguyen Van F", 2, ".net"));
        listStudents.add(new Student(9, "Nguyen Van F", 8, "c/c++"));
    }

    public int getListSize() {
        return listStudents.size();
    }

    public List<Student> getList() {
        return listStudents;
    }

    public int addStudent(int id, String name, int semester, String course) {
        Student student = new Student(id, name, semester, course);
        try {
            listStudents.add(student);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public void FindAndSort(String keyWord) {
        List<Student> listStudents = findStudentByName(this.listStudents, keyWord);
        sortListStudent(listStudents);
        displayStudent(listStudents);
    }

    public int checkListIsEmpty() {
        if (listStudents.isEmpty()) {
            return -1;
        }
        return 1;
    }

    public int UpdateOrDelete(int index, Student student) {
        if (index < 0) {
            return -1;
        }
        listStudents.set(index, student);
        return 1;
    }

    void Report() {
        String[] courses = new String[]{"java", ".net", "c/c++"};
        List<Report> listReports = new ArrayList<>();
        for (String course : courses) {
            for (Student student : listStudents) {
                if (student.getCourse().equalsIgnoreCase(course)) {
                    int count = countTotalCourseByStudentId(listStudents, student.getId(), course);
                    if (count != 0) {
                        Report studentReport = new Report(student.getId(), student.getName(), student.getCourse(), count);
                        if (findReportByIdAndCourse(listReports, student.getId(), student.getCourse()) == NOT_EXIST) { // Kiểm tra xem học sinh đã được thống kê chưa
                            listReports.add(studentReport);
                        }
                    }
                }
            }
        }
        displayReport(listReports);
    }

    private List<Student> findStudentByName(List<Student> List, String keyWord) {
        List<Student> results = new ArrayList<>();
        for (Student student : List) {
            if (student.getName().toLowerCase().contains(keyWord.toLowerCase()) || keyWord.equals(" ")) {
                results.add(student);
            }
        }
        return results;
    }

    //Note sửa
    private String reverseWord(String s) {
        String[] word = s.split("\\s+");
        StringBuffer sb = new StringBuffer("");
        for (int i = word.length - 1; i >= 0; i--) {
            sb.append(word[i] + " ");
        }
        return sb.toString().trim();
    }

    private void sortListStudent(List<Student> listStudents) {
        Collections.sort(listStudents, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return reverseWord(o1.getName()).compareToIgnoreCase(reverseWord(o2.getName()));
            }
        });
    }

    public void displayStudent(List<Student> listStudents) {
        System.out.println("List Student");
        for (Student listStudent : listStudents) {
            System.out.println(listStudent.toString());
        }
        System.out.println("");
    }

    public void displayStudentByIndex(List<Student> listStudents) {
        System.out.println("List Student");
        int count = 1;
        for (Student listStudent : listStudents) {
            System.out.print(count);
            System.out.print(listStudent.toString());
            count++;
            System.out.println("");
        }
        System.out.println("");
    }

    public int findStudentById(List<Student> listStudents, int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student get = listStudents.get(i); // lấy đối tượng students tại vị trí i
            if (get.getId() == id) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    public int findStudentById(int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student get = listStudents.get(i); // lấy đối tượng students tại vị trí i
            if (get.getId() == id) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    public int findStudent(Student student) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student get = listStudents.get(i);
            if (get.equals(student)) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    private int findReportByIdAndCourse(List<Report> list, int id, String course) {
        for (int i = 0; i < list.size(); i++) {
            Report report = list.get(i);
            if (report.getId() == id && report.getCourse().equalsIgnoreCase(course)) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    private int countTotalCourseByStudentId(List<Student> listStudents, int id, String course) {
        int count = 0;
        for (Student student : listStudents) {
            if (student.getId() == id && student.getCourse().equalsIgnoreCase(course)) {
                count++;
            }
        }
        return count;
    }

    public Student getStudentByIndex(int index) {
        if (index < 0) {
            return null;
        }
        if (index < listStudents.size()) { //Nếu mà index có trong list
            return listStudents.get(index);
        }
        return null;
    }

    public int removeStudent(int index) {
        if (index < listStudents.size()) {
            listStudents.remove(index);
            return 1;
        } else {
            return -1;
        }
    }

    private void displayReport(List<Report> listReports) {
        System.out.println("List report: ");
        for (Report R : listReports) {
            System.out.println(R.toString());
        }
        System.out.println();
    }

    public int checkIdExisted(int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            Student s = listStudents.get(i);
            if (s.getId() == id) {
                return i;
            }
        }
        return NOT_EXIST;
    }

    boolean isStudentExisted(int id, String newName, int newSemester, String newCourse) {
        for (Student student : listStudents) {
            if (student.getId() == id && student.getName().equalsIgnoreCase(newName)
                    && student.getSemester() == newSemester && student.getCourse().equalsIgnoreCase(newCourse)) {
                return true;
            }
        }
        return false;
    }

}
