package com.demoqa.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pageobject.components.CalendarComponent;
import com.demoqa.pageobject.components.ChooseStateCity;

import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class Pageobject {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ChooseStateCity chooseStateCity = new ChooseStateCity();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $(byCssSelector("[for='gender-radio-1']")),
            userNumber = $(By.id("userNumber")),
            subject = $(By.id("subjectsInput")),
            file = $(By.id("uploadPicture")),
            currentAddress = $(By.id("currentAddress"));


    public Pageobject openPage() {
        open("/automation-practice-form");

        return new Pageobject();
    }

    public Pageobject setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public Pageobject setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public Pageobject setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public Pageobject chooseGender() {
        gender.click();

        return this;
    }

    public Pageobject setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public Pageobject setBirthDate(String month, String year) {
        calendarComponent.setDate(month, year);

        return this;
    }

    public Pageobject setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;
    }

    public Pageobject setHobbies() {
        $(byCssSelector("[for='hobbies-checkbox-1']")).click();
        $(byCssSelector("[for='hobbies-checkbox-2']")).click();

        return this;
    }

    public Pageobject uploadPicture() {
        file.uploadFile(new File("src/test/resources/priemlemo.jpg"));

        return this;
    }

    public Pageobject setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public Pageobject setStateCity(String state, String city) {
        chooseStateCity.setStateCity(state, city);

        return this;

    }
}
