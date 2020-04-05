package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.List;

/** This class forms part of the model layer
 * This is the Match Results class, this object holds 3 particular lists of matches
 * One list for matches of test results that exist in both branches
 * Another list for test results that only exist on the left branch but not on the right branch
 * Another list for test results that only exist on the right branch but not on the left branch
 */
public class MatchResults
{
  private List<Match<TestResults>> onlyLeftList;
  private List<Match<TestResults>> onlyRightList;
  private List<Match<TestResults>> matchList;

  /** Default constructor for this object
   * @param onlyLeftList List of test result matches only found on the left branch
   * @param onlyRightList List of test result matches only found on the right branch
   * @param matchList List of test result matches found on both branches
   */
  public MatchResults(List<Match<TestResults>> onlyLeftList, List<Match<TestResults>> onlyRightList, List<Match<TestResults>> matchList)
  {
    this.onlyLeftList = onlyLeftList;
    this.onlyRightList = onlyRightList;
    this.matchList = matchList;
  }

  /** Getter method for the list of test result matches only found on the left branch
   * @return List of test result matches only found on the left branch
   */
  public List<Match<TestResults>> getOnlyLeftList()
  {
    return onlyLeftList;
  }

  /** Setter method for the list of test result matches only found on the left branch
   * @param onlyLeftList List of test result matches only found on the left branch
   */
  public void setOnlyLeftList(List<Match<TestResults>> onlyLeftList)
  {
    this.onlyLeftList = onlyLeftList;
  }

  /** Getter method for the list of test result matches only found on the right branch
   * @return List of test results matches only found on the right branch
   */
  public List<Match<TestResults>> getOnlyRightList()
  {
    return onlyRightList;
  }

  /** Setter method for the list of test result matches only found on the right branch
   * @param onlyRightList List of test results matches only found on the right branch
   */
  public void setOnlyRightList(List<Match<TestResults>> onlyRightList)
  {
    this.onlyRightList = onlyRightList;
  }

  /** Getter method for the list of test result matches found on both branches
   * @return List of test result matches found on both branches
   */
  public List<Match<TestResults>> getMatchList()
  {
    return matchList;
  }

  /** Setter method for the list of test result matches found on both branches
   * @param matchList List of test result matches found on both branches
   */
  public void setMatchList(List<Match<TestResults>> matchList)
  {
    this.matchList = matchList;
  }
}
