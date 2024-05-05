package com.kraft.tests.day_04.pac_01_upload_actions_js;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_ScrollPractice {
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
    void test1(){
        //first scroll with js
        BrowserUtils.sleepWithPage(Driver.getPage(), 2);

        //scroll down 500 pixel
        //Driver.getPage().evaluate("() => {window.scrollBy(0, 500);}");
        //BrowserUtils.sleepWithPage(Driver.getPage(), 2);

        //scroll up 500 pixel
        //Driver.getPage().evaluate("() => {window.scrollBy(0, -500);}");

        //scroll bottom thisi is by javascript
        //Driver.getPage().evaluate("() => {window.scrollBy(0, 3*window.innerHeight);}");

        //using mouse
        Driver.getPage().mouse().wheel(0, 1000);
        BrowserUtils.sleepWithPage(Driver.getPage(), 1);
        Driver.getPage().mouse().wheel(0, -500);

    }
}
