package com.demoqa.pageobject.components;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    @Step("Проверяем заголовок окна")
    public ResultModal checkTitle() {
        $(".modal-header").shouldHave(text(TITLE_TEXT));

        return this;
    }
    @Step ("Проверям что данные в окне совпадют с введеными ранее")
    public ResultModal checkResult(String value) {
        $(".modal-body").$(byText(value));

        return this;
    }
}
