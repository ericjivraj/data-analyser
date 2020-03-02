package jivraj.eric.spring.boot.testdataanalyser.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import jivraj.eric.spring.boot.testdataanalyser.model.Results;
import jivraj.eric.spring.boot.testdataanalyser.repository.IJobResultRepository;

@Controller
public class DataAnalyserController
{
  @Autowired
  private IJobResultRepository repository;

  private MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

  private String databaseName = "test";

  private MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, databaseName);

  @RequestMapping("/")
  public String branchSelectionView(Model model)
  {
    //Get stuff from Mongo (dao), maybe map to a display model
    //Pass the 'stuff' into the model.
    //Use the model.stuff in the model.

    final Results results = repository.findAll().get(0);
    final Results allBy1 = repository.findByBuildNoIs("110");
    final Results allBy2 = repository.findAllByBuildNo("110");
    final Results allBy3 = repository.findAllByBuildNoIs("110");

    String eric = "Eric";
    String testJob = results.getTestJob();
    String buildNo = results.getBuildNo(); // Build coming back as random ID???
    String buildStatus = results.getBuildStatus();
    String buildRevision = results.getBuildRevision();
    String branch = results.getBranch();
    ArrayList<String> testResults = (ArrayList<String>) results.getTestResults();
    for(int i=0;i<testResults.size();i++)
    {
      testResults.get(i);
    }

    model.addAttribute("name", eric);
    model.addAttribute("results", results);
    model.addAttribute("testJob", testJob);
    model.addAttribute("buildNo", buildNo);
    model.addAttribute("buildStatus", buildStatus);
    model.addAttribute("buildRevision", buildRevision);
    model.addAttribute("branch", branch);
    model.addAttribute("testResults", testResults);

    return "BranchSelectionView";
  }
}
