package com.kraft.utils;

import com.microsoft.playwright.Page;

public class CRMUtils {

    public static void login(Page page){
        page.locator("//input[@name='USER_LOGIN']").fill("invalid@gmail.com");
        page.getByPlaceholder("Password").fill("invalidpassword");
        page.locator(".login-btn").click();
    }

    public static void login(Page page, String username, String password){
        page.locator("//input[@name='USER_LOGIN']").fill(username);
        page.getByPlaceholder("Password").fill(password);
        page.locator(".login-btn").click();
    }
}
