import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GmailSpamTest {

    private WebDriver driver;
    private GmailLoginPage gmailLoginPage;
    private GmailMainPage gmailMainPage;
    private GmailInboxPage gmailInboxPage;
    private GmailSpamPage gmailSpamPage;
    private Utils utils;

    @Before
    public void before() {
        driver = new ChromeDriver();
        gmailLoginPage = new GmailLoginPage();
        gmailMainPage = new GmailMainPage();
        gmailInboxPage = new GmailInboxPage();
        gmailSpamPage = new GmailSpamPage();
        utils = new Utils();

        gmailLoginPage.init(driver);
        gmailMainPage.init(driver);
        gmailInboxPage.init(driver);
        gmailSpamPage.init(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void checkSpamMessage() {
        String firstMessageSubject = utils.generateRandomSentence();
        String secondMessageSubject = utils.generateRandomSentence();
        String firstMessageText = utils.generateRandomSentence();
        String secondMessageText = utils.generateRandomSentence();

        driver.navigate().to(Constants.URL);
        gmailLoginPage.logIn(Constants.FIRST_ACCOUNT_EMAIL, Constants.FIRST_ACCOUNT_PASSWORD);
        TimeOut.waitThreeSeconds();
        gmailMainPage.sendMessage(Constants.SECOND_ACCOUNT_EMAIL, firstMessageSubject, firstMessageText);
        TimeOut.waitThreeSeconds();
        gmailMainPage.signOut();
        TimeOut.waitThreeSeconds();
        gmailLoginPage.logIn(Constants.SECOND_ACCOUNT_EMAIL, Constants.SECOND_ACCOUNT_PASSWORD);
        TimeOut.waitThreeSeconds();
        gmailInboxPage.moveToSpam();
        TimeOut.waitThreeSeconds();
        gmailMainPage.signOut();
        TimeOut.waitThreeSeconds();
        gmailLoginPage.logIn(Constants.FIRST_ACCOUNT_EMAIL, Constants.FIRST_ACCOUNT_PASSWORD);
        TimeOut.waitThreeSeconds();
        gmailMainPage.sendMessage(Constants.SECOND_ACCOUNT_EMAIL, secondMessageSubject, secondMessageText);
        TimeOut.waitThreeSeconds();
        gmailMainPage.signOut();
        TimeOut.waitThreeSeconds();
        gmailLoginPage.logIn(Constants.SECOND_ACCOUNT_EMAIL, Constants.SECOND_ACCOUNT_PASSWORD);
        TimeOut.waitThreeSeconds();
        Assert.assertEquals(secondMessageSubject, gmailSpamPage.checkSpam().getText());
    }
}
