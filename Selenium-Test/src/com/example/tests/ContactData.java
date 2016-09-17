package com.example.tests;

public class ContactData {
    public String firstName;
    public String lastName;
    public String address;
    public String homePhone;
    public String mobilePhone;
    public String workPhone;
    public String firstEmail;
    public String secondEmail;
    public String dayOfBirthday;
    public String monthOfBirthday;
    public String yearOfBirthday;
    public String relatedGroup;
    public String secondAddress;
    public String secondHomePhone;

    public ContactData() {
    }

    public ContactData(String firstName, String lastName, String address, String homePhone, String mobilePhone, String workPhone, String firstEmail, String secondEmail, String dayOfBirthday, String monthOfBirthday, String yearOfBirthday, String relatedGroup, String secondAddress, String secondHomePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.dayOfBirthday = dayOfBirthday;
        this.monthOfBirthday = monthOfBirthday;
        this.yearOfBirthday = yearOfBirthday;
        this.relatedGroup = relatedGroup;
        this.secondAddress = secondAddress;
        this.secondHomePhone = secondHomePhone;
    }
}
