package jivraj.eric.spring.boot.testdataanalyser.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class JobResultsTest
{
  private JobResults jobResultsMock;
  private Map<String, List<TestResults>> testResultsMapMock = new HashMap<>();
  private List<TestResults> testResultsListMock = new ArrayList<>();
  private TestResults testMock;
  private static final String TEST_JOB = "test-job-1";
  private static final String BUILD_NO = "1";
  private static final String BUILD_STATUS = "UNSTABLE";
  private static final String BUILD_REVISION = "abcdef";
  private static final String BRANCH = "ftr-prod-1";
  private static final String CLASS_NAME = "classA";
  private static final String TEST_NAME = "testA";
  private static final String TEST_STATUS = "FAILED";
  private static final String STACK_TRACE = "nullpointer";

  @Test
  public void testJobResultsExists()
  {
    givenTestResultsIsSetUp(CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    givenJobResultsIsSetUp();
    verifyJobResultsProperties(jobResultsMock.getTestJob(), TEST_JOB);
    verifyJobResultsProperties(jobResultsMock.getBuildNo(), BUILD_NO);
    verifyJobResultsProperties(jobResultsMock.getBuildStatus(), BUILD_STATUS);
    verifyJobResultsProperties(jobResultsMock.getBuildRevision(), BUILD_REVISION);
    verifyJobResultsProperties(jobResultsMock.getBranch(), BRANCH);
    verifyTestResultsPropertiesClassName(0, CLASS_NAME);
    verifyTestResultsPropertiesTestName(0, TEST_NAME);
    verifyTestResultsPropertiesTestStatus(0, TEST_STATUS);
    verifyTestResultsPropertiesStackTrace(0, STACK_TRACE);
  }

  private void givenTestResultsIsSetUp(String className, String testName, String testStatus, String stackTrace)
  {
    testMock = new TestResults(className, testName, testStatus, stackTrace);
    testResultsListMock.add(testMock);
    testResultsMapMock.put(CLASS_NAME, testResultsListMock);
  }

  private void givenJobResultsIsSetUp()
  {
    jobResultsMock = new JobResults(TEST_JOB, BUILD_NO, BUILD_STATUS, BUILD_REVISION, BRANCH, testResultsMapMock);
  }

  private void verifyJobResultsProperties(String expected, String actual)
  {
    assertEquals(expected, actual);
  }

  private void verifyTestResultsPropertiesClassName(int index, String actual)
  {
    List<TestResults> resultsList = jobResultsMock.getTestResults().get(CLASS_NAME);
    assertEquals(resultsList.get(index).getClassName(), actual);
  }

  private void verifyTestResultsPropertiesTestName(int index, String actual)
  {
    List<TestResults> resultsList = jobResultsMock.getTestResults().get(CLASS_NAME);
    assertEquals(resultsList.get(index).getTestName(), actual);
  }

  private void verifyTestResultsPropertiesTestStatus(int index, String actual)
  {
    List<TestResults> resultsList = jobResultsMock.getTestResults().get(CLASS_NAME);
    assertEquals(resultsList.get(index).getTestStatus(), actual);
  }

  private void verifyTestResultsPropertiesStackTrace(int index, String actual)
  {
    List<TestResults> resultsList = jobResultsMock.getTestResults().get(CLASS_NAME);
    assertEquals(resultsList.get(index).getStackTrace(), actual);
  }
}
