package com.demoqa.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pageobject.components.CalendarComponent;
import com.demoqa.pageobject.components.ChooseStateCity;

import io.qameta.allure.Step;
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


    @Step ("Открываем страницу с формой")
    public Pageobject openPage() {
        open("/automation-practice-form");

        return new Pageobject();
    }

    @Step ("Заполняем имя")
    public Pageobject setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step ("Заполняем Фамилию")
    public Pageobject setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step ("Заполняем e-mail")
    public Pageobject setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    @Step ("Выбираем пол")
    public Pageobject chooseGender() {
        gender.click();

        return this;
    }
    @Step ("Вводим номер телефона")
    public Pageobject setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }
    @Step ("Заполняем дату рождения")
    public Pageobject setBirthDate(String month, String year) {
        calendarComponent.setDate(month, year);

        return this;
    }
    @Step ("Выбираем предмет")
    public Pageobject setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;
    }
    @Step ("Выбираем хобби")
    public Pageobject setHobbies() {
        $(byCssSelector("[for='hobbies-checkbox-1']")).click();
        $(byCssSelector("[for='hobbies-checkbox-2']")).click();

        return this;
    }
    @Step ("Загружем картинку")
    public Pageobject uploadPicture() {
        file.uploadFile(new File("src/test/resources/priemlemo.jpg"));

        return this;
    }
    @Step ("Вводим адрес")
    public Pageobject setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }
    @Step ("Выбираем штат и город")
    public Pageobject setStateCity(String state, String city) {
        chooseStateCity.setStateCity(state, city);

        return this;

    }
}
