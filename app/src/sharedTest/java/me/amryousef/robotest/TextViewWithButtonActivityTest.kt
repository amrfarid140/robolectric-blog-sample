package me.amryousef.robotest

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextViewWithButtonActivityTest : BaseTest() {

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

    @Test
    fun whenButtonClickedThenDialogIsShown_passing() {
        onView(withId(R.id.dialog_button)).perform(click())
        uiAssertions.assertOnDialog {
            it.findViewById<TextView>(android.R.id.message).text.toString() == "Test passes if it can see this message"
                && it.findViewById<TextView>(android.R.id.message).isVisible
        }
    }

    @Test
    fun injectableTextHasInjectedData() {
        onView(withId(R.id.injectable_text)).check(matches(withText("I am a fake message")))
    }
}
