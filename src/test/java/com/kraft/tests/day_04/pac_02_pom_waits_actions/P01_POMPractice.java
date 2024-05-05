package com.kraft.tests.day_04.pac_02_pom_waits_actions;

import com.kraft.pages.LibraryLoginPage;
import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_POMPractice {

    LibraryLoginPage libraryLoginPage;

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://library1.cydeo.com");
        libraryLoginPage=new LibraryLoginPage();
    }

    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithPage(Driver.getPage(), 3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        libraryLoginPage.login("invalid", "invalid");

    }

    @Test
    void test2() {
        libraryLoginPage.getEmailInput().fill("invalid");
        libraryLoginPage.getPasswordInput().fill("invalid");
        libraryLoginPage.getSignInButton().click();
    }
}
