package com.demoqa.pageobject.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ChooseStateCity {
    public ChooseStateCity setStateCity(String state, String city) {
        $(By.id("state")).click();
        $(byText(state)).click();
        $(By.id("city")).click();
        $(byText(city)).click();
        $(By.id("submit")).click();

        return this;
    }
}
