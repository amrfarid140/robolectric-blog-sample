package me.amryousef.robotest

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_text_view_with_button.dialog_button
import kotlinx.android.synthetic.main.activity_text_view_with_button.injectable_text
import javax.inject.Inject

class TextViewWithButtonActivity : AppCompatActivity() {

    @Inject
    lateinit var fakeDataProvider: FakeDataProivder

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view_with_button)
        injectable_text.text = fakeDataProvider.getFakeData()
        dialog_button.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("I am a test")
                .setMessage("Test passes if it can see this message")
                .setPositiveButton("OK") { dialog, _ -> dialog?.dismiss() }
                .show()
        }
    }
}
