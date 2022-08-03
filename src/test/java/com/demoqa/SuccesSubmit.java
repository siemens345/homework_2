package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class SuccesSubmit {

   @BeforeAll
   static void configure(){
       Configuration.baseUrl="https://demoqa.com";
       Configuration.browser = "chrome";
       Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillForm (){
       open("/automation-practice-form");
        $(By.id("firstName")).setValue("Семен");
        $(By.id("lastName")).setValue("Кучма");
        $(By.id("userEmail")).setValue("test@test.ru");
        $(byCssSelector("[for='gender-radio-1']")).click();
        $(By.id("userNumber")).setValue("9516547825");
        $(By.id("dateOfBirthInput")).click();
        $(byCssSelector("[class='react-datepicker__month-select']")).click();
        $(byCssSelector("[class='react-datepicker__month-select']")).selectOption("December");
        $(byCssSelector("[class='react-datepicker__year-select']")).click();
        $(byCssSelector("[class='react-datepicker__year-select']")).selectOption("1995");
        $(byCssSelector("[class='react-datepicker__day react-datepicker__day--026']")).click();
        $(By.id("subjectsInput")).setValue("Math").pressEnter();
        $(byCssSelector("[for='hobbies-checkbox-1']")).click();
        $(byCssSelector("[for='hobbies-checkbox-2']")).click();
        $(By.id("uploadPicture")).uploadFile(new File("src/test/resources/priemlemo.jpg"));
        $(By.id("currentAddress")).setValue("test address");
        $(By.id("state")).click();
        $(byText("Haryana")).click();
        $(By.id("city")).click();
        $(byText("Karnal")).click();
        $(By.id("submit")).click();
        $(byCssSelector("[class='modal-header']")).shouldHave(text("Thanks for submitting the form"));
        $(byCssSelector("[class='modal-body']")).shouldHave(
             text("Семен Кучма"),
             text("test@test.ru"),
             text("Male"),
             text("9516547825"),
             text("26 December,1995"),
             text("Math"),
             text("Sports, Reading"),
             text("priemlemo.jpg"),
             text("test address"),
             text("Haryana Karnal")
     );
    }

    @AfterAll
 static void closing(){
    closeWebDriver();
    }

}

