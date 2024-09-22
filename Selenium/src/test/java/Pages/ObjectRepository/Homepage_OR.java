package Pages.ObjectRepository;

import org.openqa.selenium.By;

public class Homepage_OR {

    public static class locator {

    // By CapitalLetter =
    public static By Username = By.name("username");
    public static By Password = By.name("password");
    public static By RemeberMeClickBox = By.xpath("//input[@id='rememberMe']");
    public static By SignInBTN = By.xpath("//button[contains(text(),'Sign In')]");
    public static By Province_Dropdown = By.xpath("//select[@placeholder='Enter Province']");
    public static By DistrictDropDown = By.xpath("//select[@placeholder='Enter District']");
    public static By SearchFacility = By.xpath("//input[@placeholder='Search facility']");
    public static By Facility = By.xpath("//div[contains(text(),'Dr. Watson Dental Clinic')]");
    public static By EnterBTN = By.xpath("//button[contains(text(),'Enter')]");
    public static By FullNameBTN = By.xpath("//button[contains(text(),'Full Name')]");

    public static By dobInput=By.xpath("//input[@placeholder='DOB']");
    public static By yearDropdown=By.xpath("//select[@class='react-datepicker__year-select']");
    public static By monthDropdown=By.xpath("//select[@class='react-datepicker__month-select']");
    public static By Day(String day) {
        return By.xpath("//div[contains(@class, 'react-datepicker__day') and not(contains(@class, 'react-datepicker__day--outside-month')) and text()='" + day + "']");
    }

    public static By FirstName= By.xpath("//input[@placeholder='First Name']");
    public static By Surname= By.xpath("//input[@placeholder='Surname']");
    public static By Sex = By.xpath("//select[@name='sex']");
    public static By searchBTN = By.xpath("//button[@type='submit']");



    }

    public static class UiElements{
        public static By CheckText = By.xpath("//div[contains(text(),'Select Facility')]");

    }
}
