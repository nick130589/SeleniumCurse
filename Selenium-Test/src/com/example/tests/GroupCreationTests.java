package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        goToGroupsPage();
        initNewGroupCreation();
        GroupData group = new GroupData();
        group.name = "group name 1";
        group.header = "heder 1";
        group.footer = "footer 1";
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        openMainPage();
        goToGroupsPage();
        initNewGroupCreation();
        GroupData group = new GroupData("", "", "");
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

}
