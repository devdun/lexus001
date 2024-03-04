package lexus_page_factory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonOperations;

public class FormPage {
    private WebDriver driver;
    private CommonOperations commonOperations;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        commonOperations = new CommonOperations(driver);
    }

    @FindBy(id = FormXpathContent.FIRST_NAME_INPUT)
    private WebElement firstNameInput;

    @FindBy(id = FormXpathContent.LAST_NAME_INPUT)
    private WebElement lastNameInput;

    @FindBy(id = FormXpathContent.EMAIL_ADDRESS_INPUT)
    private WebElement emailAddressInput;

    @FindBy(xpath = FormXpathContent.COUNTRY_CODE_SECTION)
    private WebElement phoneNoCountry;

    @FindBy(id = FormXpathContent.PHONE_NO_INPUT)
    private WebElement phoneNoInput;

    @FindBy(xpath = FormXpathContent.PREFER_DATE_INPUT)
    private WebElement preferredDateInput;

    @FindBy(xpath = FormXpathContent.PREFERRED_TIME_DROPDOWN)
    private WebElement preferredTime;

    @FindBy(xpath = FormXpathContent.PREFERRED_SALES_DROPDOWN)
    private WebElement preferredSales;

    @FindBy(xpath = FormXpathContent.NUMBER_OF_PAX_DROPDOWN)
    public WebElement numberOfPaxDropdown;

    @FindBy(xpath = FormXpathContent.PREFERRED_MODEL)
    private WebElement preferredModel;

    @FindBy(xpath = FormXpathContent.TEST_DRIVE_OPTION)
    private WebElement testDriveOption;

    @FindBy(id = FormXpathContent.PRIVACY_POLICY)
    private WebElement privacyPolicyCheckbox;

    @FindBy(id = FormXpathContent.MARKETING)
    private WebElement marketingCheckbox;

    @FindBy(xpath = FormXpathContent.SUBMIT)
    private WebElement submitButton;

    public void fillFormPersonalDetails(String firstName, String lastName, String email, String countryCode, String phoneNo) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmailAddress(email);
        fillPhoneNumber(countryCode, phoneNo);
    }

    public void fillFormDriveDetails(String preferredTime, String consultant, String pax, String models, String testDrive){
        selectPreferredTime(preferredTime);
        selectPreferredSalesConsultant(consultant);
        selectNumberOfPax(pax);
        setPreferredModel(models);
        selectTestDriveOption(testDrive);
    }

    public void fillAcceptConditions(){
//        clickPrivacyPolicyCheckbox();
//        clickMarketingCheckbox();
    }

    public void fillFormDriveDetails(String firstName, String lastName, String email, String countryCode, String phoneNo,
                         String preferredTimeValue, String consultant, String pax, String models, String testDrive) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmailAddress(email);
        fillPhoneNumber(countryCode, phoneNo);
        selectPreferredTime(preferredTimeValue);
        selectPreferredSalesConsultant(consultant);
        selectNumberOfPax(pax);
        setPreferredModel(models);
        selectTestDriveOption(testDrive);
    }

    public void fillFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmailAddress(String email) {
        emailAddressInput.clear();
        emailAddressInput.sendKeys(email);
    }

    public void fillPhoneNumber(String countryCode, String phoneNo) {
        phoneNoCountry.click();
        WebElement setCountryCode = driver.findElement(By.xpath("//span[@class='iti__dial-code'][contains(text(),'"+countryCode+"')]"));
        setCountryCode.click();

        phoneNoInput.clear();
        phoneNoInput.sendKeys(phoneNo);
    }

    public void selectPreferredDate(String date) {
        preferredDateInput.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        // Define the locator for the element
        By locator = By.cssSelector(".flatpickr-day[aria-label='"+date+"']");
        // Wait for the element to be clickable
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(locator));
        // Perform click action on the element
        item.click();
    }

    public void selectPreferredTime(String time) {
        preferredTime.click();
        selectValueFromDropdown(time);
    }

    public void selectPreferredSalesConsultant(String consultant) {
        if (consultant != null) {
            preferredSales.click();
            selectValueFromDropdown(consultant);
        }
    }

    public void setPreferredModel(String model) {
        preferredModel.clear();
        preferredModel.sendKeys(model);
    }

    public void selectTestDriveOption(String testDrive) {
        scrollDown(driver);
        testDriveOption.click();
        selectValueFromDropdown(testDrive);
    }

    public static void scrollDown(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Scroll down to the bottom of the page
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            System.out.println("Scrolled down successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while scrolling: " + e.getMessage());
        }
    }

    public void selectNumberOfPax(String paxCount) {
        numberOfPaxDropdown.click();
        selectValueFromDropdown(paxCount);
    }

    public void clickPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
    }

    public void clickMarketingCheckbox() {
        marketingCheckbox.click();
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    private void selectValueFromDropdown(String value) {
        driver.findElement(By.xpath("//div[@class='choices__item choices__item--choice choices__item--selectable'][@data-value='"+value+"']")).click();
    }

    public boolean isEmailErrorDisplayed() {
        try {
            WebElement emailError = driver.findElement(By.xpath("//input[@id='email_address']/following-sibling::div[@class='invalid-feedback']"));
            return emailError.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

