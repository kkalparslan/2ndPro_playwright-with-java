package com.kraft.pages;

import com.kraft.utils.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class DynamicPage {

    private final Locator alertMessage;

    public DynamicPage(){
        this.alertMessage= Driver.getPage().getByTestId("alert");
    }
}
