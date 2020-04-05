package jivraj.eric.spring.boot.testdataanalyser.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;

/** This class forms part of the service layer
 * This is the Result Filtering class, and this object is responsible for filtering the differences by a given filter
 */
public class ResultFiltering
{

  public ResultFiltering()
  {

  }

  /** This method is used to filter the differences by intermittent failures
   * An intermittent failure (also known as a flaky test) is a test the fails every now and then under the same exact circumstances
   * This method will try to spot intermittent failures and filter those failures out only retaining the real failures
   * @param differencesList List of extracted differences
   * @param rightBranchJobResultsList List of job results containing all builds of test results for the right branch
   * @return List<Match<TestResults>> which contains the test results post filter
   */
  public List<Match<TestResults>> filterDifferencesByIntermittentFailures(List<Match<TestResults>> differencesList, List<JobResults> rightBranchJobResultsList)
  {
    difference:
    for(Iterator<Match<TestResults>> itDiff = differencesList.iterator(); itDiff.hasNext();)
    {
      TestResults leftTestResult = itDiff.next().getLeft();

      if(!leftTestResult.isPassed())
      {
        for(JobResults rightBranchJobResult : rightBranchJobResultsList)
        {
          Map<String, List<TestResults>> rightBranchTestResultsMap = rightBranchJobResult.getTestResults();
          for(Map.Entry<String, List<TestResults>> rightEntry : rightBranchTestResultsMap.entrySet())
          {
            List<TestResults> rightBranchTestResultsList = rightBranchTestResultsMap.get(rightEntry.getKey());

            for(TestResults rightTestResult : rightBranchTestResultsList)
            {
              if(leftTestResult.getTestName().equals(rightTestResult.getTestName()))
              {
                if(leftTestResult.getStackTrace().equals(rightTestResult.getStackTrace()))
                {
                  itDiff.remove();
                  continue difference;
                }
              }
            }
          }
        }
      }
    }
    return differencesList;
  }
}
