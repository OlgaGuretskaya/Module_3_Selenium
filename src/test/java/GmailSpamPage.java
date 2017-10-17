import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSpamPage implements GmailPage {
    @FindBy(xpath = ".//div/span[contains(text(), 'Свернуть')]")
    private WebElement moreButton;

    @FindBy(xpath = "//a[@title='Спам']")
    private WebElement spamFolder;

    @FindBy(xpath = ".//div[@role='tabpanel']/div/div/table/tbody/tr")
    private WebElement lastLetter;

    @FindBy(xpath = ".//table[@role = 'presentation')]/tr/td/div/div/div/div/h2")
    private WebElement letterSubject;

    public WebElement checkSpam(){
        goToSpamFolder();
        lastLetter.click();
        return letterSubject;
    }

    private void goToSpamFolder(){
        moreButton.click();
        spamFolder.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
