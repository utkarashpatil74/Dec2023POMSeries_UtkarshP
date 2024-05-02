package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	//we will not write any testng code in page class.
	
	//1. Private By locators
	

	private By logoutLink=By.linkText("Logout");
	private By myAccountLink=By.linkText("My Account");
	private By headers =By.cssSelector("div#content h2");
	private By search=By.name("search");
	private By searchIcon=By.cssSelector("div#search button");
	private By utkarsh=By.xpath("utkarsh_patil");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
public String getAccPageTitle() {
		
		String title=eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE,5);
		System.out.println("Acc page title: "+title);
		return title;
	}
	
	public String getAccPageURL() {
		
		String url=eleUtil.waitForURLContains(AppConstants.ACC_PAGE_URL_FRACTION,5);
		System.out.println("acc page url: "+url);
		return url;
		
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
	}
	
	public boolean myAccountLinkExist() {
		return eleUtil.waitForElementVisible(myAccountLink, 10).isDisplayed();
	}
	
	public SearchResultsPage doSearch(String SearchKey) {
		System.out.println("Searching for: "+SearchKey);
		eleUtil.doSendKeys(search, SearchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
	}
	
	public List<String> getAccountsPageHeaderList() {
		List<WebElement> headersEleList=eleUtil.getElements(headers);
		List<String> headersList=new ArrayList<String>();
		
		for(WebElement e: headersEleList) {
			String header=e.getText();
			headersList.add(header);
		}
		return headersList;
	}
	
	


}
