package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseActions;

public class LandingPage extends BaseActions
{
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText="Register")
	public  WebElement Register_link;
	
	public LandingPage clickRegisterLink()
	{
		clickLink(Register_link, "Register");
		return this;
	}

}
