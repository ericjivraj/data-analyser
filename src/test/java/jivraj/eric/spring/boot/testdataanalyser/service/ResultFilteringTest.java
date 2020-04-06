package jivraj.eric.spring.boot.testdataanalyser.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;

public class ResultFilteringTest
{
  private ResultFiltering resultFilteringMock;
  private List<JobResults> rightBranchJobResultsList = new ArrayList<>();
  private List<Match<TestResults>> differencesList = new ArrayList<>();
  private JobResults jobResultsMockOne;
  private JobResults jobResultsMockTwo;
  private JobResults jobResultsMockThree;
  private Map<String, List<TestResults>> testResultsMapMock = new HashMap<>();
  private List<TestResults> testResultsListMock = new ArrayList<>();
  private TestResults testMockOne;
  private Match<TestResults> testMockTwo;
  private Match<TestResults> testMockThree;
  private static final String TEST_JOB = "test-job-1";
  private static final String BUILD_NO = "1";
  private static final String BUILD_STATUS_FAILED = "UNSTABLE";
  private static final String BUILD_REVISION = "abcdef";
  private static final String BRANCH = "ftr-prod-1";
  private static final String CLASS_NAME = "classA";
  private static final String TEST_NAME = "testA";
  private static final String TEST_STATUS_FAILED = "FAILED";
  private static final String STACK_TRACE = "nullpointer";

  @Test
  public void testFilterDifferencesByIntermittentFailures()
  {
    givenResultFiltering();
    givenJobResultsOneIsSetUp(TEST_JOB, BUILD_NO, BUILD_STATUS_FAILED, BUILD_REVISION, BRANCH, testResultsMapMock);
    givenTestResultsMapIsSetUp(testMockOne, CLASS_NAME, TEST_NAME, TEST_STATUS_FAILED, STACK_TRACE);
    givenJobResultsIsAddedToList(jobResultsMockOne);

    givenJobResultsTwoIsSetUp(TEST_JOB, "2", BUILD_STATUS_FAILED, BUILD_REVISION, BRANCH, testResultsMapMock);
    givenTestResultsMapIsSetUp(testMockOne, CLASS_NAME, TEST_NAME, TEST_STATUS_FAILED, STACK_TRACE);
    givenJobResultsIsAddedToList(jobResultsMockTwo);

    givenJobResultsThreeIsSetUp(TEST_JOB, "3", "PASSED", BUILD_REVISION, BRANCH, testResultsMapMock);
    givenTestResultsMapIsSetUp(testMockOne, CLASS_NAME, TEST_NAME, "PASSED", null);
    givenJobResultsIsAddedToList(jobResultsMockThree);

    givenTestResultIsSetUp(CLASS_NAME, TEST_NAME, TEST_STATUS_FAILED, STACK_TRACE);
    givenDifferencesListIsSetUp(testMockTwo);
    givenDifferencesListIsSetUp(testMockThree);

    whenFilterDifferencesByIntermittentFailuresIsCalled(differencesList, rightBranchJobResultsList);
    thenAssertDifferencesList();
  }

  private void givenResultFiltering()
  {
    resultFilteringMock = new ResultFiltering();
  }

  private void givenJobResultsOneIsSetUp(String testJob, String buildNo, String buildStatus, String buildRevision, String branch, Map<String, List<TestResults>> testResultsMap)
  {
    jobResultsMockOne = new JobResults(testJob, buildNo, buildStatus, buildRevision, branch, testResultsMap);
  }

  private void givenJobResultsTwoIsSetUp(String testJob, String buildNo, String buildStatus, String buildRevision, String branch, Map<String, List<TestResults>> testResultsMap)
  {
    jobResultsMockTwo = new JobResults(testJob, buildNo, buildStatus, buildRevision, branch, testResultsMap);
  }

  private void givenJobResultsThreeIsSetUp(String testJob, String buildNo, String buildStatus, String buildRevision, String branch, Map<String, List<TestResults>> testResultsMap)
  {
    jobResultsMockThree = new JobResults(testJob, buildNo, buildStatus, buildRevision, branch, testResultsMap);
  }

  private void givenTestResultsMapIsSetUp(TestResults testResults, String className, String testName, String testStatus, String stackTrace)
  {
    testResults = new TestResults(className, testName, testStatus, stackTrace);
    testResultsListMock.add(testResults);
    testResultsMapMock.put(CLASS_NAME, testResultsListMock);
  }

  private void givenJobResultsIsAddedToList(JobResults jobResults)
  {
    rightBranchJobResultsList.add(jobResults);
  }

  private void givenTestResultIsSetUp(String className, String testName, String testStatus, String stackTrace)
  {
    TestResults left = new TestResults(className, testName, testStatus, stackTrace);
    TestResults right = new TestResults(CLASS_NAME, TEST_NAME, TEST_STATUS_FAILED, STACK_TRACE);
    testMockTwo = new Match<>(left, right);
    testMockThree = new Match<>(left, right);
  }

  private void givenDifferencesListIsSetUp(Match<TestResults> testResultsMock)
  {
    differencesList.add(testResultsMock);
  }

  private void whenFilterDifferencesByIntermittentFailuresIsCalled(List<Match<TestResults>> differencesList, List<JobResults> rightBranchJobResultsList)
  {
    resultFilteringMock.filterDifferencesByIntermittentFailures(differencesList, rightBranchJobResultsList);
  }

  private void thenAssertDifferencesList()
  {
    assertNotNull(differencesList);
  }
}
