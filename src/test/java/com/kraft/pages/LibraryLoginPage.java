package com.kraft.pages;

import com.kraft.utils.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;


@Getter

public class LibraryLoginPage {

    //coming from lombok. getter methodlarını otomatik initial etmiş oluyor.
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator signInButton;

    public LibraryLoginPage() {
        this.emailInput = Driver.getPage().locator("#inputEmail");
        this.passwordInput = Driver.getPage().locator("#inputPassword");
        this.signInButton = Driver.getPage().getByText("Sign in");
    }


    /**
     *public Locator getEmailInput() {
     *      return emailInput;
     *      }
     *
     *      public Locator getPasswordInput() {
     *      return passwordInput;
     *      }
     *
     *      public Locator getSignInButton() {
     *      return signInButton;
     *      }
     */


    public void login(String email, String password){
        emailInput.fill(email);
        passwordInput.fill(password);
        signInButton.click();
    }
}
