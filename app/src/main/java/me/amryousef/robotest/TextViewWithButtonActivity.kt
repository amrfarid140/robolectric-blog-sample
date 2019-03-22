package me.amryousef.robotest

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_text_view_with_button.dialog_button

class TextViewWithButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_with_button)

        dialog_button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("I am a test")
                .setMessage("Test passes if it can see this message")
                .setPositiveButton("OK") { dialog, _ -> dialog?.dismiss() }
                .show()
        }
    }
}
