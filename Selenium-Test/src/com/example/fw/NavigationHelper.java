package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by Nick on 9/17/2016.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/");
    }

    public void goToGroupsPage() {
        click(By.linkText("groups"));
    }
}
