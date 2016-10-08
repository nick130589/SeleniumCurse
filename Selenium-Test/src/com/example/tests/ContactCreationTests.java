package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContactData();

        //action
        app.getContactHelper().createContact(contact);
        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContactData();

        // compare states
        assertThat(newList, equalTo(oldList.withAdded(contact)));
    }
}
