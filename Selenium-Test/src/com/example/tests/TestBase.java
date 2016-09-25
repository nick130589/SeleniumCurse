package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.util.*;

/**
 * Created by Nick on 9/17/2016.
 */
public class TestBase {

    protected ApplicationManager app;

    @BeforeSuite
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        List<Object[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ContactData contact = new ContactData();
            contact.firstName = generateRandomString();
            contact.lastName = generateRandomString();
            contact.address = generateRandomString();
            contact.homePhone = generateRandomString();
            contact.mobilePhone = generateRandomString();
            contact.workPhone = generateRandomString();
            contact.firstEmail = generateRandomEmail();
            contact.secondEmail = generateRandomEmail();
            contact.dayOfBirthday = "13";
            contact.monthOfBirthday = "June";
            contact.yearOfBirthday = "1989";
            //contact.relatedGroup = "Group1";
            contact.secondAddress = generateRandomString();
            contact.secondHomePhone = generateRandomString();
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomString() {
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0) {
            return "";
        } else {
            return "test" + rnd.nextInt();
        }
    }

    private  String generateRandomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }


}
