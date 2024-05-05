package com.kraft.tests.day_02.pac_01_multipleElements_checkbox_radio;

import com.kraft.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P04_checkbox_radio {

    @Test
    void test1(){
        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/checkboxes");

        Locator checkBox1 = page.locator("#box1");
        Locator checkBox2 = page.locator("#box2");

        System.out.println("before clicking box1: "+checkBox1.isChecked());
        System.out.println("before clicking box2: "+checkBox2.isChecked());
        BrowserUtils.sleepWithPage(page, 2);

        //checkBox1.click();
        //checkBox2.click();
        //checkbox ı seçmek için click() ten başka 2. bir method daha var. check()
        checkBox1.check();
        checkBox2.uncheck();


        System.out.println("after clicking box1: "+checkBox1.isChecked());
        System.out.println("after clicking box2: "+checkBox2.isChecked());


        BrowserUtils.sleepWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();
    }
}
