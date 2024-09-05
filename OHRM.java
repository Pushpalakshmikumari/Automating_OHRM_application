package testNG;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class OHRM extends OrangeHRMApplication_LogInTest{
	
	FileInputStream OrangeHRMApplicationPropertiesFile;
	Properties properties;
	FileInputStream logInTestDataFile;
	
	
	Cell logInUserNameRowOfCell;
	Cell logInPasswordRowOfCell;

	@Test
	public void validating_tiltle()
	{
		String expected_title = "OrangeHRM";
		System.out.println("THE EXPECTED TITLE IS ---"+expected_title);
		
		String actual_title = driver.getTitle();
		System.out.println("THE ACTUAL TITLE IS ---"+actual_title );
		
		if(expected_title.equals(actual_title))
		{
			System.out.println("TITLE MATCHED ---PASS");
		}
		else
		{
			System.out.println("TITLE NOT MATCHED ----FAIL");
		}
	}
	//validating URL ADDRESS
	@Test
	public void Validating_URL()
	{
		String expected_URL = "orangehrm-4.2.0.1";
		System.out.println("THE EXPECTED URL IS ---"+expected_URL);
		String actual_URL = driver.getCurrentUrl();
		System.out.println("THE ACTUAL URL IS---"+actual_URL);
		
		if(expected_URL.equals(actual_URL))
		{
			System.out.println("THE URL MATCHED---PASS");
		}
		else
		{
			System.out.println("THE URL NOT MATCHED---FAIL");
		}
	}
	@Test
	public void Validating_Login_panel() throws IOException
	{
		String expected_Login_panel_Text = "LOGIN Panel";
		System.out.println("THE EXPECTED LOGIN PANEL IS ---"+expected_Login_panel_Text);
		
		OrangeHRMApplicationPropertiesFile=new FileInputStream("C:\\Users\\pushpa\\Desktop\\java folder\\JavaNewProgramms\\src\\testNG\\Properties File");
		properties =new Properties(); //creating object for properties class
		properties.load(OrangeHRMApplicationPropertiesFile);
		
		//// id="logInPanelHeading"
		By Login_panel_Property=By.id(properties.getProperty("logInPageLogInPanelProperty"));
		//accesing the property of webelement stored in properties file
		WebElement Login_panel=driver.findElement(Login_panel_Property);
		
		String actual_Login_panel_Text = Login_panel.getText();
		System.out.println(" The Acutal Text of OrangeHRM Application LogIn Page TEXT is :- "+actual_Login_panel_Text);
		
		if(actual_Login_panel_Text.equals(expected_Login_panel_Text))
		{
		System.out.println(" Successfully Navigated to the OrangeHRM Application LogIN Page - TEXT Found - PASS ");
		}
		else
		{
		System.out.println(" Failed to Navigate to the OrangeHRM Application LogIN Page - TEXT NOT Found - FAIL ");
		}
	}
	@Test
	public void Validating_Login() throws IOException
	{
		////*[@id="txtUsername"]
		OrangeHRMApplicationPropertiesFile=new FileInputStream("C:\\Users\\pushpa\\Desktop\\java folder\\JavaNewProgramms\\src\\testNG\\Properties File");
		properties =new Properties(); //creating object for properties class
		properties.load(OrangeHRMApplicationPropertiesFile);
		By UsernameProperty=By.id(properties.getProperty("logInPageUserNameProperty"));
		WebElement username=driver.findElement(UsernameProperty);
		username.sendKeys("N170062");
		
		By PasswordProperty=By.id(properties.getProperty("logInPagepasswordProperty"));
		WebElement Password=driver.findElement(PasswordProperty);
		Password.sendKeys("Pushpa@170062");
		
		////*[@id="btnLogin"]
		By LoginButtonProperty=By.xpath("//*[@id=\"btnLogin\"]");
		WebElement Login_button=driver.findElement(LoginButtonProperty);
		Login_button.click();
		
		
		
	}
	//Validating Home page
	@Test
	public void Validating_Homepage() throws IOException
	{
		OrangeHRMApplicationPropertiesFile=new FileInputStream("C:\\Users\\pushpa\\Desktop\\java folder\\JavaNewProgramms\\src\\testNG\\Properties File");
		String expected_Homepage_text = "Admin";
		System.out.println("THE HOME PAGE MATCHED----PASS"+expected_Homepage_text);
		properties =new Properties(); //creating object for properties class
		properties.load(OrangeHRMApplicationPropertiesFile);
		
		//// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		////*[@id="welcome"]
		By welComeAdminProperty=By.xpath("//*[@id=\"welcome\"]");
		WebElement Welcome=driver.findElement(welComeAdminProperty);
		
		String actual_welcome_admin_Text =  Welcome.getText();
		System.out.println("The Actual Text of the OrangeHRM Application HomePage is :- "+actual_welcome_admin_Text);
		
		if(actual_welcome_admin_Text.contains(expected_Homepage_text ))
		{
		System.out.println(" Successfully Navigated to the OrangeHRM Application HOME Page - PASS ");
		
		}

		else
		{
		System.out.println(" Failed to Navigate to the OrangeHRM Application HOME Page - FAIL ");
		}
	}
	@Test
	public void orangeHRMApplicationHomePage_PIMTest()
	{

	// id="menu_pim_viewPimModule"
	By pimProperty=By.id("menu_pim_viewPimModule");
	WebElement pim=driver.findElement(pimProperty);

	Actions pimAction = new Actions(driver);
	pimAction.moveToElement(pim).build().perform();

	}
	@Test
	public void orangeHRMApplicationHomePage_PIM_AddEmployeeTest()
	{

	// id="menu_pim_addEmployee"
	By pimAddEmployeeProperty=By.id("menu_pim_addEmployee");
	WebElement pimAddEmployee=driver.findElement(pimAddEmployeeProperty);
	pimAddEmployee.click();

	}
	@Test
	public void orangeHRMApplication_AddEmployeeTest() throws IOException, InterruptedException
	{
	// id="firstName"
	By firstNameWebElementProperty=By.id("firstName");
	WebElement firstName=driver.findElement(firstNameWebElementProperty);
	firstName.sendKeys("Vishnu01");

	Actions keyBoardAction = new Actions(driver);
	keyBoardAction.sendKeys(Keys.TAB).build().perform();

	// Without identifying the property of MiddleName - directly automating MiddleName -
//	    it is possible since the Current focus of the Action class Object is at the MiddleName-
//	        using the Object directly sending the TestData into MiddleName
	keyBoardAction.sendKeys("Hello01").build().perform();

	// Automating LastName
	keyBoardAction.sendKeys(Keys.TAB).build().perform();
	keyBoardAction.sendKeys("Chello01").build().perform();

	// Automating Employee Photograph
	keyBoardAction.sendKeys(Keys.TAB).build().perform();
	keyBoardAction.sendKeys(Keys.TAB).build().perform();

	keyBoardAction.sendKeys(Keys.ENTER).build().perform();

	Thread.sleep(10000);

	// Upload the Photograh to the Application - its an AutoIT Script converted to a .exe file
	java.lang.Runtime.getRuntime().exec("./OrangeHRMApplicationAutoITFiles/EmployeePhotograph.exe");

	Thread.sleep(5000);

	// id="btnSave"
	By saveButtonProperty=By.id("btnSave");
	WebElement saveButton=driver.findElement(saveButtonProperty);
	saveButton.click();
	}

}
	
