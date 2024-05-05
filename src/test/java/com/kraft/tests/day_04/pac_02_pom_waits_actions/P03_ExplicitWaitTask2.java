package com.kraft.tests.day_04.pac_02_pom_waits_actions;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_ExplicitWaitTask2 {

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_controls");
    }

    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 3);
        Driver.closeDriver();
    }

    @Test
    void test1(){
        //Driver.getPage().locator("//button[text()='Remove']").click();
        Driver.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                .setName("Remove")).click();

    }
}
