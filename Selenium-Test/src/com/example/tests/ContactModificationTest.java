package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactModificationTest extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modificationSomeContact(ContactData contact){
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContactData();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //action
        app.getContactHelper().initContactModification(index);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        //save new state
        List<ContactData> newList = app.getContactHelper().getContactData();

        // compare states
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
