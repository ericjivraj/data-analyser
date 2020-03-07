package jivraj.eric.spring.boot.testdataanalyser.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;

public interface IJobResultRepository extends MongoRepository<JobResults, String>
{
  List<JobResults> findAllByBranch(String branch);
}
