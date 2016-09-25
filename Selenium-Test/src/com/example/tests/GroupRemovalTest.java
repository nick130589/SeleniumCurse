package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Nick on 9/17/2016.
 */
public class GroupRemovalTest extends TestBase {
    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().deleteGroup(1);
        app.getGroupHelper().returnToGroupsPage();
    }
}
