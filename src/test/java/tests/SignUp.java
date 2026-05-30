package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignUp extends PlaywrightRunner{

    @Test
    public void signUpTest () throws InterruptedException {

        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("[class='flex justify-start font-400 text-3 leading-3 text-brand-tech-white']").click();
        Thread.sleep(1000);
        page.locator("[data-testid='createAccountButton']").click();
        Thread.sleep(1000);

        page.getByLabel("First Name").fill("Fatih");
        page.getByLabel("Last Name").fill("Boncuk");
        page.getByLabel("Email Address").fill("myworkemail@gmail.com");
        Thread.sleep(1000);
        page.locator("button#show-hide-password-toggle").click();
        page.locator("input#fld-p1").fill("Benbir. P@55w0rdum");
        Thread.sleep(1000);
        page.locator("button#show-hide-reenter-password-toggle").click();
        page.locator("input#reenterPassword").fill("Benbir. P@55w0rdum");
        Thread.sleep(1000);

        assertThat(page.locator("span.cdi-input-success-message"))
                .containsText("Your passwords match!");

        // youtube videoda timeout da eklenmiş ama gereksiz
        //assertThat(page.locator("span.cdi-input-success-message"))
        //        .containsText("Your passwords match!",new LocatorAssertions.ContainsTextOptions().setTimeout(30000));

        page.locator("#phone").fill("1239876543");
        page.locator("input#is-recovery-phone").check();
        Thread.sleep(2000);

        assertThat(page.locator("span.c-checkbox-brand")).isEnabled();

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

}
