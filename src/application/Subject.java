package application;

import java.util.ArrayList;

public class Subject {

    private ArrayList<Integer> grades;
    private String name;
    private String id;
    private boolean credit;

    public Subject (String... inf) {
    	this(inf[0], inf[1]);
    }
    
    public Subject (String id, String name) {
    	this.name = name;
    	this.id = id;
    }
    
    @Override
    public String toString() {
    	return id + ";" + name + ";";
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

    public String getName() {
        return name;
    }
}
