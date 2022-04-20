/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManegement;

/**
 *
 * @author Quang
 */
public class Report {

    private int id;
    private String name;
    private String course;
    private int totalCourse;

    public Report() {
    }

    public Report(int id, String name, String course, int totalCourse) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return "| " + name + " | " + course + " | " + totalCourse + " |";
    }
}
