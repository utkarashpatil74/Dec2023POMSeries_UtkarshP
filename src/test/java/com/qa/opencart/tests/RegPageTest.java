package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetup() {
		registrationPage=loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"gaurav","gupta","976373242","cg@9800222","yes"},
			{"saurav","shinde","48322453","ag@1234567","no"},
			{"prithvi","gupta","12482929","gg@245356","yes"}
		};
	}
	
	@DataProvider
	public Object[][] getUserRegTestDataFromExcel() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		
	}
	
	@Test(dataProvider = "getUserRegTestDataFromExcel")
	public void userRegTest(String firstname,String lastname,String telephone,String password,String subscribe) {
		Assert.assertTrue(registrationPage.userRegister(firstname,lastname,StringUtils.getRandomEmailId(),
				telephone,password,subscribe));
		
		
	}

}
