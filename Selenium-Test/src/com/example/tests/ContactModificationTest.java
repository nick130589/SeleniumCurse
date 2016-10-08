package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactModificationTest extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
    public void modificationSomeContact(ContactData contact){
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContactData();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //action
        app.getContactHelper().modifyContact(index, contact);
        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContactData();

        // compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
    }
}
