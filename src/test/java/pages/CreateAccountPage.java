package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CreateAccountPage {

    private final Page page;

    // Locator isimleri tanımlanır
    private final Locator firstName;
    private final Locator lastName;
    private final Locator email;
    private final Locator phone;
    private final Locator createAccountButton;
    private final Locator password1;
    private final Locator viewBox1;
    private final Locator password2;
    private final Locator viewBox2;
    private final Locator setPhoneCheckBox;

    // Constructor tanımlanır
    public CreateAccountPage (Page page) throws InterruptedException {
        this.page = page;

        // Locatorlar atanır
        this.firstName = page.getByLabel("First Name");
        this.lastName = page.getByLabel("Last Name");
        this.email = page.locator("input#email");
        this.password1 = page.locator("input#fld-p1");
        this.viewBox1 = page.locator("button#show-hide-password-toggle");
        this.password2 = page.locator("input#reenterPassword");
        this.viewBox2 = page.locator("button#show-hide-reenter-password-toggle");

        this.phone = page.locator("input#phone");
        this.setPhoneCheckBox = page.locator("input#is-recovery-phone");
        this.createAccountButton = page.locator("button[type='submit']");
    }

    // Her bir locator için fill/click metotları hazırlanır
    public void fillFirstName(String value) { firstName.fill(value); }
    public void fillLastName(String value) {
        lastName.fill(value);
    }
    public void fillEmail(String value) {
        email.fill(value);
    }

    public void fillpassword1(String value) { password1.fill(value); }
    public void clickViewBox1() { viewBox1.click(); }
    public void fillpassword2(String value) { password2.fill(value); }
    public void clickViewBox2() { viewBox2.click(); }

    public void fillPhone(String value) {
        phone.fill(value);
    }
    public void setPhoneCheckBox() { setPhoneCheckBox.check(); }
    public void clickCreateAccount() {
        System.out.println(createAccountButton.innerText()); }



}

