package lexus_page_factory;

public class FormXpathContent {

    // XPath expressions for form elements
    public static final String FIRST_NAME_INPUT = "input_first_name";
    public static final String LAST_NAME_INPUT = "input_last_name";
    public static final String EMAIL_ADDRESS_INPUT = "input_email_address";
    public static final String PHONE_NO_INPUT = "input_phone_number";
    public static final String PREFER_DATE_INPUT = "//input[@id='datepicker_preferred_date']";
    public static final String PREFERRED_TIME_DROPDOWN = "(//div[@class='input__wrp col_2']//div[@class='choices'])[1]";
    public static final String PREFERRED_SALES_DROPDOWN = "(//div[@class='input__wrp col_2']//div[@class='choices'])[2]";
    public static final String PREFERRED_SALES_DROPDOWN_A = "select_preferred_sales_consultant";
    public static final String NUMBER_OF_PAX_DROPDOWN = "//select[@id='select_pax']//following-sibling::div";
    public static final String PREFERRED_MODEL = "//select[@id='select_preferred_models']//following-sibling::input";
    public static final String TEST_DRIVE_OPTION = "//div[@class='select__global_dealers']";
    public static final String PREFERRED_DATE_TOMORROW = "//span[@class='flatpickr-day today']//following-sibling::span";
    public static final String RX_300 = "choices--select_preferred_models-item-choice-14";
    public static final String SELECT_PAX = "select_pax";
    public static final String COUNTRY_CODE_SECTION = "//div[@class='iti__flag-container']";
    public static final String PAX_CHOICE_1 = "choices--select_pax-item-choice-2";
    public static final String PRIVACY_POLICY = "checkbox_privacy_policy";
    public static final String MARKETING = "checkbox_marketing";
    public static final String BG_PICTURE = "//picture[@class='sec__form_bg']";
    public static final String TEST_DRIVE_VALUE_3 = "//div[@data-value='lexus-test-drive-concierge']";
    public static final String SUBMIT = "//div[@data-value='lexus-test-drive-concierge']";
}
