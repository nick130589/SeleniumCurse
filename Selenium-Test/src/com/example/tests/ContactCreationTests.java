package com.example.tests;


import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        ContactData contactData = new ContactData();
        contactData.firstName = "First name1";
        contactData.lastName = "Last name 2";
        contactData.address = "Address";
        contactData.homePhone = "1";
        contactData.mobilePhone = "2";
        contactData.workPhone =  "3";
        contactData.firstEmail = "n@mail.ru";
        contactData.secondEmail = "n@mail.ru";
        contactData.dayOfBirthday = "13";
        contactData.monthOfBirthday = "June";
        contactData.yearOfBirthday = "1989";
        contactData.relatedGroup = "Group 1";
        contactData.secondAddress = "Addres2";
        contactData.secondHomePhone = "home";
        app.getContactHelper().fillContactForm(contactData);
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        ContactData contactData = new ContactData();
        contactData.firstName = "";
        contactData.lastName = "";
        contactData.address = "";
        contactData.homePhone = "";
        contactData.mobilePhone = "";
        contactData.workPhone =  "";
        contactData.firstEmail = "";
        contactData.secondEmail = "";
        contactData.dayOfBirthday = "-";
        contactData.monthOfBirthday = "-";
        contactData.yearOfBirthday = "";
        contactData.relatedGroup = "";
        contactData.secondAddress = "";
        contactData.secondHomePhone = "";
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}
