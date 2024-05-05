package com.kraft.tests.day_02.pac_02_dropdowns;

import com.kraft.utils.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;

public class P02_DropdownSelectOption {

    @Test
    public void test1(){
        Playwright playwright= Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/dropdown");

        Locator yearDropdown = page.locator("#year");
        Locator monthDropdown = page.locator("#month");
        Locator dayDropdown = page.locator("#day");

        String expectedYear="1979";
        String expectedMonth="April";
        int expectedDay=1;

        BrowserUtils.sleepWithPage(page,2);

        //select with value
        yearDropdown.selectOption(new SelectOption().setValue(expectedYear));
        BrowserUtils.sleepWithThread(2);

        //select with text/label
        monthDropdown.selectOption(new SelectOption().setLabel(expectedMonth));
        BrowserUtils.sleepWithThread(2);

        //select with index
        dayDropdown.selectOption(new SelectOption().setIndex(expectedDay-1));
        BrowserUtils.sleepWithThread(2);

        String actualYear=page.evaluate("el=>el.selectedOptions[0].text",yearDropdown
                .elementHandle()).toString();
        String actualMonth=page.evaluate("el=>el.selectedOptions[0].text",monthDropdown
                .elementHandle()).toString();
        String actualDay=page.evaluate("el=>el.selectedOptions[0].text",dayDropdown
                .elementHandle()).toString();

        System.out.println("actualYear = " + actualYear);
        System.out.println("actualMonth = " + actualMonth);
        System.out.println("actualDay = " + actualDay);

        page.close();
        browser.close();
        playwright.close();
    }
}
