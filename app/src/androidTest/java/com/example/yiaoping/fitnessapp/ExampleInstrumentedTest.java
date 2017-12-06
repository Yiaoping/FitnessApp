package com.example.yiaoping.fitnessapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.yiaoping.fitnessapp", appContext.getPackageName());
    }
    @Test
    public void checkInputData() {
        onView(withId(R.id.radioButton)).perform(click());
        /*onView(withId(R.id.editText5)).perform(typeText("225"), closeSoftKeyboard());
        onView(withId(R.id.editText6)).perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.editText5)).check(matches(withText("")));
        onView(withId(R.id.editText6)).check(matches(withText("")));*/

    }

    public void checkCalcMax(){
        onView(withId(R.id.radioButton2)).perform(click());
        onView(withId(R.id.editText)).perform(typeText("225"), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editTextMax)).check(matches(withText("238")));
    }

    public void startStopWatch(){
        onView(withId(R.id.radioButton4)).perform(click());
        onView(withId(R.id.timerValue)).check(matches(withText("0:00:001")));
        onView(withId(R.id.btnStart)).perform(click());
        onView(withId(R.id.btnLap)).perform(click());
        onView(withId(R.id.btnLap)).perform(click());
        onView(withId(R.id.btnStop)).perform(click());
        onView(withId(R.id.timerValue)).check(matches(not(withText("0:00:000"))));

    }


}
