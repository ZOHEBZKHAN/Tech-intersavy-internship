<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <title>CDAC Student Management App</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">
                <div>
                    <a href="#" class="navbar-brand"> CDAC Student Management App </a>
                </div>

                <ul class="navbar-nav ml-auto">
                    <li><a href="<%= request.getContextPath()%>/list"
                           class="nav-link">Student Home</a></li>
                    <li><a href="<%= request.getContextPath()%>/logout"
                           class="nav-link">Logout</a></li>
                </ul>
            </nav>
        </header>
        <br>

        <div class="row">m
            <div class="container">
                <h3 class="text-center">Student List</h3>
                <hr>
                <div class="bg-secondary text-right">

                    <a href="<%= request.getContextPath()%>/new" class="btn btn-outline-warning">Add New Student</a>
                </div>
                <br>
        <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>City</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${listStudent}">
                            <tr>
                                <td>${student.studentId}</td>
                                <td>${student.studentName}</td>
                                <td>${student.studentEmail}</td>
                                <td>${student.studentCity}</td>
                                <td>
                                    <a href="edit?id=${student.studentId}"><button class="btn btn-outline-warning">Edit</button></a>
                                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                    <a href="delete?id=${student.studentId}"><button class="btn btn-outline-danger">Delete</button></a>
                                </td>
                            </tr>     
                        </c:forEach>
                    </tbody>
                </table>
       
    </body>
</html>
