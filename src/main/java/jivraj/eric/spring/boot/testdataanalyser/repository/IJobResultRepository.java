package jivraj.eric.spring.boot.testdataanalyser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import jivraj.eric.spring.boot.testdataanalyser.model.Results;

public interface IJobResultRepository extends MongoRepository<Results, String>
{
  Results findAllByBuildNoIs(String buildNo);

  Results findByBuildNoIs(String buildNo);

  Results findAllByBuildNo(String buildNo);
}
