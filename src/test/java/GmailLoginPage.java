import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GmailLoginPage implements GmailPage {
    @FindBy(xpath = ".//*[@id='identifierId']")
    private WebElement loginField;

    @FindBy(xpath = ".//*[@id='identifierNext']/content")
    private WebElement nextButton;

    @FindBy(xpath = ".//*[@id='password']/div[1]/div/div[1]/input")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='passwordNext']/content")
    private WebElement passwordNextButton;

    public void logIn(String login, String password) {
        inputLogin(login);
        TimeOut.waitThreeSeconds();
        inputPassword(password);
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
        nextButton.click();
    }

    public void inputPassword(String pass) {
        passwordField.sendKeys(pass);
        passwordNextButton.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
