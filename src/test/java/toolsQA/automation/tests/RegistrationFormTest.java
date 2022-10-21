package toolsQA.automation.tests;

import org.testng.annotations.Test;
import toolsQA.automation.testcomponents.BaseTest;
import toolsQA.test.pageobjects.RegistrationPage;
import toolsQA.test.utility.Utils;

public class RegistrationFormTest extends BaseTest {
    @Test(priority = 1)
    public void firstNameValidation() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillLastName(Utils.getElementFromPropertiesFile("lastName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("email","studentInfo"));
        registrationPage.selectGender(Utils.getElementFromPropertiesFile("gender","studentInfo"));
        registrationPage.fillMobileNumber(Utils.getElementFromPropertiesFile("phone","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifyFirstName();
    }

    @Test(priority = 2)
    public void lastNameValidation() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillFirstName(Utils.getElementFromPropertiesFile("firstName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("email","studentInfo"));
        registrationPage.selectGender(Utils.getElementFromPropertiesFile("gender","studentInfo"));
        registrationPage.fillMobileNumber(Utils.getElementFromPropertiesFile("phone","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifyLastName();
    }

    @Test(priority = 3)
    public void genderValidation() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillFirstName(Utils.getElementFromPropertiesFile("firstName","studentInfo"));
        registrationPage.fillLastName(Utils.getElementFromPropertiesFile("lastName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("email","studentInfo"));
        registrationPage.fillMobileNumber(Utils.getElementFromPropertiesFile("phone","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifyGender();
    }

    @Test(priority = 4)
    public void mobileNumberValidation() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillFirstName(Utils.getElementFromPropertiesFile("firstName","studentInfo"));
        registrationPage.fillLastName(Utils.getElementFromPropertiesFile("lastName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("email","studentInfo"));
        registrationPage.selectGender(Utils.getElementFromPropertiesFile("gender","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifyPhoneNumber();
    }

    @Test(priority = 5)
    public void mobileNumberLengthValidation() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillFirstName(Utils.getElementFromPropertiesFile("firstName","studentInfo"));
        registrationPage.fillLastName(Utils.getElementFromPropertiesFile("lastName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("email","studentInfo"));
        registrationPage.selectGender(Utils.getElementFromPropertiesFile("gender","studentInfo"));
        registrationPage.fillMobileNumber(Utils.getElementFromPropertiesFile("shortPhone","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifyPhoneNumber();
    }

    @Test(priority = 6)
    public void emailFormatValidation() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillFirstName(Utils.getElementFromPropertiesFile("firstName","studentInfo"));
        registrationPage.fillLastName(Utils.getElementFromPropertiesFile("lastName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("wrongEmail","studentInfo"));
        registrationPage.selectGender(Utils.getElementFromPropertiesFile("gender","studentInfo"));
        registrationPage.fillMobileNumber(Utils.getElementFromPropertiesFile("phone","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifyEmailFormat();
    }

    @Test(priority = 7)
    public void successfulFormSubmission() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillFirstName(Utils.getElementFromPropertiesFile("firstName","studentInfo"));
        registrationPage.fillLastName(Utils.getElementFromPropertiesFile("lastName","studentInfo"));
        registrationPage.fillEmail(Utils.getElementFromPropertiesFile("email","studentInfo"));
        registrationPage.selectGender(Utils.getElementFromPropertiesFile("gender","studentInfo"));
        registrationPage.fillMobileNumber(Utils.getElementFromPropertiesFile("phone","studentInfo"));
        registrationPage.clickSubmitButton();
        Thread.sleep(2000);
        registrationPage.verifySuccessfulFormSubmission();
    }
}
