package me.amryousef.robotest

import android.view.View

interface UiTestAssertions {
    fun assertOnDialog(block: (View) -> Boolean)
}