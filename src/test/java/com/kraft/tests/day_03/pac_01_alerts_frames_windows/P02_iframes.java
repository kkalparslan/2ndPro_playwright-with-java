package com.kraft.tests.day_03.pac_01_alerts_frames_windows;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P02_iframes {

    static  private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setSlowMo(1000));
    }

    @AfterAll
    static void afterAll(){
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp(){
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/frames");
    }

    @AfterEach
    void tearDown(){
        page.close();
    }

    @Test
    public void test1(){

    }
}
