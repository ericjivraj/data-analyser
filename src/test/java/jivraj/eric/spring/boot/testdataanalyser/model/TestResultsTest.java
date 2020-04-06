package jivraj.eric.spring.boot.testdataanalyser.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestResultsTest
{
  private TestResults testResultsMock;
  private static final String CLASS_NAME = "classA";
  private static final String TEST_NAME = "testA";
  private static final String TEST_STATUS_FAILED = "FAILED";
  private static final String TEST_STATUS_PASSED = "PASSED";
  private static final String STACK_TRACE = "nullpointer";

  @Test
  public void testTestResultsExistsAndPassed()
  {
    givenTestResultsIsSetUp(CLASS_NAME, TEST_NAME, TEST_STATUS_PASSED, null);
    verifyTestResultsClassName(CLASS_NAME);
    verifyTestResultsTestName(TEST_NAME);
    verifyTestResultsTestStatus(TEST_STATUS_PASSED);
    verifyTestResultsStackTrace(null);
    assertTestStatusPassed(TEST_STATUS_PASSED);
  }

  @Test
  public void testTestResultsExistsAndFailed()
  {
    givenTestResultsIsSetUp(CLASS_NAME, TEST_NAME, TEST_STATUS_FAILED, STACK_TRACE);
    verifyTestResultsClassName(CLASS_NAME);
    verifyTestResultsTestName(TEST_NAME);
    verifyTestResultsTestStatus(TEST_STATUS_FAILED);
    verifyTestResultsStackTrace(STACK_TRACE);
    assertTestStatusFailed(TEST_STATUS_FAILED);
  }

  private void givenTestResultsIsSetUp(String className, String testName, String testStatus, String stackTrace)
  {
    testResultsMock = new TestResults(className, testName, testStatus, stackTrace);
  }

  private void verifyTestResultsClassName(String actual)
  {
    assertEquals(testResultsMock.getClassName(), actual);
  }

  private void verifyTestResultsTestName(String actual)
  {
    assertEquals(testResultsMock.getTestName(), actual);
  }

  private void verifyTestResultsTestStatus(String actual)
  {
    assertEquals(testResultsMock.getTestStatus(), actual);
  }

  private void verifyTestResultsStackTrace(String actual)
  {
    assertEquals(testResultsMock.getStackTrace(), actual);
  }

  private void assertTestStatusPassed(String testStatus)
  {
    assertTrue(testResultsMock.isPassed(), testStatus);
  }

  private void assertTestStatusFailed(String testStatus)
  {
    assertFalse(testResultsMock.isPassed(), testStatus);
  }
}
