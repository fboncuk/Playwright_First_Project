package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignUp extends PlaywrightRunner{


    @Test
    public void signUpTest () throws InterruptedException {

        CreateAccountPage createAccountPage = new CreateAccountPage(page);

        // Browser sayfasında işlem yapılır
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("[class='flex justify-start font-400 text-3 leading-3 text-brand-tech-white']").click();
        page.locator("[data-testid='createAccountButton']").click();
        Thread.sleep(1000);

        // CreateAccountPage sayfasındaki metotlar ile işlem yapılır
        createAccountPage.fillFirstName("BenimAdim");
        createAccountPage.fillLastName("BenimSoyadim");
        createAccountPage.fillEmail("BenimEmail@adresim.com");
        Thread.sleep(2000);

        createAccountPage.fillpassword1("Pa55w0rd.* 111");
        createAccountPage.clickViewBox1();
        Thread.sleep(2000);

        createAccountPage.fillpassword2("Pa55w0rd.* 111");
        createAccountPage.clickViewBox2();
        Thread.sleep(2000);

        assertThat(page.locator("span.cdi-input-success-message"))
                .containsText("Your passwords match!");

        createAccountPage.fillPhone("0613026899");
        Thread.sleep(2000);
        createAccountPage.setPhoneCheckBox();
        Thread.sleep(2000);

        System.out.println(page.locator("#is-recovery-phone").isChecked());

        createAccountPage.clickCreateAccount();
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

}
