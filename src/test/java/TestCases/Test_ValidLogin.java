package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageComponents.DataReader;
import Pages.LoginPage;
import TestComponents.BaseTest;

public class Test_ValidLogin extends BaseTest {

	public LoginPage login;
	public DataReader data;
	String username = "Admin", password = "admin123";

	@BeforeMethod
	public void setUp() {
		login = new LoginPage(driver);
		data = new DataReader();
	}

	@Test
	public void test_validLogin() throws IOException {
		login.loginUser(data.readData("username"), data.readData("password"));

		Assert.assertTrue(login.isLoginSuccessful(),"user login is not successful");
	}
}
