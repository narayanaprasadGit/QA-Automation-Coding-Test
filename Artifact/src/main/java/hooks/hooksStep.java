package hooks;

import java.time.Duration;
import java.util.Collection;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepdefs.BaseStep;

public class hooksStep extends BaseStep {
	@Before
	public void launch(Scenario scenario)
	{
		Collection<String> sourceTagNames = scenario.getSourceTagNames();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@After
	public void close(Scenario scenario)
	{
		Collection<String> sourceTagNames = scenario.getSourceTagNames();
			driver.close();
	}
}
