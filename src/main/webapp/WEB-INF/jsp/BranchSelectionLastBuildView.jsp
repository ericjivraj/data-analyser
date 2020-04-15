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
        <h1>View Last Build in a Branch</h1>
        <p>Branch fields are compulsory, test job fields are optional. If you enter a test job, then it will only display all the results for that
        given branch and job. <br>
        If you do not specify the job, it will display all the results for all jobs within that branch</p>
        <img src="/images/lastbuild.png">
        <div class="buttons">
        <form action="/viewLastBuildInBranch" method="GET">
          <b>Branch Name</b>
          <input type="text" name="leftBranch" id="leftBranch" placeholder="E.g: feature branch" required/>
          <b>Test Job</b>
          <input type="text" name="testJob" id="testJob" placeholder="E.g: test job"/>
          <button type="submit" name="compareBranch" id="compareBranch">View Last Build</button>
        </form>
        </div>
        <br>
        <div class="buttons">
          <form action="/">
            <button type="submit">Go Back to Main Menu</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</main>

<footer>Made by Eric Jivraj in 2020 | Final Year Project | Final Year Computer Science Student at Aston University</footer>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
