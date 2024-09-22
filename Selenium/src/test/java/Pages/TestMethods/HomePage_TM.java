package Pages.TestMethods;

import Library.Operations;
import Pages.ObjectRepository.Homepage_OR;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePage_TM {
    public void guiVerification() {

    }
    public void LogIn(String username, String password, WebDriver driver) {
        Operations.sendText(Homepage_OR.locator.Username, username, driver );
        Operations.sendText(Homepage_OR.locator.Password, password, driver);
        Operations.click(Homepage_OR.locator.RemeberMeClickBox, driver);
        Operations.click(Homepage_OR.locator.SignInBTN, driver);
        Operations.matchText(Homepage_OR.UiElements.CheckText, "Select Facility", driver);
    }

    public void SelectFacilityTM(WebDriver driver) throws InterruptedException {

        Operations.dropDownByVisibleText(Homepage_OR.locator.Province_Dropdown, "Lusaka", driver);
        Operations.dropDownByVisibleText(Homepage_OR.locator.DistrictDropDown, "Lusaka", driver);
        Operations.sendText(Homepage_OR.locator.SearchFacility, "Dr. Watson", driver);
        Thread.sleep(1000);
        Operations.click(Homepage_OR.locator.Facility,driver);
        Thread.sleep(1000);
        Operations.click(Homepage_OR.locator.EnterBTN, driver);
    }

    public void testSearchPatient(String fname, String sname, String year, String month, String date, String sex, WebDriver driver) {

        // If first name is provided, enter it
        if (fname != null && !fname.isEmpty()) {
            Operations.click(Homepage_OR.locator.FullNameBTN, driver);
            Operations.sendText(Homepage_OR.locator.FirstName, fname, driver);
        }

        // If surname is provided, enter it
        if (sname != null && !sname.isEmpty()) {
            Operations.sendText(Homepage_OR.locator.Surname, sname, driver);
        }

        // If date of birth (year, month, date) is provided, select it
        if (year != null && !year.isEmpty()) {
            Operations.click(Homepage_OR.locator.dobInput, driver);
            Operations.dropDownByValue(Homepage_OR.locator.yearDropdown, year, driver);
        }
        if (month != null && !month.isEmpty()) {
            Operations.dropDownByValue(Homepage_OR.locator.monthDropdown, month, driver);
        }
        if (date != null && !date.isEmpty()) {
            Operations.click(Homepage_OR.locator.Day(date), driver);
        }

        // If sex is provided, select it
        if (sex != null && !sex.isEmpty()) {
            Operations.dropDownByVisibleText(Homepage_OR.locator.Sex, sex, driver);
        }

        // Click on search button
        Operations.click(Homepage_OR.locator.searchBTN, driver);

        // Scroll if necessary (optional based on UI)
        Operations.scroll(driver);
    }



}
