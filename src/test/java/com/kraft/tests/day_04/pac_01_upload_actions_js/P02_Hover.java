package com.kraft.tests.day_04.pac_01_upload_actions_js;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_Hover {
    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/hovers");
    }

    @AfterEach
    void tearDown(){
        Driver.closeDriver();
    }

    @Test
    void test1(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 1);
        Driver.getPage().locator("img").nth(0).hover();
        BrowserUtils.sleepWithPage(Driver.getPage(), 2);
        Driver.getPage().locator("img").nth(1).hover();
        BrowserUtils.sleepWithPage(Driver.getPage(), 2);
        Driver.getPage().locator("img").nth(2).hover();
        BrowserUtils.sleepWithPage(Driver.getPage(), 2);
    }
}
