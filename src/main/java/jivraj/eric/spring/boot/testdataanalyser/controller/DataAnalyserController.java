package jivraj.eric.spring.boot.testdataanalyser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.repository.IJobResultRepository;

@Controller
public class DataAnalyserController
{
  @Autowired
  private IJobResultRepository repository;

  @RequestMapping("/")
  public String branchSelectionView()
  {
    return "BranchSelectionView";
  }

  @RequestMapping(value = "/process", method = RequestMethod.GET)
  public String branchResultView(Model model, @RequestParam(name = "firstBranch") String firstBranch)
  {
    final List<JobResults> jobResults = repository.findAllByBranch(firstBranch);
    model.addAttribute("jobResults", jobResults);
    return "BranchResultView";
  }

}
