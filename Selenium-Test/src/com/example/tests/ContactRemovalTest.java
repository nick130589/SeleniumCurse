package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactRemovalTest extends TestBase {

    @Test
    public void deleteSomeContact(){
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContactData();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //action
        app.getContactHelper().deleteContact(index);

        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContactData();

        // compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }
}
