package jivraj.eric.spring.boot.testdataanalyser.model;

import org.springframework.data.mongodb.core.mapping.Document;

/** This class forms part of the model layer
 * This is the Test Results class, and it is an object that represents the information contained in a test result from Jenkins
 * As per Jenkins, it has Job Results, and each job result has a series of Test Results, containing test related information
 * This class is meant to mirror what the nested object testResults in the collection JobResults in MongoDB would look like
 */
@Document(collection = "testResults")
public class TestResults
{
  private String className;
  private String testName;
  private String testStatus;
  private String stackTrace;
  private static final String PASSED = "PASSED";
  private static final String FIXED = "FIXED";

  /** Default constructor for this object
   * @param className Test Class Name
   * @param testName Test Method Name
   * @param testStatus Test Status
   * @param stackTrace Stack Trace Exception
   */
  public TestResults(String className, String testName, String testStatus, String stackTrace)
  {
    this.className = className;
    this.testName = testName;
    this.testStatus = testStatus;
    this.stackTrace = stackTrace;
  }

  /** Getter method for the test class name
   * @return Test Class Name
   */
  public String getClassName()
  {
    return className;
  }

  /** Setter method for the test class name
   * @param className Test Class Name
   */
  public void setClassName(String className)
  {
    this.className = className;
  }

  /** Getter method for the test method name
   * @return Test Method Name
   */
  public String getTestName()
  {
    return testName;
  }

  /** Setter method for the test method name
   * @param testName Test Method Name
   */
  public void setTestName(String testName)
  {
    this.testName = testName;
  }

  /** Getter method for the test status
   * @return Test Status
   */
  public String getTestStatus()
  {
    return testStatus;
  }

  /** Setter method for the test status
   * @param testStatus Test Status
   */
  public void setTestStatus(String testStatus)
  {
    this.testStatus = testStatus;
  }

  /** Getter method for the stack trace exception
   * @return Stack Trace Exception
   */
  public String getStackTrace()
  {
    return stackTrace;
  }

  /** Setter method for the stack trace exception
   * @param stackTrace Stack Trace Exception
   */
  public void setStackTrace(String stackTrace)
  {
    this.stackTrace = stackTrace;
  }

  /** Method that determines if a test has passed
   * @return true if a test status is either PASSED or FIXED, otherwise return false
   */
  public boolean isPassed()
  {
    return PASSED.equals(testStatus) || FIXED.equals(testStatus);
  }
}
