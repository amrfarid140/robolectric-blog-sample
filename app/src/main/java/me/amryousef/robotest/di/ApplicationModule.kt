package me.amryousef.robotest.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.amryousef.robotest.FakeDataProivder
import me.amryousef.robotest.FakeDataProviderImpl
import me.amryousef.robotest.TextViewWithButtonActivity

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun bindFakeDataProvider(provider: FakeDataProviderImpl): FakeDataProivder

    @ContributesAndroidInjector
    abstract fun contributeTextViewWithButtonActivity(): TextViewWithButtonActivity
}