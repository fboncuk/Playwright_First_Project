package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SignUp {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page;

    @BeforeEach
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        );
        //page = browser.newPage();
        page = context.newPage();
    }

    @Test
    public void firstTest () throws InterruptedException {

        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("[class='flex justify-start font-400 text-3 leading-3 text-brand-tech-white']").click();
        Thread.sleep(1000);
        page.locator("[data-testid='createAccountButton']").click();
        Thread.sleep(1000);

        Thread.sleep(1000);
        page.getByLabel("First Name").fill("Fatih");
        page.getByLabel("Last Name").fill("Boncuk");
        page.getByLabel("Email Address").fill("myworkemail@gmail.com");
        Thread.sleep(1000);
        page.locator("#show-hide-password-toggle").click();
        page.locator("#fld-p1").fill("Benbir. P@55w0rdum");
        Thread.sleep(1000);
        page.locator("#show-hide-reenter-password-toggle").click();
        page.locator("#reenterPassword").fill("Benbir. P@55w0rdum");
        Thread.sleep(1000);
        page.locator("#phone").fill("1239876543");
        page.locator("#is-recovery-phone").check();
        Thread.sleep(2000);



        // LOCATOR ÖRNEKLERİ (Aynı kutuya isim girişi yapılması gerekiyor)
        // 1. getByRole
        // page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill("Fatih");

        // 2. getByLabel
        //page.getByLabel("First Name").fill("Fatih"); //getByLabel 1. öncelikle tercih edilir

        // 3. getByPlaceholder (bu formda placeholder boş ama örnek kullanım)
        //page.getByPlaceholder("First Name").fill("Fatih");

        // 4. getByText (label üzerinden dolaylı kullanım)
        //page.getByText("First Name")
        //.locator("..")
        //.locator("input")
        //.fill("Fatih");

        // 5. getByAltText (input için genelde kullanılmaz, sadece görüntü için)
        // Bu case'te uygun değil, ama örnek olsun diye:
        //page.getByAltText("First Name");

        // 6. getByTitle (bu formda yok, ama örnek)
        //page.getByTitle("First Name").fill("Fatih");

        // 7. getByTestId (HTML’de yok ama en stabil yöntem olurdu)
        // Eğer dev şöyle ekleseydi:
        // data-testid="first-name"
        //page.getByTestId("first-name").fill("Fatih");

        // 8. CSS selector (ID ile en net fallback)
        //page.locator("#firstName").fill("Fatih");

        // 9. XPath (en son çare)
        //page.locator("//input[@id='firstName']").fill("Fatih");


    }


    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }

}
