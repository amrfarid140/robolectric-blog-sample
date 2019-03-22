package me.amryousef.robotest

import android.app.Dialog
import android.view.View
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.robolectric.shadows.ShadowAlertDialog

object TestAssertion {
    fun assertOnDialog(block: (View) -> Boolean) {
        val dialog = ShadowAlertDialog.getLatestDialog()
        assertNotNull(dialog)
        assertTrue(block(dialog.findViewById(android.R.id.content)))
    }
}