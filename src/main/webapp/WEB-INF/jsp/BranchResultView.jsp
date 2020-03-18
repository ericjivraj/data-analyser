<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

  <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
  <link rel="stylesheet" type="text/css" href="stylesheet.css">

  <c:url value="/css/main.css" var="jstlCss"/>
  <link href="${jstlCss}" rel="stylesheet"/>

</head>

<body>
<h1>Branch Comparison Result:</h1>
<table>
  <tr>
    <th>Test Job</th>
    <th>Build Number</th>
    <th>Build Status</th>
    <th>Build Revision</th>
    <th>Branch Name</th>
    <th>Class Name</th>
    <th>Test Name</th>
    <th>Test Status</th>
  </tr>
<c:forEach var="jobResult" items="${jobResults}">
<c:forEach var="testClass" items="${jobResult.testResults}">
<c:forEach var="testResult" items="${testClass.value}">
  <tr>
    <td>${jobResult.testJob}</td>
    <td>${jobResult.buildNo}</td>
    <td>${jobResult.buildStatus}</td>
    <td>${jobResult.buildRevision}</td>
    <td>${jobResult.branch}</td>
    <td>${testResult.className}</td>
    <td>${testResult.testName}</td>
    <td>${testResult.testStatus}</td>
  </tr>
</c:forEach>
</c:forEach>
</c:forEach>
</table>
<th><a href="http://localhost:8080/">Go Back to Main Menu</a></th>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
