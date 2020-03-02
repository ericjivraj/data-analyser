package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Results")
public class Results
{
  private String testJob;

  @Id
  private String buildNo;

  private String buildStatus;

  private String buildRevision;

  private String branch;

  private ArrayList<String> testResults;

  private String className;

  private String testName;

  private String testStatus;

  private String stackTrace;

  public Results(String testJob, String buildNo, String buildRevision, String branch, ArrayList<String> testResults, String className, String testName, String testStatus, String stackTrace)
  {
    this.testJob = testJob;
    this.buildNo = buildNo;
    this.buildRevision = buildRevision;
    this.branch = branch;
    this.testResults = testResults;
    this.className = className;
    this.testName = testName;
    this.testStatus = testStatus;
    this.stackTrace = stackTrace;
  }

  public String getTestJob()
  {
    return testJob;
  }

  public void setTestJob(String testJob)
  {
    this.testJob = testJob;
  }

  public String getBuildNo()
  {
    return buildNo;
  }

  public void setBuildNo(String buildNo)
  {
    this.buildNo = buildNo;
  }

  public String getBuildStatus()
  {
    return buildStatus;
  }

  public void setBuildStatus(String buildStatus)
  {
    this.buildStatus = buildStatus;
  }

  public String getBuildRevision()
  {
    return buildRevision;
  }

  public void setBuildRevision(String buildRevision)
  {
    this.buildRevision = buildRevision;
  }

  public String getBranch()
  {
    return branch;
  }

  public void setBranch(String branch)
  {
    this.branch = branch;
  }

  public ArrayList<String> getTestResults()
  {
    return testResults;
  }

  public void setTestResults(ArrayList<String> testResults)
  {
    this.testResults = testResults;
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
}