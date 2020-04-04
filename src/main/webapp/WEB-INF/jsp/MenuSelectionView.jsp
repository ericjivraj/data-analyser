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
<h1>Test Data Analyser Tool:</h1>
<table cellborder="3">
  <tr>
    <th>| <a href="http://localhost:8080/selectBranchLastBuild">View Last Build in a Branch</a></th>
    <th>[ <a href="http://localhost:8080/selectBranch">View All Builds in a Branch</a> |</th>
    <th>| <a href="http://localhost:8080/selectBranches">Compare Results between Branches</a> ]</th>
  </tr>

</table>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
