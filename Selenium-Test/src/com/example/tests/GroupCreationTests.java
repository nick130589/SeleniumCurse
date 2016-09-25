package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //action
        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
