package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class FirstTest extends PlaywrightRunner {

    @Test
    public void firstTest() throws InterruptedException {

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
}
