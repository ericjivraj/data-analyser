package jivraj.eric.spring.boot.testdataanalyser.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.MatchResults;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;

public class ResultComparisonTest
{
  private ResultComparison resultComparisonMock;
  private MatchResults matchResultsMock;
  private List<JobResults> leftBranchJobResultsList = new ArrayList<>();
  private List<JobResults> rightBranchJobResultsList = new ArrayList<>();
  private JobResults jobResultsMock;
  private Map<String, List<TestResults>> testResultsMapMock = new HashMap<>();
  private List<TestResults> testResultsListMock = new ArrayList<>();
  private TestResults testMockOne;
  private TestResults testMockTwo;
  private List<Match<TestResults>> differencesList = new ArrayList<>();
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
  public void testMatchResults()
  {
    givenResultComparisonIsSetUp();
    givenJobResultsIsSetUp();
    givenTestResultsIsSetUp(testMockOne, CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    givenTestResultsIsSetUp(testMockTwo, CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    whenJobResultsIsAddedToList(jobResultsMock);
    whenMatchResultsIsCalled();
    thenAssertMatchResults();
  }

  @Test
  public void testExtractDifferences()
  {
    givenResultComparisonIsSetUp();
    givenJobResultsIsSetUp();
    givenTestResultsIsSetUp(testMockOne, CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    givenTestResultsIsSetUp(testMockTwo, CLASS_NAME, TEST_NAME, TEST_STATUS, STACK_TRACE);
    whenJobResultsIsAddedToList(jobResultsMock);
    whenMatchResultsIsCalled();
    whenExtractDifferencesIsCalled();
    thenAssertMatchResults();
    thenAssertDifferencesList();
  }

  private void givenResultComparisonIsSetUp()
  {
    resultComparisonMock = new ResultComparison();
  }

  private void givenJobResultsIsSetUp()
  {
    jobResultsMock = new JobResults(TEST_JOB, BUILD_NO, BUILD_STATUS, BUILD_REVISION, BRANCH, testResultsMapMock);
  }

  private void givenTestResultsIsSetUp(TestResults testResults, String className, String testName, String testStatus, String stackTrace)
  {
    testResults = new TestResults(className, testName, testStatus, stackTrace);
    testResultsListMock.add(testResults);
    testResultsMapMock.put(CLASS_NAME, testResultsListMock);
  }

  private void whenMatchResultsIsCalled()
  {
    matchResultsMock = resultComparisonMock.matchResults(leftBranchJobResultsList, rightBranchJobResultsList);
  }

  private void whenExtractDifferencesIsCalled()
  {
    differencesList = resultComparisonMock.extractDifferences(matchResultsMock);
  }

  private void whenJobResultsIsAddedToList(JobResults jobResults)
  {
    leftBranchJobResultsList.add(jobResults);
    rightBranchJobResultsList.add(jobResults);
  }

  private void thenAssertMatchResults()
  {
    assertNotNull(matchResultsMock);
  }

  private void thenAssertDifferencesList()
  {
    assertNotNull(differencesList);
  }
}
