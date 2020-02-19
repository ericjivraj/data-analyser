package jivraj.eric.spring.boot.testdataanalyser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataAnalyserController
{
  @RequestMapping("/")
  public String branchSelectionView()
  {
    return "BranchSelectionView";
  }
}
