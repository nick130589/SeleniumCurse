package com.example.fw;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Nick on 9/17/2016.
 */
public class ContactHelper extends HelperBase {

    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    private SortedListOf<ContactData> cachedContacts;

    public SortedListOf<ContactData> getContactData() {
        if (cachedContacts == null)
        {
            rebuildCache();
        }
        return cachedContacts;
    }

    private void rebuildCache() {
        cachedContacts = new SortedListOf<>();

        manager.navigateTo().mainPage();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");

            String firstName = title.substring("Select (".length(), title.indexOf(" ", "Select (".length()));
            String lastName = title.substring("Select (".length() + firstName.length() + 1, title.length() - " ".length());
            cachedContacts.add(new ContactData()
                    .withFirstName(firstName)
                    .withLastName(lastName));
        }
    }

    public ContactHelper createContact(ContactData contact) {
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact, CREATION);
        submitContactCreation();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper deleteContact(int index) {
        selectContactByIndex(index);
        editContactByIndex(index);
        submitContactDeletion();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper modifyContact(int index, ContactData contact) {
        manager.navigateTo().mainPage();
        initContactModification(index);
        fillContactForm(contact, MODIFICATION);
        submitContactModification();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    //------------------------------------------------------------------------------------------------------------

    public ContactHelper fillContactForm(ContactData contactData, boolean formType) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getFirstEmail());
        type(By.name("email2"), contactData.getSecondEmail());
        selectByText(By.name("bday"), contactData.getDayOfBirthday());
        selectByText(By.name("bmonth"), contactData.getMonthOfBirthday());
        type(By.name("byear"), contactData.getYearOfBirthday());
        if (formType = CREATION) {
            //selectByText(By.name("new_group"), "group 1");
        } else {
            if (driver.findElements(By.name("new_group")).size() != 0) {
                throw new Error("Group selector exists in contact modification form");
            }
            //selectByText(By.name("new_group"), contactData.relatedGroup);
        }
        type(By.name("address2"), contactData.getSecondAddress());
        type(By.name("phone2"), contactData.getSecondHomePhone());
        return this;
    }

    public ContactHelper initContactCreation() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        cachedContacts = null;
        return this;
    }

    public ContactHelper returnToHomePage() {
        click(By.linkText("home page"));
        return this;
    }

    private ContactHelper submitContactDeletion() {
        click(By.xpath("(//input[@name='update'])[2]"));//button delete
        cachedContacts = null;
        return this;
    }

    private void selectContactByIndex(int index) {
        click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]//input[@name='selected[]']"));
    }

    private void editContactByIndex(int index) {
        click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]//img[@ alt = 'Edit']"));

    }

    public ContactHelper initContactModification(int index) {
        manager.navigateTo().mainPage();
        selectContactByIndex(index);
        editContactByIndex(index);
        return this;
    }

    public ContactHelper submitContactModification() {
        click(By.xpath("(//input[@name='update'])[1]"));//button update
        cachedContacts = null;
        return this;
    }


}
