package com.kraft.tests.day_04.pac_01_upload_actions_js;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P05_ScrollIntoView {

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/");
    }

    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        //normalde Playwright kendisi scrool işlemini yapıyor, ama bir hazır nethod daha var aşağıdaki gibi.
        ElementHandle cydeoLink = Driver.getPage().querySelector("text=CYDEO");
        ElementHandle homeLink = Driver.getPage().querySelector("text=Home");

        BrowserUtils.sleepWithPage(Driver.getPage(), 2);
        cydeoLink.scrollIntoViewIfNeeded();
        BrowserUtils.sleepWithPage(Driver.getPage(), 2);
        homeLink.scrollIntoViewIfNeeded();
    }
}
