package jivraj.eric.spring.boot.testdataanalyser.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;

/** This class forms part of the repository layer
 * Interface class that serves as a DAO (Data Access Object)
 * This class allows the communication between the application and the database
 */
public interface IJobResultRepository extends MongoRepository<JobResults, String>
{
  /** This method is used to query the database to find all the job results for a given branch
   * @param branch branch name
   * @return List<JobResults> belonging to the given branch
   */
  List<JobResults> findAllByBranch(String branch);

  /** This method is used to query the database to find all the job results for a given branch and test job
   * @param branch branch name
   * @param testJob test job
   * @return List<JobResults> belonging to the given branch and test job
   */
  List<JobResults> findAllByBranchAndTestJob(String branch, String testJob);
}
