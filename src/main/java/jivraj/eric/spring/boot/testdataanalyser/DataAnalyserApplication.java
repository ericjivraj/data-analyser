package jivraj.eric.spring.boot.testdataanalyser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This is the application class which Spring uses to run the application
 */
@SpringBootApplication
public class DataAnalyserApplication extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(DataAnalyserApplication.class);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(DataAnalyserApplication.class, args);
	}
}
