package me.amryousef.robotest

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import dagger.android.AndroidInjector

abstract class BaseTest<T : Activity>(private val activityClass: Class<T>) {

    private lateinit var activityScenario: ActivityScenario<T>

    fun setupActivity() {
        ApplicationProvider.getApplicationContext<TestRoboApplication>()
            .dispatchingAndroidInjector = AndroidInjector { instance ->
            setupActivityDependencies(instance as T)
        }

        activityScenario = ActivityScenario.launch(activityClass)
    }
    
    val uiAssertions: UiTestAssertions by lazy {
        Class.forName(
            if (isART()) {
                "me.amryousef.robotest.InstrumentationTestAssertion"
            } else {
                "me.amryousef.robotest.UnitTestAssertion"
            }
        ).newInstance() as UiTestAssertions
    }

    abstract fun setupActivityDependencies(activity: T)

    private fun isART() = System.getProperty("java.runtime.name")?.toLowerCase()?.contains("android") == true
}