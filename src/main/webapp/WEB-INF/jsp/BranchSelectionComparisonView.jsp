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
        <h1>Compare Test Results between Branches</h1>
        <p>Branch fields are compulsory, test job fields are optional. If you enter the test jobs, then it will only perform the comparison between
        those jobs between the given branches. <br>
          <b>If you do not specify the jobs, it will perform the comparison for all jobs between the given branches</b></p>
        <img src="/images/comparison.png">
        <div class="buttons">
          <form action="/compareBranches" method="GET">
            <b>Left Branch</b>
            <input type="text" name="leftBranch" id="leftBranch" placeholder="E.g: feature branch" required/>
            <b>Left Test Job</b>
            <input type="text" name="leftJob" id="leftJob" placeholder="E.g: test job"/>
            <b>Right Branch</b>
            <input type="text" name="rightBranch" id="rightBranch" placeholder="E.g: master branch" required/>
            <b>Right Test Job</b>
            <input type="text" name="rightJob" id="rightJob" placeholder="E.g: test job"/>
            <br>
            <button type="submit" name="compareBranch" id="compareBranch">Compare Branches</button>
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
