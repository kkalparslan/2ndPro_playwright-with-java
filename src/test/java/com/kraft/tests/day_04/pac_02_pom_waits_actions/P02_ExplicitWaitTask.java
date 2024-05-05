package com.kraft.tests.day_04.pac_02_pom_waits_actions;

import com.kraft.pages.DynamicPage;
import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_ExplicitWaitTask {
    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_loading/7");
    }

    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        DynamicPage dynamicPage=new DynamicPage();
        Driver.getPage().waitForFunction("document.title==='Dynamic title'");
        //function ekleyerek yaparsak daha güzel bir yöntem olur
        //BrowserUtils.sleepWithPage(Driver.getPage(), 6); //böyle de geçer ama iyi bir yöntem değil.
        System.out.println("dynamicPage = " + dynamicPage.getAlertMessage().textContent());
        Assertions.assertTrue(dynamicPage.getAlertMessage().textContent().contains("Done"));


    }
}
