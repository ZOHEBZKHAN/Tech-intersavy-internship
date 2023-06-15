package com.dac.dao;

import com.dac.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private static final String jdbcDriver = "com.mysql.jdbc.Driver";
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/Studentdemo?useSSL=false";
    private static final String user = "root";
    private static final String password = "Allahis1#";

    private static final String INSERT_STUDENT = "Insert into Student (name,email,city) values(?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "Select * from Student where id=?";
    private static final String SELECT_ALL_STUDENT = "Select * from Student";
    private static final String DELETE_STUDENT = "Delete from Student where id=?";
    private static final String UPDATE_STUDENT = "Update Students set name=?,email=?,city=? where id=?";

    public StudentDao() {
    }

    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(jdbcURL, user, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return con;
    }

    public void insertStudent(Student student) {
        try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(INSERT_STUDENT)) {
            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getStudentEmail());
            pst.setString(3, student.getStudentCity());

            int a = pst.executeUpdate();
            if (a > 0) {
                System.out.println("Record Inserted Successfully");
            } else {
                System.err.println("Something went wrong...");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Student selectStudent(int id) {
        Student stud = null;
        try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(SELECT_STUDENT_BY_ID)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String city = rs.getString("city");
                stud = new Student(id, name, email, city);
            }
        } catch (Exception e) {
            System.err.println("");
        }
        return stud;
    }

    public List<Student> selectAllStudent() {
        List<Student> studlst = new ArrayList<>();;
        try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(SELECT_ALL_STUDENT)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String city = rs.getString("city");
                studlst.add(new Student(id, name, email, city));
               // System.out.println(new Student(id, name, email, city));
            }
        } catch (Exception e) {
            System.err.println("Hello "+e.getMessage());
        }
        return studlst;
    }

    public boolean deleteStudent(int id) {
        boolean flag = false;
        try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(DELETE_STUDENT)) {
            pst.setInt(1, id);
            int a = pst.executeUpdate();
            if (a > 0) {
                System.out.println("Record Deleted Successfully");
                flag = true;
            } else {
                System.err.println("Something went wrong...");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    public boolean updateStudent(Student stud) {
        boolean flag = false;
        try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(UPDATE_STUDENT)) {
            pst.setString(1, stud.getStudentName());
            pst.setString(2, stud.getStudentEmail());
            pst.setString(3, stud.getStudentCity());
            pst.setInt(4, stud.getStudentId());
            int a = pst.executeUpdate();
            if (a > 0) {
                System.out.println("Record Updated Successfully");
                flag = true;
            } else {
                System.err.println("Something went wrong...");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    public List<Student> selectAllStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
