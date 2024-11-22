package stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en_scouse.An;

public class HomePageSteps extends BaseStep{

	@Given("Launch the application url {string}")
	public void launch_the_application_url(String url) {
	    driver.get(url);
	}

	@An("click careers link")
	public void click_careers_link() {
		driver.findElement(By.xpath("//a[text()='Careers' and @target='_self']")).click();
	}
	
}
