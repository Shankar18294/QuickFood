package com.Pratian.QuickFood.Automation.TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.QuickFood.Automation.FileHandling.PropertyManager;
import com.Pratian.QuickFood.Automation.PageObjects.LoginRegister;




public class TestLogin extends BaseTest {
	
	static Logger log = LogManager.getLogger(TestLogin.class);
	
	@Test(dataProvider = "signIn")
	public void signInWithValidCredentials(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to signIn
		with valid credentials*/
		
		driver.get(PropertyManager.getProperty("url.app"));
        driver.manage().window().maximize();

		LoginRegister login= new LoginRegister(driver);
		
		login.loginPage(driver);
		log.debug("Clicked on login or register link");
		
		login.provideUsername(userName);
		log.debug("username entered");
		
		login.providePassword(password);
	    log.debug("password entered");
		
		login.clickLogin(driver);
		log.debug("loginIn button clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(login.getProfileName(driver), "SHANKAR");
		log.debug("assertion passed");
	}
	

	@DataProvider(name="signIn")			
	String [][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/Pratian/QuickFood/Automation/TestData/testData.xlsx";
		
		int rownum=com.Pratian.QuickFood.Automation.Utils.XLUtils.getRowCount(path, "Sheet1");
		int colcount=com.Pratian.QuickFood.Automation.Utils.XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=com.Pratian.QuickFood.Automation.Utils.XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	

}
