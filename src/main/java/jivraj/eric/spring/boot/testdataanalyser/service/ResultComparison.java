package jivraj.eric.spring.boot.testdataanalyser.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.MatchResults;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;

/** This class forms part of the service layer
 * This is the Result Comparison class, and this object is responsible for comparing the test results
 * It runs the comparison algorithm in two stages, firstly it matches test results, then it extracts the differences
 */
public class ResultComparison
{

  /**
   * Default constructor for this object
   */
  public ResultComparison()
  {

  }

  /** This method is used to match the results from both branches
   * It looks at both branches and extracts the test classes that both branches have in common into a matches list
   * It also extracts any test classes that are found on the left branch that do not exist on the right branch into a no matches left list
   * It also extracts any test classes that are found on the right branch that do not exist on the left branch into a no matches right list
   * @param leftBranchJobResultsList List of job results containing test results for the left branch
   * @param rightBranchJobResultsList List of job results containing test results for the right branch
   * @return MatchResults object which contains the 3 match lists: matches on both branches, only on the left branch, and only on the right branch
   */
  public MatchResults matchResults(List<JobResults> leftBranchJobResultsList, List<JobResults> rightBranchJobResultsList)
  {
    Map<String, List<TestResults>> leftBranchTestResultsMap = fetchLastTestResultsBuild(leftBranchJobResultsList);
    Map<String, List<TestResults>> rightBranchTestResultsMap = fetchLastTestResultsBuild(rightBranchJobResultsList);

    List<Match<TestResults>> matchesList = new ArrayList<>();
    List<Match<TestResults>> noMatchesLeft = new ArrayList<>();

    // First loop over the test classes on the left
    // If same test class on the left exists on the right, then compare,
    // If not, we know all the tests cases here on the left will have no match on the right
    for(Map.Entry<String, List<TestResults>> leftEntry : leftBranchTestResultsMap.entrySet())
    {
      List<TestResults> rightBranchTestResultsList = rightBranchTestResultsMap.get(leftEntry.getKey());

      if(rightBranchTestResultsList == null)
      {
        for(List<TestResults> leftResultsList : leftBranchTestResultsMap.values())
        {
          for(TestResults leftTestResult : leftResultsList)
          {
            Match match = new Match(leftTestResult, null); // Covers class tests
            noMatchesLeft.add(match);
          }
        }
      }
      // If we have match for a class on the left for the right, then we compare
      // Try find the same test case matches in the left, on the right
      else
      {
        for(List<TestResults> leftResultList : leftBranchTestResultsMap.values())
        {
          leftResults:
          for(TestResults leftTestResult : leftResultList)
          {
              for(Iterator<TestResults> itResults = rightBranchTestResultsList.iterator(); itResults.hasNext();)
              {
                TestResults rightTestResult = itResults.next();
                if(leftTestResult.getTestName().equals(rightTestResult.getTestName()))
                {
                  Match match = new Match(leftTestResult, rightTestResult);
                  matchesList.add(match);
                  itResults.remove();
                  continue leftResults;
                }
              }
              Match match = new Match(leftTestResult, null); // Covers tests methods
              noMatchesLeft.add(match);
          }
        }
      }
    }

    List<Match<TestResults>> noMatchesRight = new ArrayList<>();
    for(List<TestResults> rightResultsList : rightBranchTestResultsMap.values())
    {
      for(TestResults rightTestResult : rightResultsList)
      {
        Match match = new Match(null, rightTestResult);
        noMatchesRight.add(match);
      }
    }

    return new MatchResults(noMatchesLeft, noMatchesRight, matchesList);
  }

  /** This method is used to extract the differences from the matches list inside the MatchResults object
   * @param matchResults object containing 3 matches lists: matches on both branches, only on the left branch, and only on the right branch
   * @return List<Match<TestResults>> which contains the extracted differences
   */
  public List<Match<TestResults>> extractDifferences(MatchResults matchResults)
  {
    List<Match<TestResults>> matchList = matchResults.getMatchList();
    List<Match<TestResults>> differencesList = new ArrayList<>();

    for(Match<TestResults> match : matchList)
    {
      TestResults leftTestResult = match.getLeft();
      TestResults rightTestResult = match.getRight();

      if(leftTestResult.getTestName().equals(rightTestResult.getTestName()))
      {
        if(leftTestResult.isPassed() != rightTestResult.isPassed())
        {
          differencesList.add(match);
        }
      }
    }

    return differencesList;
  }

  /** This method is used to fetch the last build of test results within a branch
   * @param branchResultsList List of job results from a given branch
   * @return Map<String, List<TestResults>> object which represents the last build of tests results in a branch
   */
  private Map<String, List<TestResults>> fetchLastTestResultsBuild(List<JobResults> branchResultsList)
  {
    int lastIndex = branchResultsList.size()-1;
    JobResults branchLastBuild = branchResultsList.get(lastIndex);
    return branchLastBuild.getTestResults();
  }
}