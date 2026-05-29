import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FirstTest {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeEach
    public void setup() {
        // Playwright engine başlatılır (tarayıcıları kontrol eden sistem)
        playwright = Playwright.create();

        // Chromium (Chrome’un motoru) açılır
        // Headless false olduğu için ekranda Chrome açılır
        // Eğer true olsaydı browser arka planda çalışacaktı
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        //BrowserContext browserContext = browser.newContext(
        //        new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation"))
        //);

        // Yeni bir sekme (tab) açılır
        page = browser.newPage();
    }

    @Test
    public void firstTest () throws InterruptedException {

        // Sekme zaten açılmıştı. Bu sekmede Google açılır
        page.navigate("https://www.bestbuy.com/?intl=nosplash");

        // Üst menüdeki linkleri array list olarak yazdıralım
        Locator menuItems = page.locator("[data-testid='utility-nav-link-text']");
        System.out.println(menuItems.allTextContents());

        // Üst menüdeki linkleri satır satır olarak yazdıralım
        for (int i = 0; i < menuItems.count(); i++) {

            // nth n'inci element demektir. İngilizcede 2nd 3rd ... nth
            System.out.println(menuItems.nth(i).textContent());


            page.locator("[data-testid='utility-nav-link']", new Page.LocatorOptions().setHasText("Deal of the Day")).click();

            Thread.sleep(3000);
        }




    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
