package com.qa.catchoftheday.pages;
import java.util.List;
import java.util.Random;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;

public class HomePage {
    Page page;
    private List<Locator> headerLinks;
    // private Locator headerVerify;
    // private List<Locator> getAllDeals;
    private Locator cartIcon;
    // private List<Locator> cartItems;
    // private Locator popUpwindow;
    // private Locator addedToCartPopup;
    private Locator shoppingCartTitle;

    public HomePage(Page page){
        this.page = page;
        
    
    //from landing page to check out locators 
    this.headerLinks= page.locator(".css-4hbenv div a h5").all();
    // this.headerVerify = page.locator(".event--title h1");
    // this.getAllDeals = page.locator(".css-4hbenv div a").all();
    this.cartIcon = page.locator("#mini-cart");
    // this.cartItems = page.locator("ul[aria-label='Items from Catch'] li").all();
    // this.popUpwindow = page.locator(".modal-content");
    // this.addedToCartPopup = page.locator(".toast.toast-success .message");
    this.shoppingCartTitle = page.locator("h1.css-lnirao.e12cshkt0");

    }

    public void clickHeaderLinks(String linkName){
        for (Locator locator : headerLinks) {
            locator.allInnerTexts().forEach(li ->{if(li.equals(linkName)){
                locator.click();
            }});
    }
}
    public void clickEventBanner(Integer event){
        Locator AllDeals = page.locator(".event.event--single div.event--card a").nth(event);
        AllDeals.click();
    }

    public Locator GetFilterLocator(String dealsfrom){
        return page.locator("//label[@title='"+dealsfrom+"']");
    }

    public void clickdealsfromfilter(String deals_from){
        GetFilterLocator(deals_from).click();
    }

    // public List<Locator> GetProductsLocator(){
    //     return page.locator(".product--card").all();
    // }

    public void addRandomProductsToCart(int numberOfProducts){
        Random random = new Random();
        List<Locator> allProducts = page.locator(".product--buy-form--container").all();
        for(int i =0; i <numberOfProducts;i++){
            int rndmIndx = random.nextInt(allProducts.size());
            Locator randomElement = allProducts.get(rndmIndx);
            if(randomElement.locator("a").isHidden()){
                randomElement.waitFor();
                randomElement.hover();
                randomElement.locator("button").click();
                page.waitForSelector(".toast.toast-success .message").waitForElementState(ElementState.STABLE);
            }
            else{
                randomElement.waitFor();
                randomElement.hover();
                randomElement.locator("a").click();
                page.getByLabel("Add to cart").click();
                page.waitForSelector(".css-1arl00l p").waitForElementState(ElementState.VISIBLE);
                page.goBack();

            }
            
        }
    }
    public void clickCartIcon(){
        page.waitForSelector("#mini-cart").waitForElementState(ElementState.STABLE);
        cartIcon.click();
    }    

    public Locator shoppingCartTitle(){
        return shoppingCartTitle;
    }
}
