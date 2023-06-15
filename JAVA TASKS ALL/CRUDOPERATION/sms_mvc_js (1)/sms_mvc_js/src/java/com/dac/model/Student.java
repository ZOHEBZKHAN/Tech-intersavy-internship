package com.dac.model;
public class Student {
    private int studentId;
    private String studentName;
    private String studentEmail;
    private String studentCity;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentEmail, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentCity = studentCity;
    }

    public Student(String studentName, String studentEmail, String studentCity) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentCity = studentCity;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail + ", studentCity=" + studentCity + '}';
    }
    
}
