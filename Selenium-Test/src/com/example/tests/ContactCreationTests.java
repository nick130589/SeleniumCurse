package com.example.tests;


import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        //return wrapContactForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
        return wrapContactForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
    }


    @Test(dataProvider = "contactsFromFile")
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
