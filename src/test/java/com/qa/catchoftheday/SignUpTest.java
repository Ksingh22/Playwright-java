package com.qa.catchoftheday;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.microsoft.playwright.Page;
import com.qa.catchoftheday.pages.Signup;


public class SignUpTest {
    Playwrightinit pf;
    Page page;
    Signup signUp;

    @BeforeTest
    public void setUp(){
        pf = new Playwrightinit();
        page = pf.initBrowser("firefox", true);
        signUp = new Signup(page);

    }

    @Test(description = "Test User should be able Sign Up")
    public void TestUserAbleToSignUp() throws InterruptedException{
        signUp.clickAccountLink();
        signUp.clickSignUpLink();
        signUp.enterSignUPEmailAddress();
        signUp.enterPassword();
        signUp.clickLogInButton();
        
    }
    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}