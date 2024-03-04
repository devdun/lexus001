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

 /*   @Test(priority = 1, description = "Verify user is in correct page")
    public void verifyUserIsInCorrectPage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lexus.com.sg/en/contact-us/book-a-testdrive.html?model=ux%20300e", "Incorrect page URL");
    }*/

    @Test(dataProvider = "formTest", priority = 2, description = "Verify user can fill form details")
    public void testFillForm(String firstName, String lastName, String email, String countryCode, String phoneNo, String preferredTime, String consultant, String pax, String models, String testDrive){
        formPage = PageFactory.initElements(driver, FormPage.class);
        formPage.fillFormPersonalDetails(firstName, lastName, email, countryCode, phoneNo);
        //Date should be future date. past dates are not allowed.
        formPage.selectPreferredDate("March 26, 2024");
        formPage.selectPreferredTime(preferredTime);
        formPage.selectPreferredSalesConsultant(null);
        WebElement element = driver.findElement(By.xpath("//select[@id='select_pax']//following-sibling::div"));
        scrollToElement(driver, element);
        formPage.selectNumberOfPax(pax);
        formPage.setPreferredModel(models);
        formPage.selectTestDriveOption(testDrive);
//        Assert.assertTrue(formPage.isSubmitButtonEnabled(), "Submit button is not enabled after filling form");
    }


    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Scrolled to the element successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while scrolling: " + e.getMessage());
        }
    }

}
