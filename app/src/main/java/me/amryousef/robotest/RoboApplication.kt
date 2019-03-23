package me.amryousef.robotest

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.amryousef.robotest.di.DaggerApplicationComponent
import javax.inject.Inject

class RoboApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().application(this)
            .build().inject(this)
    }

    override fun activityInjector() =
        dispatchingActivityInjector
}