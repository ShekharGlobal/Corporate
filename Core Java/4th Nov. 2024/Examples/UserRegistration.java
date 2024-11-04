package com.coforge.exceptions;
public class UserRegistration {

    public void registerProfile(String userName, int age, String country) throws InvalidCountryException, InvalidAgeException {
        if (!"India".equals(country)) {
            throw new InvalidCountryException("User Outside India cannot be registered");
        }
        if (age < 18) {
            throw new InvalidAgeException("User is a Minor");
        }
        

        System.out.println("User " + userName + " from " + country + " with age " + age + " registered successfully.");
    }

    public static void main(String[] args) {
        UserRegistration userReg = new UserRegistration();
        try {
            userReg.registerProfile("John", 18, "US");
        } catch (InvalidCountryException ice) {
            System.out.println(ice.getMessage());
        } catch (InvalidAgeException iae) {
            System.out.println(iae.getMessage());
        }

        try {
            userReg.registerProfile("Vikram", 21, "India");
        } catch (InvalidCountryException ice) {
            System.out.println(ice.getMessage());
        } catch (InvalidAgeException iae) {
            System.out.println(iae.getMessage());
        }
    }
}