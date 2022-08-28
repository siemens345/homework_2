package com.demoqa.pageobject.testData;

import com.github.javafaker.Faker;

public class Data {
    static Faker faker = new Faker();
    static public String firstName = faker.name().firstName();
    static public String lastName = faker.name().firstName();
    static public String email = faker.internet().emailAddress();
    static public String number = faker.phoneNumber().subscriberNumber(10);
    static public String month = "December";
    static public String year = "1995";
    static public String address = faker.address().fullAddress();
    static public String subject = "Math";
    static public String state = "Haryana";
    static public String city = "Karnal";
    static public String fullName = firstName+" "+lastName;
    static public String gender = "Male";
    static public String hobbies = "Sports, Reading";
    static public String picture = "priemlemo.jpg";
    static public String stateCity = state+" "+city;
    static public String birthDate = "26 December,1995";

}
