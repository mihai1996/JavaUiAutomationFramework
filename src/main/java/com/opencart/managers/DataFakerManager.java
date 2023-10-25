package com.opencart.managers;

import com.github.javafaker.Faker;

public class DataFakerManager {

    private static Faker fakerObj = new Faker();

    public static String generateFakeEmail(String prefix, String sufix) {
        String randomMidPart = String.valueOf(fakerObj.random().nextInt(1, 9999999));
        return prefix + randomMidPart + sufix;
    }

    public static String generateFakeEmail() {
        return fakerObj.internet().emailAddress();
    }

    public static String generateFakeFirstName() {
        return fakerObj.name().firstName();
    }

    public static String generateFakeLastName() {
        return fakerObj.name().lastName();
    }

    public static String generateFakePassword(){
        return fakerObj.internet().password();
    }
}
