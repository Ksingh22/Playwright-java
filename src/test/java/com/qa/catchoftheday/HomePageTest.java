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
        page = pf.initBrowser("firefox", true);
        homePage = new HomePage(page);

    }
    @Test(description = "Test User should be able to add deals from Filter -> catch")
    public void TestDealsFromCatch() throws InterruptedException{
        homePage.clickHeaderLinks("Clearance");
        homePage.clickEventBanner(2);
        homePage.clickdealsfromfilter("Catch");
        int productsToAdd = 2;
        homePage.addRandomProductsToCart(productsToAdd);
        homePage.clickCartIcon();
        assertThat(homePage.shoppingCartTitle()).isVisible();;
    }
    @Test 
    public void TestDealsFromMarketplace() throws InterruptedException{
        homePage.clickHeaderLinks("Clearance");
        homePage.clickEventBanner(2);
        homePage.clickdealsfromfilter("Marketplace");
        int productsToAdd = 2;
        homePage.addRandomProductsToCart(productsToAdd);
        homePage.clickCartIcon();
        assertThat(homePage.shoppingCartTitle()).isVisible();;
    }
    @Test 
    public void TestEOFYSaleDealsFromMarketplace() throws InterruptedException{
        homePage.clickHeaderLinks("EOFY Sale");
        homePage.clickEventBanner(2);
        homePage.clickdealsfromfilter("Marketplace");
        int productsToAdd = 2;
        homePage.addRandomProductsToCart(productsToAdd);
        homePage.clickCartIcon();
        assertThat(homePage.shoppingCartTitle()).isVisible();;
    }

    @Test
    public void TestEventBanner(){
        homePage.clickHeaderLinks("Today's Deals");
        homePage.clickEventBanner(2);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }

}
