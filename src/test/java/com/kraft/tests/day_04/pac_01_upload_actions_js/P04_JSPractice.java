package com.kraft.tests.day_04.pac_01_upload_actions_js;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P04_JSPractice {

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/infinite_scroll");
    }

    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        for (int i = 0; i < 10; i++) {
            Driver.getPage().evaluate("window.scrollBy(0, 500)");
            BrowserUtils.sleepWithPage(Driver.getPage(), 1);
        }
    }
}
