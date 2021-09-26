package com.example.task1anagramsapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityKtTest {
    var main: MainActivity? = null

    //I got an error
    //method getmainlooper in android.os.looper not mocked.
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        main = MainActivity()
    }

    @Test
    fun testReverseStringSwap() {
        assertEquals(main?.reverse("abcd"), "dcba")
        assertNotEquals(main?.reverse("abcd"), "dcbb")
    }

    @Test
    fun testReverseStringMaintainingCharactersPosttion() {
        assertEquals(main?.reverse("fooks20"), "skoof20")
        assertNotEquals(main?.reverse("fooks20"), "20skoof")
        assertEquals(main?.reverse("34$"), "34$")
    }

    @Test
    fun testReverseStringEmptyUserInput() {
        assertEquals(main?.reverse(""), "")
    }

}
