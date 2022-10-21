package toolsQA.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {
    WebDriver driver;
    String expectedResult, actualResult;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFirstName(String firstname){
        driver.findElement(By.id("firstName")).sendKeys(firstname);
    }
    public void fillLastName(String lastname){
        driver.findElement(By.id("lastName")).sendKeys(lastname);
    }
    public void fillEmail(String email){
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }
    public void selectGender(String gender){
        Actions act =  new Actions(driver);
        if(gender.equals("Male"))
            act.moveToElement(driver.findElement(By.id("gender-radio-1"))).click().perform();
        else if(gender.equals("Female"))
            act.moveToElement(driver.findElement(By.id("gender-radio-2"))).click().perform();
        else
            act.moveToElement(driver.findElement(By.id("gender-radio-3"))).click().perform();
    }
    public void fillMobileNumber(String mobile){
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
    }
    public void clickSubmitButton(){
        WebElement element = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void verifyFirstName(){
        actualResult = driver.findElement(By.id("firstName")).getCssValue("border-bottom-color");
        expectedResult = "rgba(220, 53, 69, 1)";
        Assert.assertEquals(actualResult,expectedResult);
    }
    public void verifyLastName(){
        actualResult = driver.findElement(By.id("lastName")).getCssValue("border-bottom-color");
        expectedResult = "rgba(220, 53, 69, 1)";
        Assert.assertEquals(actualResult,expectedResult);
    }

    public void verifyGender(){
        actualResult = Color.fromString(driver.findElement(By.xpath("//label[contains(text(),'Male')]")).getCssValue("color")).asHex();
        expectedResult = "#dc3545";
        Assert.assertEquals(actualResult,expectedResult);
    }

    public void verifyPhoneNumber(){
        actualResult = driver.findElement(By.id("userNumber")).getCssValue("border-bottom-color");
        expectedResult = "rgba(220, 53, 69, 1)";
        Assert.assertEquals(actualResult,expectedResult);
    }

    public void verifyEmailFormat(){
        actualResult = driver.findElement(By.id("userEmail")).getCssValue("border-bottom-color");
        expectedResult = "rgba(220, 53, 69, 1)";
        Assert.assertEquals(actualResult,expectedResult);
    }

    public void verifySuccessfulFormSubmission(){
        actualResult = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']")).getText();
        expectedResult = "Thanks for submitting the form";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
