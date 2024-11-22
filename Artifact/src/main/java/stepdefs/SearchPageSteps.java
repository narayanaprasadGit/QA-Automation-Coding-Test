package stepdefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchPageSteps extends BaseStep{

	@Given("Search for {string}")
	public void search_for(String text) {
		driver.findElement(By.xpath("//input[@placeholder='Search job title or location']")).sendKeys(text);
	}

	@Given("click on Search")
	public void click_on_search() {
		driver.findElement(By.xpath("//span[@class='submit-icon']")).click();
	}
	
	@Given("click on First link")
	public void click_on_First_link() {
		WebElement firstLink =
		driver.findElement(By.xpath("//span[text()='Functional Tester ']"));
		wait.until(ExpectedConditions.elementToBeClickable(firstLink));
		firstLink.click();
		//driver.findElement(By.xpath("//span[text()='Functional Tester ']")).click();
	}
	
	@Then("Verify Job title as {string}")
	public void Verify_Job_Title(String title) {
		assertTrue(driver.findElement(By.xpath("//h1[text()='Functional Tester']")).isDisplayed());
	}
	
	@Then("Verify location as {string}")
	public void Verify_Job_Location(String locationExpected) {
		String locationActual = driver.findElement(By.xpath("//span[@class='au-target job-location']")).getText();
		assertTrue(locationActual.contains(locationExpected));
	}
	
	@Then("Verify job id as {string}")
	public void Verify_Job_Id(String jobIdExpected) {
		String jobIdActual = driver.findElement(By.xpath("//span[@class='au-target jobId']")).getText();
		assertTrue(jobIdActual.contains(jobIdExpected));
	}
	
	@Then("Verify job responsibility as {string}")
	public void Verify_Job_Responsibility(String jobResExpected) {
		String jobResActual = driver.findElement(By.xpath("//span[contains(text(),'"  + jobResExpected + "')]")).getText();
		assertTrue(jobResActual.contains(jobResExpected));
	}
}
