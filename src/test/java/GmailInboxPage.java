import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailInboxPage implements GmailPage {
    @FindBy(xpath = ".//div[@role='tabpanel']/div/div/table/tbody/tr")
    private WebElement lastLetter;

    @FindBy(xpath = ".//div[contains(@aria-label,'Переместить в')]")
    private WebElement moveToButton;

    @FindBy(xpath = ".//div[contains(text(), 'Спам')]")
    private WebElement spamButton;

    @FindBy(xpath = ".//div[@button = 'В спам!')]")
    private WebElement confirmSpamButton;

    public void moveToSpam(){
        lastLetter.click();
        moveToButton.click();
        spamButton.click();
        confirmSpamButton.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
