package com.dac.controller;

import com.dac.dao.StudentDao;
import com.dac.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SmsController", urlPatterns = {"/"})
public class SmsController extends HttpServlet {

    private StudentDao studDao;

    public void init() {
        studDao = new StudentDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SmsController</title>");
            out.println("</head>");
            out.println("<body>");
            //request.getContextPath();//Provide context Name
            String action = request.getServletPath();//"url after context path"
            //System.out.println(action);
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                default:
                    allStudentInfo(request, response);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("newStudent.jsp");
        rd.forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String city=request.getParameter("city");
        
        Student student=new Student(name, email, city);
        studDao.insertStudent(student);
        allStudentInfo(request, response);
        
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        studDao.deleteStudent(id);
        allStudentInfo(request, response);
        
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String city=request.getParameter("city");
        
        Student student=new Student(id, name, email, city);
        boolean flag=studDao.updateStudent(student);
        if(flag)
            allStudentInfo(request, response);
        
        
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int id=Integer.parseInt(request.getParameter("id"));
          Student student=studDao.selectStudent(id);
          request.setAttribute("student", student);
        RequestDispatcher rd=request.getRequestDispatcher("newStudent.jsp");
        rd.forward(request, response);
    }

    private void allStudentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> allstud=studDao.selectAllStudents();
       // System.out.println(allstud);
        request.setAttribute("listStudent", allstud);
        RequestDispatcher rd=request.getRequestDispatcher("showStudents.jsp");
        rd.forward(request, response);
    }

}
