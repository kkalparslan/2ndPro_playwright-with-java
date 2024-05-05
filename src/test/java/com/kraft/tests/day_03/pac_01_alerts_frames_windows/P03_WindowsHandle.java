package com.kraft.tests.day_03.pac_01_alerts_frames_windows;

import com.kraft.utils.BrowserUtils;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P03_WindowsHandle {

    static  private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        // .setHeadless(false).setSlowMo(1000) do not usse with window handle or use with promise
        );
    }

    @AfterAll
    static void afterAll(){
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp(){
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    void tearDown(){
        page.close();
    }

    @Test
    public void test1(){
        //page.pause();

        //get the title
        System.out.println("before clicking page title = " + page.title());

        //click the Click here button (it will open another window)
        //page.click("text=Click Here");

        //get second window title
        BrowserUtils.sleepWithPage(page, 2);
        Page secondPage = page.waitForPopup(() -> {
            page.getByText("Click Here").click();
        });

        System.out.println("after clicking button secondPage title = " + secondPage.title());
        BrowserUtils.sleepWithPage(page, 2);

        //go back to first page
        page.bringToFront();
        BrowserUtils.sleepWithPage(page, 2);
        secondPage.bringToFront();
        BrowserUtils.sleepWithPage(page, 2);
        page.bringToFront();

        //click home
        page.locator("");

        //get the title again

    }
}
