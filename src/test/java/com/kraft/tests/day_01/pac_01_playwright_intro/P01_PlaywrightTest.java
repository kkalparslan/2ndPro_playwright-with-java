package com.kraft.tests.day_01.pac_01_playwright_intro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P01_PlaywrightTest {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        //default mode headless dır. burada headless modu false yaparak headed modu açmış olduk
        Page page = browser.newPage(); //page objesi en önemli objemiz
        page.navigate("https://www.google.com/");
        Thread.sleep(3000);

        page.close();
        browser.close();
        playwright.close(); //açılan tüm sayfa, browser ve playwright objelerini kapatmamız gerekiyor
    }
}
