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

<main class="homepage">

  <div>
    <h1>View Last Build</h1>
    <img src="/images/lastbuild.png">

    <div class="details">

      <p>This feature will allow you to input a branch and then view the latest test build results</p>

      <div class="buttons">
        <form action="selectBranchLastBuild">
          <button type="submit">View Last Build</button>
        </form>
      </div>
    </div>
  </div>

  <div>
    <h1>Compare Branches</h1>
    <img src="/images/comparison.png">

    <div class="details">

      <p>This feature will allow you to input two branches and then compare their test results</p>

      <div class="buttons">
        <form action="/selectBranches">
          <button type="submit">Compare Branches</button>
        </form>
      </div>
    </div>
  </div>

  <div>
    <h1>View All Builds</h1>
    <img src="/images/allbuilds.png">

    <div class="details">

      <p>This feature will allow you to input a branch and then view all the test build results</p>

      <div class="buttons">
        <form action="/selectBranch">
          <button type="submit">View All Builds</button>
        </form>
      </div>
    </div>
  </div>
</main>

<footer>Made by Eric Jivraj in 2020 | Final Year Project | Final Year Computer Science Student at Aston University</footer>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"/>

</body>
</html>
