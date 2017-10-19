package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by thisobeystudio on 19/10/17.
 * Copyright: (c) 2017 ThisObey Studio
 * Contact: thisobeystudio@gmail.com
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndPointAsyncTaskTest implements AsyncResponse {

    private CountDownLatch signal;
    private String joke;

    @Test
    public void testGetJokeAsyncTask() throws Throwable {

        int countDownCount = 1;
        signal = new CountDownLatch(countDownCount);

        EndpointsAsyncTask endPointAsyncTask = new EndpointsAsyncTask();
        endPointAsyncTask.delegate = this;
        endPointAsyncTask.execute();

        int secondsToAwait = 20;
        signal.await(secondsToAwait, TimeUnit.SECONDS);

        assertNotNull("Joke is NULL", joke);
        assertFalse("Joke is EMPTY", joke.isEmpty());

    }

    @Override
    public void processFinish(String output) {
        this.joke = output;
        signal.countDown();
    }

}
