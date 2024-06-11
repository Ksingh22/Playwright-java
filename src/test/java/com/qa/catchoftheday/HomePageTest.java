package com.qa.catchoftheday;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.microsoft.playwright.Page;
import com.qa.catchoftheday.pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class HomePageTest {
    Playwrightinit pf;
    Page page;
    HomePage homePage;

    @BeforeTest
    public void setUp(){
        pf = new Playwrightinit();
        page = pf.initBrowser("chromium");
        homePage = new HomePage(page);

    }
    @Test 
    public void TestLadingPage() throws InterruptedException{
        homePage.clickHeaderLinks("Clearance");
        homePage.clickEventBanner(2);
        homePage.clickdealsfromfilter("Catch");
        int productsToAdd = 3;
        homePage.addRandomProductsToCart(productsToAdd);
        homePage.clickCartIcon();
        assertThat(homePage.shoppingCartTitle()).isVisible();;
    }

    @Test
    public void TestEventBanner(){
        homePage.clickEventBanner(2);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }




}
