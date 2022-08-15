package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.pageobject.Pageobject;

import com.demoqa.pageobject.components.ResultModal;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class SuccesSubmit {
    public Pageobject pageobject = new Pageobject();
    public ResultModal resultModal = new ResultModal();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillForm() {
        pageobject.openPage()
                .setFirstName("Семен")
                .setLastName("Кучма")
                .setEmail("test@test.ru")
                .chooseGender()
                .setUserNumber("9516547825")
                .setBirthDate("December", "1995")
                .setSubject("Math")
                .setHobbies()
                .uploadPicture()
                .setCurrentAddress("com.demoqa.test address")
                .setStateCity("Haryana", "Karnal");
        resultModal.checkTitle()
                .checkResult("Семен Кучма")
                .checkResult("test@test.ru")
                .checkResult("Male")
                .checkResult("9516547825")
                .checkResult("26 December,1995")
                .checkResult("Math")
                .checkResult("Sports, Reading")
                .checkResult("priemlemo.jpg")
                .checkResult("com.demoqa.test address")
                .checkResult("Haryana Karnal");
    }

    @AfterAll
    static void closing() {
        closeWebDriver();
    }

}

