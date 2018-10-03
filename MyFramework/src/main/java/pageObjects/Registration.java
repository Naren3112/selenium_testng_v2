package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseActions;

public class Registration extends BaseActions
{

	public Registration()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gender-male")
	public  WebElement male_rb;
	
	@FindBy(id="gender-female")
	public  WebElement female_rb;
	
	@FindBy(css="#FirstName")
	public  WebElement firstName_tb;
	
	@FindBy(css="#register-button")
	public  WebElement RegisterButton;
	
	@FindBy(xpath="//span[@for='LastName']")
	public  WebElement lastNameRequiredMsgField;
	
	String expectedErrorMsgForLastNameReqMsg = "Last name is required.";
	
	
	public Registration selectMaleRB()
	{
		selectRadioButton(male_rb,"Male");
		return this;
	}
	
	public Registration selectFemaleRB()
	{
		selectRadioButton(female_rb,"Female");
		return this;
	}
	
	public Registration setFirstName(String value)
	{
		setText(firstName_tb, value, "First name");
		return this;
	}
	
	public Registration clickRegisterButton()
	{
		clickButton(RegisterButton, "Register");
		return this;
	}
	
	public Registration validateLastNameReqErrorMsg()
	{
		String acutalMsg = lastNameRequiredMsgField.getText().trim().toString();
		validateActualAndExpectedMsg(acutalMsg, expectedErrorMsgForLastNameReqMsg);
		return this;
	}
	
}
