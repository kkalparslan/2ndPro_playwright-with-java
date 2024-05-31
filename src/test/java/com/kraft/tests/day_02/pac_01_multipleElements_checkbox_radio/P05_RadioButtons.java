package com.kraft.tests.day_02.pac_01_multipleElements_checkbox_radio;

import com.kraft.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P05_RadioButtons {

    @Test
    void test1(){
        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/radio_buttons");

        //page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Red")).click();
        //burada çalışmamasının nedeni label ile input tag i arasında connection olmamasıdır.
        //<div class="radio">
        //    <input type="radio" id="red" name="color">
        //    <label class="form-check-label">Red</label> aşağıdaki hockey de olduğu gibi for"hockey" olmaması
        //  </div>

        //<div class="radio">
        //    <input type="radio" id="hockey" name="sport">
        //    <label class="form-check-label" for="hockey">Hockey</label> label tag lerinde id yada inputtaki isme atfı yoksa
        //  </div>

        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Hockey")).click();
        //page.getByText("Water Polo").click();

        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
