package me.amryousef.robotest

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
// This breaks how the test is platform agnostic.
// Depending on Robolectric APIs restricts it to only running on JVM.
// It won't be able to run on ART
//import org.robolectric.shadows.ShadowAlertDialog

@RunWith(AndroidJUnit4::class)
class TextViewWithButtonActivityTest {

    private lateinit var activityScenario: ActivityScenario<TextViewWithButtonActivity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(TextViewWithButtonActivity::class.java)
    }

    @Test
    fun checkFirstTextHasText() {
        onView(withId(R.id.first_text)).check(matches(withText("This is first text")))
    }

    @Test
    fun checkSecondTextIsInvisible() {
        onView(withId(R.id.second_text)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)))
    }

    /**
     * This test will fail due to a bug in Robolectric 4 and the way it mocks Android.
     * The dialog is not visible to Espresso matchers so that test fails.
     * If we used Robolectric API (ShadowAlertDialog) the test passes.
     *
     * It breaks what Robolectric 4 promises. write once and run on ART (Android run-time) and JVM.
     * What can we do about it ?
     */
    @Test
    @Ignore("It's just a demonstration of failure")
    fun whenButtonClickedThenDialogIsShown_failing() {
        onView(withId(R.id.dialog_button)).perform(click())
        /**
         * This Passes on Robolectric (JVM) but doesn't allow the test to run on ART
         */
//        assertTrue(ShadowAlertDialog.getLatestDialog().isShowing)
        /**
         * This Fails on Robolectric (JVM) but works on ART
         */
//        onView(withId(android.R.id.button1)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
//        onView(withText("Test passes if it can see this message")).check(matches(isDisplayed()))
    }

    /**
     * Now I abstracted how I get the dialog and assert it's visible.
     * Created TestAssertion helper which is implemented differently in test and androidTest folder.
     * It means the test itself works on both ART and JVM.
     */
    @Test
    fun whenButtonClickedThenDialogIsShown_passing() {
        onView(withId(R.id.dialog_button)).perform(click())
        TestAssertion.assertOnDialog {
            it.findViewById<TextView>(android.R.id.message).text.toString() == "Test passes if it can see this message"
                && it.findViewById<TextView>(android.R.id.message).isVisible
        }
    }
}
