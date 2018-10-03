package test_automation_suite;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.Registration;
import utilities.BaseActions;

public class RegistrationTestCases extends BaseActions
{	
	
  @Test
  public void validRegistrationFlowForMale() 
  {
	  LandingPage objForLandingPage = new LandingPage();
	  Registration objForRegistrationPage = new Registration();
	  objForLandingPage.clickRegisterLink();
	  objForRegistrationPage.selectMaleRB().setFirstName("alpha").clickRegisterButton().validateLastNameReqErrorMsg();  
  }
  
  @Test
  public void validRegistrationFlowForFemale() 
  {
	  LandingPage objForLandingPage = new LandingPage();
	  Registration objForRegistrationPage = new Registration();
	  objForLandingPage.clickRegisterLink();
	  objForRegistrationPage.selectFemaleRB().setFirstName("beta").clickRegisterButton();
  }
  
  /*@Test
  public void validRegistrationFlowForMale1() 
  {
	  LandingPage objForLandingPage = new LandingPage();
	  Registration objForRegistrationPage = new Registration();
	  objForLandingPage.clickRegisterLink();
	  objForRegistrationPage.selectMaleRB().setFirstName("alpha").clickRegisterButton().validateLastNameReqErrorMsg();  
  }
  
  @Test
  public void validRegistrationFlowForMal2() 
  {
	  LandingPage objForLandingPage = new LandingPage();
	  Registration objForRegistrationPage = new Registration();
	  objForLandingPage.clickRegisterLink();
	  objForRegistrationPage.selectMaleRB().setFirstName("alpha").clickRegisterButton().validateLastNameReqErrorMsg();  
  }
  
  @Test
  public void validRegistrationFlowForMale3() 
  {
	  LandingPage objForLandingPage = new LandingPage();
	  Registration objForRegistrationPage = new Registration();
	  objForLandingPage.clickRegisterLink();
	  objForRegistrationPage.selectMaleRB().setFirstName("alpha").clickRegisterButton().validateLastNameReqErrorMsg();  
  }*/
  

}
