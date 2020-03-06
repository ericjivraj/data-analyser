package jivraj.eric.spring.boot.testdataanalyser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;
import jivraj.eric.spring.boot.testdataanalyser.repository.IJobResultRepository;

@Controller
public class DataAnalyserController
{
  @Autowired
  private IJobResultRepository repository;

  @RequestMapping("/")
  public String branchSelectionView(Model model)
  {
    final JobResults results = repository.findAllByBranch("origin/master");

    String testJob = results.getTestJob();
    String buildNo = results.getBuildNo();
    String buildStatus = results.getBuildStatus();
    String buildRevision = results.getBuildRevision();
    String branch = results.getBranch();
    List<TestResults> testResults = results.getTestResults();

    model.addAttribute("testJob", testJob);
    model.addAttribute("buildNo", buildNo);
    model.addAttribute("buildStatus", buildStatus);
    model.addAttribute("buildRevision", buildRevision);
    model.addAttribute("branch", branch);
    model.addAttribute("testResults", testResults);

    return "BranchSelectionView";
  }
}
