package stepdefs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseStep {
	public static ChromeDriver driver;
	public static WebDriverWait wait;
}
