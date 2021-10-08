package com.example.task1anagramsapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {
    @get:Rule
    val scenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyUserInputEditText() {
        // Type text and then press the button.
        Espresso.onView(withId(R.id.wordEditText))
            .perform(ViewActions.typeText("HELLO"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.convertButton)).perform(click())

        // Check that the text was changed.
        Espresso.onView(withId(R.id.wordEditText)).check(matches(withText("HELLO")))
    }
    fun verifyEscapeCharacterEditText() {
        // Type text and then press the button.
        Espresso.onView(withId(R.id.wordEditTextEscapechars))
            .perform(ViewActions.typeText("HELLO"), closeSoftKeyboard())
        Espresso.onView(withId(R.id.convertButton)).perform(click())

        // Check that the text was changed.
        Espresso.onView(withId(R.id.wordEditTextEscapechars)).check(matches(withText("HELLO")))
    }

    @Test
    fun changeTextVerifyWithTextView() {
        // Type text and then press the button.
        Espresso.onView(withId(R.id.wordEditText)).perform(
            ViewActions.typeText("NewText"),
            closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.convertButton)).perform(click())
        //notice that the string is reversed in caps
        Espresso.onView(withId(R.id.displayTextView)).check(matches(withText("TXETWEN")))
    }

    @Test
    fun veryEmptyTextVerifyWithTextView() {
        // Type text and then press the button.
        Espresso.onView(withId(R.id.wordEditText)).perform(
            ViewActions.typeText(""),
            closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.convertButton)).perform(click())
        //notice that the string is reversed in caps
        Espresso.onView(withId(R.id.displayTextView)).check(matches(withText("INVALID INPUT")))
    }
}