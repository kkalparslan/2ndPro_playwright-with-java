package com.kraft.tests.day_01.pac_02_locators_getText_getttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P02_ClickLinkWithText {

    @Test
    void test(){

        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");
        //Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //int width = (int) dimension.getWidth();
        //int height = (int) dimension.getHeight();
        //page.setViewportSize(width, height);

        page.click("text=Drag and Drop Circles");

        page.waitForTimeout(2000);

        System.out.println("page.title() = " + page.title());

        page.close();
        browser.close();
        playwright.close();
    }
}
