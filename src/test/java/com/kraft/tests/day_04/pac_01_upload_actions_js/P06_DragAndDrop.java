package com.kraft.tests.day_04.pac_01_upload_actions_js;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P06_DragAndDrop {

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/drag_and_drop_circles");
    }

    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        //draggable
        Locator source = Driver.getPage().getByTestId("draggable");
        Locator target = Driver.getPage().getByTestId("droptarget");
        System.out.println("before darag and drop = " + target.textContent());
        source.dragTo(target);
        BrowserUtils.sleepWithPage(Driver.getPage(), 1);
        System.out.println("after drag and drop = " + target.textContent());

        Assertions.assertEquals("You did great!", target.textContent());



    }
}
