package me.amryousef.robotest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import me.amryousef.robotest.RoboApplication

@Component(
    modules = [
    ApplicationModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: RoboApplication)
}