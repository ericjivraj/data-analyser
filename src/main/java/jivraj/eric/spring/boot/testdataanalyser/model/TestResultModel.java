package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.List;

public class TestResultModel
{
  private List<String> testResults;

  private String testClassName;

  private String testName;

  private String testStatus;

  private String stackTrace;

  public List<String> getTestResults()
  {
    return testResults;
  }

  public void setTestResults(List<String> testResults)
  {
    this.testResults = testResults;
  }

  public String getTestClassName()
  {
    return testClassName;
  }

  public void setTestClassName(String testClassName)
  {
    this.testClassName = testClassName;
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
}
