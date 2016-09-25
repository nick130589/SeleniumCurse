package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactRemovalTest extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.navigateTo().mainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContactData();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //action
        app.getContactHelper().deleteContact(index);
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContactData();

        // compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
