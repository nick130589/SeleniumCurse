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
            ContactData contact = new ContactData().
                    withFirstName(generateRandomString()).
                    withLastName(generateRandomString()).
                    withAddress(generateRandomString()).
                    withHomePhone(generateRandomString()).
                    withMobilePhone(generateRandomString()).
                    withWorkPhone(generateRandomString()).
                    withFirstEmail(generateRandomEmail()).
                    withSecondEmail(generateRandomEmail()).
                    withDayOfBirthday("13").
                    withMonthOfBirthday("June").
                    withYearOfBirthday("1989").
                    withSecondAddress(generateRandomString()).
                    withSecondHomePhone(generateRandomString());
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
