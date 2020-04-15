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
        <h1>Branch Comparison Result - The Tests below need Fixing</h1>
        <p>The table below is displaying the tests that need fixing. The comparison performed between the two branches was done
        filtering the tests that are failing on the left branch and understanding if they have failed on the right branch before for the same reason,
        if they have, that means they are intermittent failures/flaky tests, if not then that means they are real failures that need fixing</p>
        <br>
        <h3>Branch Name: ${jobResult.branch}</h3>
        <table>
          <tr>
            <th>Test Job</th>
            <th>Build Number</th>
            <th>Class Name</th>
            <th>Test Name</th>
            <th>Test Status</th>
          </tr>
          <c:forEach var="testResult" items="${filteredResults}">
            <tr>
              <td>${jobResult.testJob}</td>
              <td>${jobResult.buildNo}</td>
              <td>${testResult.className}</td>
              <td>${testResult.testName}</td>
              <td>${testResult.testStatus}</td>
            </tr>
          </c:forEach>
        </table>
        <div class="buttons">
          <form action="/selectBranches">
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
