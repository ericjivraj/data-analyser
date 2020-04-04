package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.List;

public class MatchResults
{
  private List<Match<TestResults>> onlyLeftList;
  private List<Match<TestResults>> onlyRightList;
  private List<Match<TestResults>> matchList;

  public MatchResults(List<Match<TestResults>> onlyLeftList, List<Match<TestResults>> onlyRightList, List<Match<TestResults>> matchList)
  {
    this.onlyLeftList = onlyLeftList;
    this.onlyRightList = onlyRightList;
    this.matchList = matchList;
  }

  public List<Match<TestResults>> getOnlyLeftList()
  {
    return onlyLeftList;
  }

  public void setOnlyLeftList(List<Match<TestResults>> onlyLeftList)
  {
    this.onlyLeftList = onlyLeftList;
  }

  public List<Match<TestResults>> getOnlyRightList()
  {
    return onlyRightList;
  }

  public void setOnlyRightList(List<Match<TestResults>> onlyRightList)
  {
    this.onlyRightList = onlyRightList;
  }

  public List<Match<TestResults>> getMatchList()
  {
    return matchList;
  }

  public void setMatchList(List<Match<TestResults>> matchList)
  {
    this.matchList = matchList;
  }
}
