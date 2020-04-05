package jivraj.eric.spring.boot.testdataanalyser.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

/** This class forms part of the model layer
 * This is the Job Results class, and it is an object that represents the information contained in a job result from Jenkins
 * This class is meant to mirror what the collection JobResults in MongoDB would look like
 */
@Document(collection = "JobResults")
public class JobResults
{
  private String testJob;
  private String buildNo;
  private String buildStatus;
  private String buildRevision;
  private String branch;
  private Map<String, List<TestResults>> testResults;

  /** Default constructor for this object
   * @param testJob Test Job or Test Suite
   * @param buildNo Build Number
   * @param buildStatus Build Status
   * @param buildRevision Build Revision
   * @param branch Branch Name
   * @param testResults List of Test Results
   */
  public JobResults(String testJob, String buildNo, String buildStatus, String buildRevision, String branch, Map<String, List<TestResults>> testResults)
  {
    this.testJob = testJob;
    this.buildNo = buildNo;
    this.buildStatus = buildStatus;
    this.buildRevision = buildRevision;
    this.branch = branch;
    this.testResults = testResults;
  }

  /** Getter method for the test job
   * @return Test Job
   */
  public String getTestJob()
  {
    return testJob;
  }

  /** Setter method for the test job
   * @param testJob Test Job
   */
  public void setTestJob(String testJob)
  {
    this.testJob = testJob;
  }

  /** Getter method for the build number
   * @return Build Number
   */
  public String getBuildNo()
  {
    return buildNo;
  }

  /** Setter method for the build number
   * @param buildNo Build Number
   */
  public void setBuildNo(String buildNo)
  {
    this.buildNo = buildNo;
  }

  /** Getter method for the build status
   * @return Build Status
   */
  public String getBuildStatus()
  {
    return buildStatus;
  }

  /** Setter method for the build status
   * @param buildStatus Build Status
   */
  public void setBuildStatus(String buildStatus)
  {
    this.buildStatus = buildStatus;
  }

  /** Getter method for the build revision
   * @return Build Revision
   */
  public String getBuildRevision()
  {
    return buildRevision;
  }

  /** Setter method for the build revision
   * @param buildRevision Build Revision
   */
  public void setBuildRevision(String buildRevision)
  {
    this.buildRevision = buildRevision;
  }

  /** Getter method for the branch name
   * @return Branch Name
   */
  public String getBranch()
  {
    return branch;
  }

  /** Setter method for the branch name
   * @param branch Branch Name
   */
  public void setBranch(String branch)
  {
    this.branch = branch;
  }

  /** Getter method for the test results
   * @return Test Results
   */
  public Map<String, List<TestResults>> getTestResults()
  {
    return testResults;
  }

  /** Setter method for the test results
   * @param testResults Test Results
   */
  public void setTestResults(Map<String, List<TestResults>> testResults)
  {
    this.testResults = testResults;
  }
}