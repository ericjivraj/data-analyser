package jivraj.eric.spring.boot.testdataanalyser.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MatchResultsTest
{
  private MatchResults matchResults;
  private List<Match<TestResults>> matchesListMock = new ArrayList<>();
  private List<Match<TestResults>> onlyLeftMatchesMock = new ArrayList<>();
  private List<Match<TestResults>> onlyRightMatchesMock = new ArrayList<>();

  @Test
  public void testMatchResultsExists()
  {
    givenMatchResultsIsSetUp(matchesListMock, onlyLeftMatchesMock, onlyRightMatchesMock);
    verifyMatchesList(matchesListMock);
    verifyLeftMatchesList(onlyLeftMatchesMock);
    verifyRightMatchesList(onlyRightMatchesMock);
  }

  private void givenMatchResultsIsSetUp(List<Match<TestResults>> leftMatchesList, List<Match<TestResults>> rightMatchesList, List<Match<TestResults>> matchesList)
  {
    matchResults = new MatchResults(leftMatchesList, rightMatchesList, matchesList);
  }

  private void verifyMatchesList(List<Match<TestResults>> matchesList)
  {
    assertEquals(matchResults.getMatchList(), matchesList);
  }

  private void verifyLeftMatchesList(List<Match<TestResults>> leftMatchesList)
  {
    assertEquals(matchResults.getOnlyLeftList(), leftMatchesList);
  }

  private void verifyRightMatchesList(List<Match<TestResults>> rightMatchesList)
  {
    assertEquals(matchResults.getOnlyRightList(), rightMatchesList);
  }
}
