package com.sumair.gradetracker;

public class SubjectRow {
    private String subjectName;
    private double marks;
    private double outOf;
    private String grade;
    private double gp;
    private double creditHours;

    SubjectRow(String subjectName,double marks,double outOf,String grade,double gp,double creditHours){
        this.subjectName=subjectName;
        this.marks=marks;
        this.outOf=outOf;
        this.grade=grade;
        this.gp=gp;
        this.creditHours=creditHours;
    }
    public String getSubjectName() { return subjectName; }
    public double getMarks() { return marks; }
    public double getOutOf() { return outOf; }
    public String getGrade() { return grade; }
    public double getGp() { return gp; }
    public double getCreditHours() { return creditHours; }

}

