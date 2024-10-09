package pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class PatientDashboardTest {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        login();
    }

    // Login method
    void login() {
        driver.get("http://localhost:3000/signin");

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button[contains(text(), 'Sign In')]")));

        // Enter valid email and password
        emailInput.sendKeys("pargol@gmail.com");
        passwordInput.sendKeys("Pass@12");

        // Click the sign-in button
        signInButton.click();

        // Wait for the dashboard page to load
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/patient-dashboard"));

        // Assert that we are redirected to the dashboard
        assertEquals("http://localhost:3000/patient-dashboard", driver.getCurrentUrl(), "Failed to redirect to patient dashboard after login.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//     Test case for navigating to the patient dashboard and clicking the sign-in button
//    @Test
//    void testPatientDashboardSignIn() {
//        login();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button")));
//        
//        signInButton.click();
//
//        String expectedUrl = "http://localhost:3000/patient-dashboard";
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//        assertEquals(expectedUrl, driver.getCurrentUrl(), "Login redirection failed or did not occur.");
//    }

    // Test case for invalid login
//    @Test
//    void testInvalidLogin() {
//        login();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
//        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
//        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button")));
//
//        emailInput.sendKeys("invalidemail@example.com");
//        passwordInput.sendKeys("wrongpassword");
//
//        signInButton.click();
//
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Invalid credentials')]")));
//        assertNotNull(errorMessage, "Error message for invalid login is not displayed.");
//    }
//    
//    // test with valid login
//    @Test
//    void testLogin() {
//        login();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
//        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
//        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button")));
//
//        emailInput.sendKeys("pargol@gmail.com");
//        passwordInput.sendKeys("Pass@12");
//
//        signInButton.click();
//
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Invalid credentials')]")));
//        assertNotNull(errorMessage, "Error message for invalid login is not displayed.");
//    }
    
//    Login to patient dash
//    @Test
//    void testValidLogin() {
//        driver.get("http://localhost:3000/signin");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
//        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
//        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button[contains(text(), 'Sign In')]")));
//
//        emailInput.sendKeys("pargol@gmail.com");
//        passwordInput.sendKeys("Pass@12");
//
//        signInButton.click();
//
//        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/patient-dashboard"));
//
//        assertEquals("http://localhost:3000/patient-dashboard", driver.getCurrentUrl(), "Failed to redirect to patient dashboard after login.");
//    }
//    
//    test the form filling and go to payment
//    @Test
//    void testPateintForm() {
//    	login();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        
//        WebElement doctorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/select")));
//        Select doctorSelect = new Select(doctorDropdown);
//        doctorSelect.selectByVisibleText("Dr. Smith");
//        
//        WebElement dateInput = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
//        dateInput.sendKeys("2024-10-15"); 
//        
//        WebElement timeInput = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
//        timeInput.sendKeys("14:00");
//        
//        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Proceed to Payment')]"));
//        submitButton.click();
//
//        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/button")));
//        
//        assertNotNull(paymentForm, "Payment step is not displayed after submitting the booking form.");
//    }
    
    //check it goes to payment after selecting appointment
//    @Test
//    void testGotoPayment() {
//        login(); 
//
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        
//      WebElement doctorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/select")));
//      Select doctorSelect = new Select(doctorDropdown);
//      doctorSelect.selectByVisibleText("Dr. Smith");
//      
//      WebElement dateInput = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
//      dateInput.sendKeys("2024-10-15");
//      
//      WebElement timeInput = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
//      timeInput.sendKeys("14:00");
//      driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();
//
//      assertTrue(wait.until(ExpectedConditions.urlContains("payment")), "Failed to redirect to the payment page.");
//    }

//    @Test
//    public void testSubmitFeedbackForm() {
//    	
//    	login();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement feedbackTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/form/div/textarea")));
//        
//        feedbackTextarea.sendKeys("Hi this is Pargol.");
//
//        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/div/form/button"));
//        submitButton.click();
//        
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-message")));
//        
//        assertTrue(successMessage.isDisplayed(), "Success message not displayed after submitting feedback.");
//    
//    }

    

}
