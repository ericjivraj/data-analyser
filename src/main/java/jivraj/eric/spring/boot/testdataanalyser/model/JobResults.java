package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobResults")
public class JobResults
{
  private String testJob;
  private String buildNo;
  private String buildStatus;
  private String buildRevision;
  private String branch;
  private Map<String, List<TestResults>> testResults;

  public JobResults(String testJob, String buildNo, String buildRevision, String branch, Map<String, List<TestResults>> testResults)
  {
    this.testJob = testJob;
    this.buildNo = buildNo;
    this.buildRevision = buildRevision;
    this.branch = branch;
    this.testResults = testResults;
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

  public Map<String, List<TestResults>> getTestResults()
  {
    return testResults;
  }

  public void setTestResults(Map<String, List<TestResults>> testResults)
  {
    this.testResults = testResults;
  }
}