package jivraj.eric.spring.boot.testdataanalyser.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jivraj.eric.spring.boot.testdataanalyser.model.JobResults;
import jivraj.eric.spring.boot.testdataanalyser.model.Match;
import jivraj.eric.spring.boot.testdataanalyser.model.MatchResults;
import jivraj.eric.spring.boot.testdataanalyser.model.TestResults;
import jivraj.eric.spring.boot.testdataanalyser.repository.IJobResultRepository;
import jivraj.eric.spring.boot.testdataanalyser.service.ResultComparison;
import jivraj.eric.spring.boot.testdataanalyser.service.ResultFiltering;

@Controller
public class DataAnalyserController
{
  @Autowired
  private IJobResultRepository repository;

  @RequestMapping("/")
  public String menuSelectionView()
  {
    return "MenuSelectionView";
  }

  @RequestMapping("/selectBranch")
  public String branchSelectionView()
  {
    return "BranchSelectionView";
  }

  @RequestMapping(value = "/viewAllBuilds", method = RequestMethod.GET)
  public String branchResultAllBuildsView(Model model, @RequestParam(name = "firstBranch") String firstBranch)
  {
    final List<JobResults> jobResults = repository.findAllByBranch(firstBranch);
    model.addAttribute("jobResults", jobResults);
    return "BranchResultView";
  }

  @RequestMapping("/selectBranchLastBuild")
  public String branchSelectionLastBuildView()
  {
    return "BranchSelectionLastBuildView";
  }

  @RequestMapping(value = "/viewLastBuildInBranch", method = RequestMethod.GET)
  public String branchResultLastBuildView(Model model, @RequestParam(name = "firstBranch") String firstBranch)
  {
    final List<JobResults> jobResults = repository.findAllByBranch(firstBranch);
    int lastIndex = jobResults.size()-1;
    JobResults lastBuildResults = jobResults.get(lastIndex);
    model.addAttribute("jobResults", lastBuildResults);
    return "BranchResultLastBuildView";
  }

  @RequestMapping("/selectBranches")
  public String branchSelectionComparisonView()
  {
    return "BranchSelectionComparisonView";
  }

  @RequestMapping(value = "/compareBranches", method = RequestMethod.GET)
  public String branchResultComparisonView(Model model, @RequestParam(name = "leftBranch") String leftBranch,
                                           @RequestParam(name = "rightBranch") String rightBranch)
  {
    final List<JobResults> leftBranchJobResultsList = repository.findAllByBranch(leftBranch);
    final List<JobResults> rightBranchJobResultsList = repository.findAllByBranch(rightBranch);
    JobResults leftBranchLastBuildTestResult = leftBranchJobResultsList.get(leftBranchJobResultsList.size()-1);

    ResultComparison resultComparison = new ResultComparison();
    MatchResults matchResults = resultComparison.matchResults(leftBranchJobResultsList, rightBranchJobResultsList);
    List<Match<TestResults>> differencesList = resultComparison.extractDifferences(matchResults);

    ResultFiltering resultFiltering = new ResultFiltering();
    List<Match<TestResults>> filteredDifferences = resultFiltering.filterDifferencesByIntermittentFailures(differencesList, rightBranchJobResultsList);
    List<TestResults> filteredTestResults = filteredDifferences.stream().map(e -> e.getLeft()).collect(Collectors.toList());

    model.addAttribute("jobResult", leftBranchLastBuildTestResult);
    model.addAttribute("filteredResults", filteredTestResults);

    return "BranchResultComparisonView";
  }
}
