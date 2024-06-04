package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 *
 */
public class ElectronicsTestLatest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        verifyElements("Not a cell phone", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        // 2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //2.3 Verify the text “Cell phones”
        verifyElements("Not a cell phone", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyElements("Not a Nokia Lumia 1020", "Nokia Lumia 1020", By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));

        //2.7 Verify the price “$349.00”
        verifyElements("Price not match", "$349.00", By.xpath("//span[@id='price-value-20']"));

        //2.8 Change quantity to 2
        clearText(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Topngreen Bar
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(2000);
        verifyElements("Not a shipping cart", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //2.13 Verify the quantity is 2
        verifyElements("Quantity does not change","2",By.xpath("//input[@id='itemquantity11230' and @value='2']"));

        //2.14 Verify the Total $698.00
        verifyElements("Total not match", "$698.00", By.xpath("//span[@class='product-subtotal']"));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Not the same page", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        verifyElements("Not Register page", "Register", By.xpath("//h1[normalize-space()='Register']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Smita");
        sendTextToElement(By.id("LastName"), "Vaja");
        sendTextToElement(By.id("Email"), "smitavaja@gmail.com");
        sendTextToElement(By.id("Password"), "Admin@123");
        sendTextToElement(By.id("ConfirmPassword"), "Admin@123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyElements("Registration not completed", "Your registration completed", By.xpath("//div[@class='result']"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping cart”
        verifyElements("Not the shopping cart", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(5000);

        //Login agian because cart is empty
        clickOnElement(By.xpath("//a[normalize-space()='Log in']"));
        sendTextToElement(By.id("Email"), "smitavaja@gmail.com");
        sendTextToElement(By.id("Password"), "Admin@123");
        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));
        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Paddington");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "WA9 1ED");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "+447801234567");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.cssSelector("button[class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        //Enter cardholder name
        sendTextToElement(By.id("CardholderName"), "Smita Vaja");
        //card number
        sendTextToElement(By.id("CardNumber"), "414411111111111");
        // Expire date
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "03");
        // Expire Year
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        // Card code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        // 2.34 Click on “CONTINUE”
        clickOnElement(By.cssSelector(".button-1.payment-info-next-step-button"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyElements("Not a credit card ", "Credit Card", By.xpath("//span[normalize-space()='Credit Card']"));

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyElements("Not a 2nd day Air", "2nd Day Air", By.cssSelector("li[class='shipping-method'] span[class='value']"));

        //2.37 Verify Total is “$698.00”
        verifyElements("Not Total match", "$698.00", By.xpath("//span[@class='product-subtotal']"));

        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank You”
        verifyElements("Not a Thank you", "Thank you", By.xpath("//h1[normalize-space()='Thank you']"));

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyElements("Not the order palced", "Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.42 Verify the text “Welcome to our store”
        verifyElements("error", "Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl2 = "https://demo.nopcommerce.com/";
        Assert.assertEquals("Url not verified", expectedUrl2, currentUrl);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
