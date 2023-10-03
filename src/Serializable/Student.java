package Serializable;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public int course;
    transient public double average_mark;

    public Student(String name, int course, double average_mark) {
        this.name = name;
        this.course = course;
        this.average_mark = average_mark;
    }

    public Student(Object readObject) {
    }

    public String getName() {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
