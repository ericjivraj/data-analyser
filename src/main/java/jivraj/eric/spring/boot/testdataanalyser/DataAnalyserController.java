package jivraj.eric.spring.boot.testdataanalyser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataAnalyserController
{

  @RequestMapping("/")
  public String index()
  {
    return "This is a Spring Boot Application";
  }
  
}
