package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class JobResultModel
{
  @Column(nullable = false)
  private String testJob;

  @Column(nullable = false)
  private String buildNumber;

  @Column(nullable = false)
  private String buildStatus;

  @Column(nullable = false)
  private String buildRevision;

  @Column(nullable = false)
  private String branchName;

  @Column(nullable = false)
  private List<String> testResults;

  public String getTestJob()
  {
    return testJob;
  }

  public void setTestJob(String testJob)
  {
    this.testJob = testJob;
  }

  public String getBuildNumber()
  {
    return buildNumber;
  }

  public void setBuildNumber(String buildNumber)
  {
    this.buildNumber = buildNumber;
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

  public String getBranchName()
  {
    return branchName;
  }

  public void setBranchName(String branchName)
  {
    this.branchName = branchName;
  }

  public List<String> getTestResults()
  {
    return testResults;
  }
}
