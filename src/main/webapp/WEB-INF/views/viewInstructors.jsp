<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
      crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
      crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>

<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=windows-1256">
    <title>view instructors</title>
</head>
<body>
<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                        aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/myapp">College Management System</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/myapp">Home</a></li>
                    <li><a href="/myapp/viewDepartment">Departments</a></li>
                    <li><a href="/myapp/viewCourses">Courses</a></li>
                    <li class="active"><a href="/myapp/viewInstructors">Instructors</a></li>
                    <li><a href="/myapp/viewStudents">Students</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid --> </nav>
    <div class="well center-block" style="max-width: 400px">
        <a class="btn btn-primary btn-lg btn-block" href="/myapp/addInstructors" role="button">Add
            Instructors</a>
    </div>
</div>
<!-- /container -->


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <h1>All Instructors</h1>

    <table class="table-bordered active">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Salary</th>
            <th>Department Code</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="i" items="${list3}">
            <tr>
                <td>${i.insId}</td>
                <td>${i.insName}</td>
                <td>${i.insAddress}</td>
                <td>${i.insPhone}</td>
                <td>${i.insSalary}</td>
                <td>${i.depId}</td>
                <td><a href="deleteInstructor/${i.insId}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>