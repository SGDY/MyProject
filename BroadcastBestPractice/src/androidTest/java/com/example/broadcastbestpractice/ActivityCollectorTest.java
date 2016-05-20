package com.example.broadcastbestpractice;

import android.test.AndroidTestCase;

import com.example.broadcastbestpractice.activity.LoginActivity;

/**
 * Created by sg
 * Created Time 2015/3/29 19:25
 * Description
 */
public class ActivityCollectorTest extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testAddActivity() {
        assertEquals(0, ActivityCollector.activities.size());
        LoginActivity loginActivity = new LoginActivity();
        ActivityCollector.addActivity(loginActivity);
        assertEquals(1, ActivityCollector.activities.size());
        ActivityCollector.addActivity(loginActivity);
        assertEquals(1, ActivityCollector.activities.size());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
