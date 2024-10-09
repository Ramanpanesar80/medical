package pkg1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class ApiPayment {
	private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        loginToPay();
    }

    // Login method
    void loginToPay() {
        driver.get("http://localhost:3000/signin");

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button[contains(text(), 'Sign In')]")));

        emailInput.sendKeys("pargol@gmail.com");
        passwordInput.sendKeys("Pass@12");

        signInButton.click();

        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/patient-dashboard"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
        WebElement doctorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/select")));
        Select doctorSelect = new Select(doctorDropdown);
        doctorSelect.selectByVisibleText("Dr. Smith");
    
        WebElement dateInput = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        dateInput.sendKeys("2024-10-15");
    
        WebElement timeInput = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        timeInput.sendKeys("14:00");
        driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();

        assertEquals("http://localhost:3000/patient-dashboard", driver.getCurrentUrl(), "Failed to redirect to patient dashboard after login.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
//    test form is displayed
//    @Test
//    public void testPaymentPageDisplayed() {
//    	loginToPay();
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div")));
//
//        assertNotNull(paymentForm, "Payment form is not displayed after booking the appointment.");
//    }
    
//    test payment api
//    @Test
//    public void testFieldIsAvailable() {
//    	loginToPay();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//
//        WebElement cardNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input")));
//        WebElement expiryDateInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/span[2]/span[1]/span/span/input"));
//        WebElement cvcInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/span[2]/span[2]/span/span/input"));
//
//        assertNotNull(cardNumberInput, "Card number input field is missing.");
//        assertNotNull(expiryDateInput, "Expiry date input field is missing.");
//        assertNotNull(cvcInput, "CVC input field is missing.");
//    }
//     	
//    test for error message with empty fields
//    @Test
//    public void testPaymentWithoutDetails() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Pay']")));
//        payButton.click();
//
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Your card number is incomplete')]")));
//
//        assertTrue(errorMessage.isDisplayed(), "Error message not displayed when trying to submit payment without details.");
//    }

//    test payment to finalize booking
//    @Test
//    public void testSuccessfulPayment() {
//    	loginToPay();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//
//        WebElement cardNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='cardnumber']")));
//        cardNumberInput.sendKeys("4242424242424242"); 
//
//        WebElement expiryDateInput = driver.findElement(By.xpath("//input[@name='exp-date']"));
//        expiryDateInput.sendKeys("12/24");
//
//        WebElement cvcInput = driver.findElement(By.xpath("//input[@name='cvc']"));
//        cvcInput.sendKeys("123");
//
//        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitButton.click();
//
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Appointment booked and payment successful!')]")));
//        assertTrue(successMessage.isDisplayed(), "Success message not displayed after submitting valid payment details.");
//    }
    
//    test invalid card
//    @Test
//    public void testInvalidCard() {
//    	loginToPay();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//
//        WebElement cardNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input")));
//        cardNumberInput.sendKeys("1234567890123456");
//
//        WebElement expiryDateInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/span[2]/span[1]/span/span/input"));
//        expiryDateInput.sendKeys("12/24");
//
//        WebElement cvcInput = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/span[2]/span[2]/span/span/input"));
//        cvcInput.sendKeys("123");
//
//        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
//        submitButton.click();
//
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Invalid card details')]")));
//        assertTrue(errorMessage.isDisplayed(), "Error message for invalid card details is not displayed.");
//    }
    
    
//		test signout button
//    @Test
//    public void testSignOut() {
//    	loginToPay();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/button")));
//        signOutButton.click();
//
//        
//        wait.until(ExpectedConditions.urlContains("/signin"));
//        assertEquals("http://localhost:3000/signin", driver.getCurrentUrl(), "Redirection to sign-in page failed after sign-out.");
//    }

//    test footer is visible
//    @Test
//    public void testFooterDisplayed() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("footer")));
//        
//        assertTrue(footer.isDisplayed(), "Footer is not displayed.");
//    }

//    test about us
//    @Test
//    public void testAboutUs() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[1]/a")));
//        aboutUsLink.click();
//
//        wait.until(ExpectedConditions.urlContains("/about"));
//        assertEquals("http://localhost:3000/about", driver.getCurrentUrl(), "Redirection to 'About Us' page failed.");
//    }
    
//    test privacy policy
//    @Test
//    public void testPrivacyPolicy() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[2]/a")));
//        privacyPolicyLink.click();
//
//        wait.until(ExpectedConditions.urlContains("/privacy-policy"));
//        assertEquals("http://localhost:3000/privacy-policy", driver.getCurrentUrl(), "Redirection to 'Privacy Policy' page failed.");
//    }
    
//    test terms and conditions
//    @Test
//    public void testtermsAndConditions() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement termsAndConditionsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[3]/a")));
//        termsAndConditionsLink.click();
//
//        wait.until(ExpectedConditions.urlContains("/terms-and-conditions"));
//        assertEquals("http://localhost:3000/terms-and-conditions", driver.getCurrentUrl(), "Redirection to 'Terms and Conditions' page failed.");
//    }


    
    


}
