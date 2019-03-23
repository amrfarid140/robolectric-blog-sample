package me.amryousef.robotest

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextViewWithButtonActivityTest : BaseTest<TextViewWithButtonActivity>(
    TextViewWithButtonActivity::class.java
) {

    private val mockDataProvider = mock<FakeDataProivder>()

    @Before
    fun setup() {
        whenever(mockDataProvider.getFakeData()).thenReturn("I am a mock")
        setupActivity()
    }

    override fun setupActivityDependencies(activity: TextViewWithButtonActivity) {
        activity.fakeDataProvider = mockDataProvider
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
        onView(withId(R.id.injectable_text)).check(matches(withText("I am a mock")))
    }
}
