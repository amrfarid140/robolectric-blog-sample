package me.amryousef.robotest

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import junit.framework.Assert.assertTrue

class InstrumentationTestAssertion : UiTestAssertions {
    override fun assertOnDialog(block: (View) -> Boolean) {
        onView(withId(android.R.id.button1)).check(matches(isDisplayed()))
        onView(withId(android.R.id.content)).check { view, _ ->
            assertTrue(block(view))
        }
    }
}