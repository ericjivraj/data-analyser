package jivraj.eric.spring.boot.testdataanalyser.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;

public class ResultFiltering
{

  public ResultFiltering()
  {

  }

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
