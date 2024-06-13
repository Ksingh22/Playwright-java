package com.qa.catchoftheday.pages;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Signup {
    Page page;
    Faker faker = new Faker();
    String email = faker.internet().safeEmailAddress();
    String passwrd = faker.internet().password(12,14,true, true, true);

    private Locator accountlink;
    private Locator emailAddress;
    private Locator password;
    private Locator logInBtn;
    private Locator signUpLink;
    private Locator signUpemailAddress;

    public Signup(Page page){
        this.page = page;
        this.accountlink= page.locator(".css-1rbsh4.ehnxcr60");
        this.signUpLink = page.locator(".c160c8e5a.cde19ab95.c7b9aa287 a");
        this.signUpemailAddress = page.locator("#email");
        this.emailAddress = page.locator("#username");
        this.password = page.locator("#password");
        this.logInBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign up"));
        // page.getByLabel("Sign up");
    
}
public void clickSignUpLink(){
    signUpLink.click();
    }  
public void clickAccountLink(){
    accountlink.click();
    }  
public void enterSignUPEmailAddress(){
    signUpemailAddress.fill(email);
    } 
public void enterEmailAddress(){
    emailAddress.fill(email);
    } 

public void enterPassword(){
    password.fill(passwrd);
    } 

public void clickLogInButton(){
    logInBtn.click();
    } 

}




// Your password must contain:
// At least 12 characters
// Lower case letters (a-z)
// Upper case letters (A-Z)
// Numbers (0-9)

