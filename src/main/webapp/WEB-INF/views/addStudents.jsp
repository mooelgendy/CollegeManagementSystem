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
    <title>add student</title>
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
                    <li><a href="/myapp/viewInstructors">Instructors</a></li>
                    <li class="active"><a href="/myapp/viewStudents">Students</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
</div>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" class="form-group">


    <h1>Add Student</h1>
    <div class="form-group">
        <form:form method="post" action="save4">
            <table class="table-striped" class="table">
                <tr>
                    <td>Student Id :</td>
                    <td><form:input path="studId" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Student Name :</td>
                    <td><form:input path="studName" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Student Address :</td>
                    <td><form:input path="studAddress" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Student Phone :</td>
                    <td><form:input path="studPhone" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Student Code :</td>
                    <td><form:input path="depId" class="form-control"/></td>
                </tr>
                <td><input type="submit" value="Save"
                           class="btn btn-primary btn-lg"/></td>
                </tr>
            </table>
        </form:form>

    </div>
</div>
</body>
</body>
</html>