package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Nick on 9/17/2016.
 */
public class GroupModificationGroup extends TestBase {

    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }
}
