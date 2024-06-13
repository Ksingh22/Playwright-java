package com.qa.catchoftheday;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class Playwrightinit {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName, boolean headless){
        System.out.println("browser name is: " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
            browser = playwright.chromium().launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(headless)
                    .setSlowMo(2000));
                     //setChannel("chrome")
            break;
            case "firefox":
            browser = playwright.firefox().launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(headless)
                    .setSlowMo(2000));
            break;
            case "webkit":
            browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
            break;
            case "chrome":
            browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
            break;
        
            default:
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://www.catch.com.au/");
        return page;
    }
}
// browserContext = browser.newContext();
// browserContext.tracing().start(new Tracing.StartOptions()
// .setScreenshots(true)
// .setSnapshots(true));   
// page = browserContext.newPage();
// page.navigate("https://www.catch.com.au/");
// browserContext.tracing().stop(new Tracing.StopOptions()
// .setPath(Paths.get("trace.zip")));
// return page;