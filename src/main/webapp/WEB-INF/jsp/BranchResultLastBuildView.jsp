<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Data Analyser Tool</title>

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
<header>
  <h1>Data Analyser Tool</h1>
  <p>This tool will help you view and compare test builds between branches accurately</p>
</header>

<main class="branch">
  <div>
    <div>
      <div align="center">
        <h1>Branch Result - Last Build</h1>
        <h3>Branch Name: ${jobResults.branch}</h3>
        <table>
          <tr>
            <th>Test Job</th>
            <th>Build Number</th>
            <th>Class Name</th>
            <th>Test Name</th>
            <th>Test Status</th>
          </tr>
          <c:forEach var="testClass" items="${jobResults.testResults}">
            <c:forEach var="testResult" items="${testClass.value}">
              <tr>
                <td>${jobResults.testJob}</td>
                <td>${jobResults.buildNo}</td>
                <td>${testResult.className}</td>
                <td>${testResult.testName}</td>
                <td>${testResult.testStatus}</td>
              </tr>
            </c:forEach>
          </c:forEach>
        </table>
        <div class="buttons">
          <form action="/selectBranchLastBuild">
            <button type="submit">Select Another Branch</button>
          </form>
          <form action="/">
            <button type="submit">Go Back to Main Menu</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  </div>
</main>

<footer>Made by Eric Jivraj in 2020 | Final Year Project | Final Year Computer Science Student at Aston University</footer>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
