package com.example.task1anagramsapplication

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith





@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {
    @Rule
    lateinit var scenario: ActivityScenario<MainActivity>
    @Test
    fun ensureTextChangesWork() {
        scenario = ActivityScenario.launch(startIntent
        )
        // Type text and then press the button.
        Espresso.onView(withId(R.id.wordEditText))
            .perform(ViewActions.typeText("HELLO"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.convertButton)).perform(click())

        // Check that the text was changed.
        Espresso.onView(withId(R.id.wordEditText)).check(matches(withText("HELLO")))
    }

    @Test
    fun changeTextVerifyWithTextView() {
        // Type text and then press the button.
        Espresso.onView(withId(R.id.wordEditText)).perform(
            ViewActions.typeText("NewText"),
            closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.convertButton)).perform(click())

        // This view is in a different Activity, no need to tell Espresso.
        Espresso.onView(withId(R.id.displayTextView)).check(matches(withText("NewText")))
    }
    companion object {

        private lateinit var startIntent: Intent
        @BeforeClass
        @JvmStatic
        fun setup() {
            startIntent =
                Intent(
                    ApplicationProvider.getApplicationContext(),
                    MainActivity::class.java
                )
        }
    }
}