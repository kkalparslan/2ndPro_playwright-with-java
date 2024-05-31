package com.kraft.tests.day_01.pac_02_locators_getText_getttribute;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P03_GoogleSearch {

    @Test
    void test(){
        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.google.com/");

        //Locator searchBox=page.locator("textarea[name='q']");
        Locator searchBox=page.locator("//textarea[@name='q']");
       // searchBox.type("Selenium"); search box vb yerlere 3 türlü veri gönderebiliriz
       // searchBox.fill("Selenium");
        searchBox.pressSequentially("Selenium",
                //put that statement to put delay between letters while writing
                new Locator.PressSequentiallyOptions()
                .setDelay(100));//setDelay yapmadan da sadece pressSequentially() methodunu kullanabiliriz.
        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");

        page.waitForTimeout(3000);

        page.close();
        browser.close();
        playwright.close();
    }
}

