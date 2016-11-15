package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContatcts;

/**
 * Created by Nick on 9/17/2016.
 */
public class TestBase {

    protected ApplicationManager app;

    @BeforeSuite
    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("D:\\Repositoriy\\SeleniumCurse\\Selenium-Test\\src\\application.properties")));
        app = new ApplicationManager(properties);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        return wrapGroupForDataProvider(generateRandomGroups(5)).iterator();
    }

    public static List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<>();
        for (GroupData group : groups) {
            list.add(new Object[]{group});
        }
        return list;
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
        return wrapContactForDataProvider(generateRandomContatcts(5)).iterator();
    }

    public static List<Object[]> wrapContactForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<>();
        for (ContactData contact : contacts) {
            list.add(new Object[]{contact});
        }
        return list;
    }
}
