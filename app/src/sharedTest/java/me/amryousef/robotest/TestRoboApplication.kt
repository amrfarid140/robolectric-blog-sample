package me.amryousef.robotest

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector

class TestRoboApplication : Application(), HasActivityInjector {

    lateinit var dispatchingAndroidInjector: AndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> =
        dispatchingAndroidInjector
}