package com.Pratian.QuickFood.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegister extends BasePage {
	
	@FindBy(xpath="//*[@id=\"basic-navbar-nav\"]/ul/li[2]/span/a")
	public WebElement loginForm;
	
	@FindBy(xpath="//*[@id=\"userLoginEmail\"]")
	public WebElement userName;
	
	@FindBy(xpath="//*[@id=\"userLoginPassword\"]")
	public WebElement password;	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div/form/button/b")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"basic-navbar-nav\"]/ul/li[3]/span/a")
	public WebElement userProfile;
	
	
	public LoginRegister(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void loginPage(WebDriver driver)
	{
		loginForm.click();
	}
	
	public void provideUsername(String userName)
	{
		this.userName.sendKeys(userName);
	}
	
	public void providePassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void clickLogin(WebDriver driver)
	{
		loginButton.click();
	}
	
	public String getProfileName(WebDriver driver)
	{
		return userProfile.getText();
	}
	

}
