package me.amryousef.robotest

import android.view.View
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.robolectric.shadows.ShadowAlertDialog

class UnitTestAssertion : UiTestAssertions {
    override fun assertOnDialog(block: (View) -> Boolean) {
        val dialog = ShadowAlertDialog.getLatestDialog()
        assertNotNull(dialog)
        assertTrue(block(dialog.findViewById(android.R.id.content)))
    }
}