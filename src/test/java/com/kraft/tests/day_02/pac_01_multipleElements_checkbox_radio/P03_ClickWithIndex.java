package com.kraft.tests.day_02.pac_01_multipleElements_checkbox_radio;

import com.kraft.utils.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_ClickWithIndex {
    @Test
    public void test1(){
        Playwright playwright=Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");

       // page.locator(".container li a").first().click();
        //page.locator(".container li a").nth(2).click();
        page.locator(".container li a").last().click();

        List<ElementHandle>elementHandles=page.querySelectorAll(".container li a");



        BrowserUtils.sleepWithPage(page, 3);

        page.close();
        browser.close();
        playwright.close();
    }
}
