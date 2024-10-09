package pkg1;

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

class DoctorDashboard {
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

	        emailInput.sendKeys("raman12@gmail.com");
	        passwordInput.sendKeys("Panesar@1234");
	        
	        WebElement dropeDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/select")));
	        Select doctorSelect = new Select(dropeDown);
	        doctorSelect.selectByVisibleText("Doctor");


	        signInButton.click();

	        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/doctor-dashboard"));

	        assertEquals("http://localhost:3000/doctor-dashboard", driver.getCurrentUrl());
	    }

	    @AfterEach
	    void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
//	    test login as doctor
//	    @Test
//	    void testDoctorLogin() {
//	        login();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//button")));
//	        
//	        signInButton.click();
//
//	        String expectedUrl = "http://localhost:3000/doctor-dashboard";
//	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//	        assertEquals(expectedUrl, driver.getCurrentUrl());
//	    }
	    
//	    test appointments are displayed
//		@Test
//		public void testAppointmentDisplay() {
//			login();
//    
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			WebElement appointmentsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div")));
//
//			assertTrue(appointmentsTable.isDisplayed());
//}

//	    test canacle appointment
//	    @Test
//	    public void testCancelAppointment() {
//	        login();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div")));
//	        
//	        // Click the Cancel button
//	        cancelButton.click();
//	    }
	    
//	    test add notes
//	    @Test
//	    public void testAddNotesForAppointment() {
//	        login();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        
//	        WebElement addNotesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Notes']")));
//	        addNotesButton.click();
//	        
//	        WebElement notesField = driver.findElement(By.xpath("//textarea"));
//	        notesField.sendKeys("Test notes for the appointment.");
//
//	        WebElement saveNotesButton = driver.findElement(By.xpath("//button[text()='Save Notes']"));
//	        saveNotesButton.click();
//
//	        assertEquals("", notesField.getText());
//	    }
//	    

//	    test the delete button
//	    @Test
//	    public void testDeleteFeedback() {
//	        login();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        
//	        WebElement feedbackList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul")));
//	        assertTrue(feedbackList.isDisplayed(), "Feedback list is not visible.");
//	        
//	        WebElement firstFeedbackItem = feedbackList.findElement(By.xpath(".//li[1]"));
//	        assertTrue(firstFeedbackItem.isDisplayed(), "First feedback item is not visible.");
//	        
//	        WebElement deleteButton = firstFeedbackItem.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/button"));
//	        deleteButton.click();
//	        
//	        wait.until(ExpectedConditions.invisibilityOf(firstFeedbackItem));
//	        
//	        boolean isFeedbackDeleted = driver.findElements(By.xpath(".//li[1]")).isEmpty();
//	        assertTrue(isFeedbackDeleted, "The feedback was not deleted.");
//	    }
	    
//	    test the signout button
//	    @Test
//	    public void testSignOut() {
//	        login();
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        
//	        WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/button")));
//	        signOutButton.click();
//
//	        wait.until(ExpectedConditions.urlContains("/signin"));
//	        assertEquals("http://localhost:3000/signin", driver.getCurrentUrl(), "Redirection to sign-in page failed after sign out.");
//	    }
	    
//	    test footer is available
//	    @Test
//	    public void testFooter() {
//	        login();
//	        
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        
//	        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("footer")));
//	        
//	        assertTrue(footer.isDisplayed(), "Footer is not displayed on the Doctor Dashboard.");
//	    }

//	    test the aboutUs link
//	    @Test
//	    public void testAboutUs() {
//	        login();
//	        
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        
//	        WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[1]/a")));
//	        aboutUsLink.click();
//	        
//	        String expectedUrl = "http://localhost:3000/about"; 
//	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//	        assertEquals(expectedUrl, driver.getCurrentUrl(), "Redirection to 'About Us' page failed from Doctor Dashboard.");
//	    }

//	    test privacy policy
//	    @Test
//	    public void testPrivacyPolicyLinkOnDashboard() {
//	        login();
//	        
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        
//	        WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[2]/a")));
//	        privacyPolicyLink.click();
//	        
//	        String expectedUrl = "http://localhost:3000/privacy-policy";
//	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//	        assertEquals(expectedUrl, driver.getCurrentUrl(), "Redirection to 'Privacy Policy' page failed from Doctor Dashboard.");
//	    }

	    
////	    test terms and conditions
//	    @Test
//	    public void testTerms() {
//	        login();
//	        
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	        
//	        WebElement terms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[3]/a")));
//	        terms.click();
//	        
//	        String expectedUrl = "http://localhost:3000/terms-and-conditions";
//	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//	        assertEquals(expectedUrl, driver.getCurrentUrl(), "Redirection to 'Terms and conditions' page failed from Doctor Dashboard.");
//	    }
	    
}
