import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TimeOut {
    public static void waitThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // не всегда отрабатывает почему-то, поэтому юзала предыдущий
    public static void implicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
