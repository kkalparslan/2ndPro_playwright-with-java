package com.kraft.tests.day_01.pac_02_locators_getText_getttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlaywrightMethods {

    @Test
    void test() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://library2.cybertekschool.com/login.html");
        // Is there any differences between the frameLocators and Locators in the Documentaion page?

        page.getByPlaceholder("Email address").fill("incorrectemail.gmail.com");
        //Placeholder methodu casesensetive değil. hatta contains olarak da çalışıyor. Elementi
        //tam texte göre bulması isteniyorsa new Page.GetByPlaceholderOptions("") kullanılmalıdır.

        page.getByLabel("Password").fill("incorrectpassword");
        //page.querySelector("#inputPassword").fill("incorrectpassword"); başka bir locate etme
        //seçeneği querySelector dur. Tüm css, xpath ve diğer locate ler ile kullanılabilir.

       // page.getByRole(AriaRole.BUTTON).click();//tek aria role button varsa çalışır.
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")
                .setExact(true)).click();

        System.out.println(page.getByRole(AriaRole.ALERT).textContent());
        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();






    }
}
