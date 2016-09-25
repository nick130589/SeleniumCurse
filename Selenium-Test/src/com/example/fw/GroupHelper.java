package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 9/17/2016.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initNewGroupCreation() {
        click(By.name("new"));
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name);
        type(By.name("group_header"), group.header);
        type(By.name("group_footer"), group.footer);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    private void selectGroupByIndex(int index) {
        click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> checkBoxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkBox : checkBoxes)
        {
            GroupData group = new GroupData();
            String title = checkBox.getAttribute("title");
            group.name = title.substring("Select (".length(), title.length() - ")".length());
            groups.add(group);
        }
        return groups;
    }
}
