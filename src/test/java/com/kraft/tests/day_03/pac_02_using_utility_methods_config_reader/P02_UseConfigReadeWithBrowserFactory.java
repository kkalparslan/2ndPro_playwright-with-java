package com.kraft.tests.day_03.pac_02_using_utility_methods_config_reader;

import com.kraft.utils.CRMUtils;
import com.kraft.utils.ConfigurationReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P02_UseConfigReadeWithBrowserFactory {

    static  private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll(){
        playwright = Playwright.create();
        String browserFromConfig = ConfigurationReader.getProperty("browser");
        switch (browserFromConfig){
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
        }
    }

    @AfterAll
    static void afterAll(){
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp(){
        page = browser.newPage();
        page.navigate("https://login2.nextbasecrm.com/");
    }

    @AfterEach
    void tearDown(){
        page.close();
    }

    @Test
    public void test1(){
        CRMUtils.login(page);
    };
}

