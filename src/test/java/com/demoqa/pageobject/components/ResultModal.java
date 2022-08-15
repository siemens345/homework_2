package com.demoqa.pageobject.components;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultModal checkTitle() {
        $(".modal-header").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultModal checkResult(String value) {
        $(".modal-body").$(byText(value));

        return this;
    }
}
