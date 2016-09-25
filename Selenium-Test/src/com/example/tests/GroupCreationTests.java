package com.example.tests;

import org.testng.annotations.Test;

import java.util.List;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //action
        app.getGroupHelper().initNewGroupCreation();
        GroupData group = new GroupData();
        group.name = "group name 1";
        group.header = "heder 1";
        group.footer = "footer 1";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        //save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        assertEquals(newList.size(), oldList.size() + 1);
    }

  //  @Test
    public void testEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initNewGroupCreation();
        GroupData group = new GroupData("", "", "");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
    }

}
