package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Nick on 9/17/2016.
 */
public class GroupRemovalTest extends TestBase {
    @Test
    public void deleteSomeGroup(){
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //action
        app.getGroupHelper().deleteGroup(index);


        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        assertThat(newList, equalTo(oldList.without(index)));
    }
}
