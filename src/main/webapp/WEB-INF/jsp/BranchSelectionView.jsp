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


<h1>Branch Comparison</h1>

<b>First Branch</b>
<input type="text" name="firstBranch" id="firstBranch"/>

<b>Second Branch</b>
<input type="text" name="secondBranch" id="secondBranch"/>

<input type="submit" name="compareBranch" id="compareBranch"/>
<h1>${name}</h1>
<h1>${results}</h1>

<table>
  <tr>
    <th>Test Job</th>
    <th>Build Number</th>
    <th>Build Status</th>
    <th>Build Revision</th>
    <th>Branch Name</th>
    <th>Test Results</th>
  </tr>
  <tr>
    <td>${testJob}</td>
    <td>${buildNo}</td>
    <td>${buildStatus}</td>
    <td>${buildRevision}</td>
    <td>${branch}</td>
    <td>${testResults}</td>
  </tr>
</table>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
