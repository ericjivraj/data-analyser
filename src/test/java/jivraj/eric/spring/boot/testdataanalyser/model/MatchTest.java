package jivraj.eric.spring.boot.testdataanalyser.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MatchTest
{
  private Match<TestResults> match;
  private TestResults leftTests;
  private TestResults rightTests;
  private static final String CLASS_NAME = "classA";
  private static final String TEST_NAME = "testA";
  private static final String TEST_STATUS = "FAILED";
  private static final String STACK_TRACE = "nullpointer";

  @Test
  public void testMatchExists()
  {
    givenLeftTestResultsIsSetUp(CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    givenRightTestResultsIsSetUp(CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    givenMatchIsSetUp(leftTests, rightTests);
    verifyTestResultsClassName(match.getLeft(), CLASS_NAME);
    verifyTestResultsTestName(match.getLeft(), TEST_NAME);
    verifyTestResultsTestStatus(match.getLeft(), TEST_STATUS);
    verifyTestResultsStackTrace(match.getLeft(), STACK_TRACE);
    verifyTestResultsClassName(match.getRight(), CLASS_NAME);
    verifyTestResultsTestName(match.getRight(), TEST_NAME);
    verifyTestResultsTestStatus(match.getRight(), TEST_STATUS);
    verifyTestResultsStackTrace(match.getRight(), STACK_TRACE);
  }

  private void givenLeftTestResultsIsSetUp(String className, String testName, String testStatus, String stackTrace)
  {
    leftTests = new TestResults(className, testName, testStatus, stackTrace);
  }

  private void givenRightTestResultsIsSetUp(String className, String testName, String testStatus, String stackTrace)
  {
    rightTests = new TestResults(className, testName, testStatus, stackTrace);
  }

  private void givenMatchIsSetUp(TestResults leftTests, TestResults rightTests)
  {
    match = new Match<>(leftTests, rightTests);
  }

  private void verifyTestResultsClassName(TestResults testResults, String actual)
  {
    assertEquals(testResults.getClassName(), actual);
  }

  private void verifyTestResultsTestName(TestResults testResults, String actual)
  {
    assertEquals(testResults.getTestName(), actual);
  }

  private void verifyTestResultsTestStatus(TestResults testResults, String actual)
  {
    assertEquals(testResults.getTestStatus(), actual);
  }

  private void verifyTestResultsStackTrace(TestResults testResults, String actual)
  {
    assertEquals(testResults.getStackTrace(), actual);
  }
}
