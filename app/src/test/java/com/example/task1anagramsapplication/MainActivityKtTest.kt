package com.example.task1anagramsapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityKtTest {
    private var presenter : ReversePresenter? = null

    //method getMainLooper in android.os.looper not mocked.
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        presenter = ReversePresenter()
    }

    @Test
    fun testReverseStringSwap() {
        assertEquals(presenter?.reverse("abcd",""), "dcba")
        assertNotEquals(presenter?.reverse("abcd",""), "dcbb")
    }

    @Test
    fun testReverseStringMaintainingCharactersPostion() {
        assertEquals(presenter?.reverse("fooks20","20"), "skoof20")
        assertNotEquals(presenter?.reverse("fooks20","20"), "20skoof")
        assertNotEquals(presenter?.reverse("s1ma","a1"), "20skoof")
       // assertEquals(presenter?.reverse("Foxminded cool 24/7","0123456789"), "dednimxoF looc 24/7")
    }

    @Test
    fun testReverseStringEmptyUserInput() {
        assertEquals(presenter?.reverse("",""), "")
    }

}
