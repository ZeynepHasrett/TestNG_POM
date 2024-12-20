package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditorPage {

    public EditorPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='New']")
    public WebElement newButonu;

    @FindBy(id = "DTE_Field_first_name")
    public WebElement firstNameButonu;

    @FindBy(xpath = "//*[@class='btn']")
    public WebElement createButonu;

    @FindBy(xpath = "//*[@*='search']")
    public WebElement searchKutusu;

    @FindBy(xpath = "(//td[@class='sorting_1'])[1]")
    public WebElement ilkIsimElementi;

}