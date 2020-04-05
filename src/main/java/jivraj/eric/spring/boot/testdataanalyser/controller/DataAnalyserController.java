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

/** This class forms part of the controller layer
 * This is the Data Analyser Controller class, this object represents the router controller that handles requests and responses
 */
@Controller
public class DataAnalyserController
{
  @Autowired
  private IJobResultRepository repository;

  /** Default method that gets called when the web app starts running
   * @return Menu Selection View which is the initial default view for the web app
   */
  @RequestMapping("/")
  public String menuSelectionView()
  {
    return "MenuSelectionView";
  }

  /** Method that gets called when the menu option to view the test results for all builds in a branch is selected
   * @return Branch Selection View which allows you to select a branch to view the test results for all builds
   */
  @RequestMapping("/selectBranch")
  public String branchSelectionView()
  {
    return "BranchSelectionView";
  }

  /** Method that gets called when the submit button is pressed for viewing the test results for all the builds in a branch
   * @param model Model object that will feed the view with data
   * @param leftBranch Branch Name
   * @return Branch Result View which will show the test results for all the builds in a given branch
   */
  @RequestMapping(value = "/viewAllBuilds", method = RequestMethod.GET)
  public String branchResultAllBuildsView(Model model, @RequestParam(name = "leftBranch") String leftBranch)
  {
    final List<JobResults> jobResults = repository.findAllByBranch(leftBranch);
    model.addAttribute("jobResults", jobResults);
    return "BranchResultView";
  }

  /** Method that gets called when the menu option of viewing the test results for only the last build of a branch is selected
   * @return Branch Selection Last Build View which allows you to select a branch to view the latest test results build
   */
  @RequestMapping("/selectBranchLastBuild")
  public String branchSelectionLastBuildView()
  {
    return "BranchSelectionLastBuildView";
  }

  /** Method that gets called when the submit button is pressed for viewing the test results for the latest build
   * @param model Model object that will feed the view with data
   * @param leftBranch Branch Name
   * @return Branch Result Last Build View which shows the latest test results build for a given branch
   */
  @RequestMapping(value = "/viewLastBuildInBranch", method = RequestMethod.GET)
  public String branchResultLastBuildView(Model model, @RequestParam(name = "leftBranch") String leftBranch)
  {
    final List<JobResults> jobResults = repository.findAllByBranch(leftBranch);
    int lastIndex = jobResults.size()-1;
    JobResults lastBuildResults = jobResults.get(lastIndex);
    model.addAttribute("jobResults", lastBuildResults);
    return "BranchResultLastBuildView";
  }

  /** Method that gets called when the menu option of comparing test results between 2 branches is selected
   * @return Branch Selection Comparison View which allows you to select 2 branches to compare
   */
  @RequestMapping("/selectBranches")
  public String branchSelectionComparisonView()
  {
    return "BranchSelectionComparisonView";
  }

  /** Method that gets called when the submit button is pressed for comparing test results between branches
   * The purpose of this comparison is to show you only the real test failures that you need to fix and worry about
   * @param model Model object that will feed the view with data
   * @param leftBranch Left Branch Name (first branch input)
   * @param rightBranch Right Branch Name (second branch input)
   * @return Branch Result Comparison View which shows you the real test failures that you need to worry about and fix
   */
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