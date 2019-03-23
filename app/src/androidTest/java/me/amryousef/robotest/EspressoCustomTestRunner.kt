package me.amryousef.robotest

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class EspressoCustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestRoboApplication::class.java.name, context)
    }
}