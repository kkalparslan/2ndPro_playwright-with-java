package com.kraft.tests.day_02.pac_02_dropdowns;

import com.kraft.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P01_Dropdowns {

    @Test
    public void test1(){
        Playwright playwright= Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/dropdown");

        //github dan alınacak eksiklikler


        BrowserUtils.sleepWithPage(page, 3);

        page.close();
        browser.close();
        playwright.close();
    }
}
