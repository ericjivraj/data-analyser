package jivraj.eric.spring.boot.testdataanalyser.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.MatchResults;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;

public class ResultComparison
{

  public ResultComparison()
  {

  }

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

  private Map<String, List<TestResults>> fetchLastTestResultsBuild(List<JobResults> branchResultsList)
  {
    int lastIndex = branchResultsList.size()-1;
    JobResults branchLastBuild = branchResultsList.get(lastIndex);
    return branchLastBuild.getTestResults();
  }
}