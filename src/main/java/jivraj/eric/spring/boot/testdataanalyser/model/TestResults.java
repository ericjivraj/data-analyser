package jivraj.eric.spring.boot.testdataanalyser.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testResults")
public class TestResults
{
  private String className;
  private String testName;
  private String testStatus;
  private String stackTrace;
  private static final String PASSED = "PASSED";
  private static final String FIXED = "FIXED";

  public TestResults(String className, String testName, String testStatus, String stackTrace)
  {
    this.className = className;
    this.testName = testName;
    this.testStatus = testStatus;
    this.stackTrace = stackTrace;
  }

  public String getClassName()
  {
    return className;
  }

  public void setClassName(String className)
  {
    this.className = className;
  }

  public String getTestName()
  {
    return testName;
  }

  public void setTestName(String testName)
  {
    this.testName = testName;
  }

  public String getTestStatus()
  {
    return testStatus;
  }

  public void setTestStatus(String testStatus)
  {
    this.testStatus = testStatus;
  }

  public String getStackTrace()
  {
    return stackTrace;
  }

  public void setStackTrace(String stackTrace)
  {
    this.stackTrace = stackTrace;
  }

  public boolean isPassed()
  {
    return PASSED.equals(testStatus) || FIXED.equals(testStatus);
  }
}
