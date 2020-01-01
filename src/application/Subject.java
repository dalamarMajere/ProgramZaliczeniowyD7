package application;

import java.util.ArrayList;

public class Subject {

    private ArrayList<Integer> grades;
    private String name;
    private String code;
    private boolean credit;

    //constructors
    public Subject(String name) {
        this(name, "0");
    }

    public Subject() {
        this("Subject", "0");
    }

    public Subject(String name, String code) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.credit = false;
        this.code = code;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    /**
     * Require O(n) time
     * @return student's average grade at the subject
     */
    public double getAverageGrade() {
        double sum = 0.0;
        for (int i: grades)
            sum += i;
        return sum / grades.size();
    }

    public String getGrades() {
        return grades.toString();
    }

    public void setCredit() {
        credit = true;
    }

    public boolean getCredit() {
        return credit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String code() {
        return code;
    }
}
