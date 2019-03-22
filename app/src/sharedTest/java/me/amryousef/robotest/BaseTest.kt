package me.amryousef.robotest

abstract class BaseTest {

    val uiAssertions : UiTestAssertions by lazy {
        Class.forName(
            if (isART()) {
                "me.amryousef.robotest.InstrumentationTestAssertion"
            } else {
                "me.amryousef.robotest.UnitTestAssertion"
            }
        ).newInstance() as UiTestAssertions
    }

    private fun isART() = System.getProperty("java.runtime.name")?.toLowerCase()?.contains("android") == true
    
}