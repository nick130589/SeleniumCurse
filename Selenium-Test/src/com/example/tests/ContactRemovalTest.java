package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactRemovalTest extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().deleteContact(1);
        app.getContactHelper().returnToHomePage();
    }
}
