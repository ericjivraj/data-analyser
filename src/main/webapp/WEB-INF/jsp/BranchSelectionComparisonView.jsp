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
<h1>View All Builds in a Branch:</h1>
<form action="/compareBranches" method="GET">
<b>First Branch</b>
<input type="text" name="leftBranch" id="leftBranch"/>
<b>Second Branch</b>
<input type="text" name="rightBranch" id="rightBranch"/>
<input type="submit" name="compareBranch" id="compareBranch"/>
</form>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
