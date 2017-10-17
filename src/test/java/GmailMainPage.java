import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailMainPage implements GmailPage {
    @FindBy(xpath = ".//div[contains(text(), 'COMPOSE')]")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement toField;

    @FindBy(name = "subjectbox")
    private WebElement subjectField;

    @FindBy(xpath = ".//div[@role='textbox']")
    private WebElement textField;

    @FindBy(xpath = ".//div[contains(text(), 'Send')]")
    private WebElement sendButton;

    @FindBy(xpath = ".//a[contains(@href,'https://accounts.google.com/SignOutOptions?')]")
    private WebElement accountButton;

    @FindBy(xpath = ".//a[contains(text(), 'Sign out')]")
    private WebElement signOutButton;

    public void sendMessage(String email, String subject, String text){
        composeButton.click();
        fillFields(email, subject, text);
        sendButton.click();
    }

    private void fillFields(String email, String subject, String text){
        toField.sendKeys(email);
        subjectField.sendKeys(subject);
        textField.sendKeys(text);
    }

    public void signOut(){
        accountButton.click();
        signOutButton.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
