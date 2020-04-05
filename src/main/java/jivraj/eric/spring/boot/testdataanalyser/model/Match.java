package jivraj.eric.spring.boot.testdataanalyser.model;

/** This class forms part of the model layer
 * This class is the Match class, and this object represents a match between two branches, by holding the left branch and right branch test results
 * @param <T> Generic that can be of any type, but in this context it is of TestResults
 */
public class Match<T>
{
  private T left;
  private T right;

  /** Default constructor for this object
   * @param left Represents the Test Results on the left
   * @param right Represents the Test Results on the right
   */
  public Match(T left, T right)
  {
    this.left = left;
    this.right = right;
  }

  /** Getter method for the test results on the left branch
   * @return Test Results from the left branch
   */
  public T getLeft()
  {
    return left;
  }

  /** Setter method for the test results on the left branch
   * @param left Test Results from the left branch
   */
  public void setLeft(T left)
  {
    this.left = left;
  }

  /** Getter method for the test results on the right branch
   * @return Test Results from the right branch
   */
  public T getRight()
  {
    return right;
  }

  /** Setter method for the test results on the right branch
   * @param right Test Results from the right branch
   */
  public void setRight(T right)
  {
    this.right = right;
  }
}
