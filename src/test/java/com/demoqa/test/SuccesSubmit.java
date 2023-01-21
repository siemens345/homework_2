package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import com.demoqa.pageobject.Attechments;
import com.demoqa.pageobject.Pageobject;
import com.demoqa.pageobject.components.ResultModal;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.demoqa.pageobject.testData.Data.*;


public class SuccesSubmit {
    public Pageobject pageobject = new Pageobject();
    public ResultModal resultModal = new ResultModal();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillForm() {
        pageobject.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGender()
                .setUserNumber(number)
                .setBirthDate(month, year)
                .setSubject(subject)
                .setHobbies()
                .uploadPicture()
                .setCurrentAddress(address)
                .setStateCity(state, city);
        resultModal.checkTitle()
                .checkResult(fullName)
                .checkResult(email)
                .checkResult(gender)
                .checkResult(number)
                .checkResult(birthDate)
                .checkResult(subject)
                .checkResult(hobbies)
                .checkResult(picture)
                .checkResult(address)
                .checkResult(stateCity);
        Attechments.addVideo();
    }

    @AfterAll
    static void closing() {
        closeWebDriver();

    }


}

