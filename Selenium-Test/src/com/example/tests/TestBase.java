package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static com.example.tests.ContactDataGenerator.generateRandomContatcts;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;

/**
 * Created by Nick on 9/17/2016.
 */
public class TestBase {

    protected ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(new File(configFile)));
        app = new ApplicationManager(properties);
    }

    @AfterTest
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
