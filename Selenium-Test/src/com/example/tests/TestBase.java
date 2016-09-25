package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

}
