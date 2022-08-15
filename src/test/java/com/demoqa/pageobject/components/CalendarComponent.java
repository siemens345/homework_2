package com.demoqa.pageobject.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byCssSelector;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public CalendarComponent setDate(String month, String year) {
        $(By.id("dateOfBirthInput")).click();
        $(byCssSelector("[class='react-datepicker__month-select']")).click();
        $(byCssSelector("[class='react-datepicker__month-select']")).selectOption(month);
        $(byCssSelector("[class='react-datepicker__year-select']")).click();
        $(byCssSelector("[class='react-datepicker__year-select']")).selectOption(year);
        $(byCssSelector("[class='react-datepicker__day react-datepicker__day--026']")).click();
        return this;
    }

}
