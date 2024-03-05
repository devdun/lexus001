package tests.forms;

import lexus_page_factory.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.Base;

public class VerifyFormFunctionality extends Base {
    private FormPage formPage;

    @DataProvider(name = "formTest")
    public Object[][] formTestData() {
        return getData("form","lexusTest.xlsx");
    }

    @Test(priority = 1, description = "Verify user is in correct page")
    public void verifyUserIsInCorrectPage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lexus.com.sg/en/contact-us/book-a-test-drive.html?model=ux%20300e", "Incorrect page URL");
    }

    @Test(dataProvider = "formTest", priority = 2, description = "Verify user can fill form details")
    public void testFillForm(String firstName, String lastName, String email, String countryCode, String phoneNo, String preferredTime, String consultant, String pax, String models, String testDrive){
        formPage = PageFactory.initElements(driver, FormPage.class);
        formPage.fillFormPersonalDetails(firstName, lastName, email, countryCode, phoneNo);
        //Date should be future date. past dates are not allowed.
        formPage.fillFormdateTime(preferredTime,"March 26, 2024");
        formPage.selectPreferredSalesConsultant(null);
        formPage.setPreferredModel(models);
        formPage.selectNumberOfPax(pax);
        formPage.selectTestDriveOption("lexus-test-drive-concierge");
        formPage.licenceCheckbox();
        formPage.termsCheckbox();
        formPage.clickPrivacyPolicyCheckbox();
        Assert.assertTrue(formPage.isSubmitButtonEnabled(), "Submit button is not enabled after filling form");
    }


@Test(priority = 3, description = "Verify invalid email Address")
    public void verifyInvalidEmailAddressValidation(){
        formPage = PageFactory.initElements(driver, FormPage.class);
        driver.navigate().refresh();
        formPage.fillEmailAddress("invalid_email");
        formPage.fillFirstName("email Validation");
        Assert.assertTrue(formPage.isEmailErrorDisplayed(), "Email validation error not displayed for invalid email");
    }

@Test(priority = 4, description = "Verify empty fields validation")
    public void verifyEmptyFieldsValidation(){
        formPage = PageFactory.initElements(driver, FormPage.class);
        formPage.fillFormPersonalDetails("", "", "", "", "");
        Assert.assertTrue(formPage.isFirstNameErrorDisplayed(), "First name validation error not displayed for empty field");
        Assert.assertTrue(formPage.isLastNameErrorDisplayed(), "Last name validation error not displayed for empty field");
        Assert.assertTrue(formPage.isEmailErrorDisplayed(), "Email validation error not displayed for empty field");
    }

}
