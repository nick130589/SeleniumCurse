package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void modificationSomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(1);
        ContactData contactData = new ContactData();
        contactData.firstName = "Cat";
        app.getContactHelper().fillContactForm(contactData);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
