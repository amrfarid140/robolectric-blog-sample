package me.amryousef.robotest.helpers
import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import javax.inject.Provider

object UiTestInjection {

//    fun createActivityInjector(
//        factoryMap: Map<Class<out Activity>, AndroidInjector.Factory<Activity>>
//    ): DispatchingAndroidInjector<Activity> {
//
//        val map = HashMap<Class<out Activity>, Provider<AndroidInjector.Factory<out Activity>>>()
//        for (entry in factoryMap) {
//            map[entry.key] = Provider<AndroidInjector.Factory<out Activity>> { entry.value }
//        }
//        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
//    }

//    fun createBroadcastReceiverInjector(
//        factoryMap: Map<Class<out BroadcastReceiver>, AndroidInjector.Factory<BroadcastReceiver>>
//    ): DispatchingAndroidInjector<BroadcastReceiver> {
//
//        val map = HashMap<Class<out BroadcastReceiver>, Provider<AndroidInjector.Factory<out BroadcastReceiver>>>()
//        for (entry in factoryMap) {
//            map[entry.key] = Provider<AndroidInjector.Factory<out BroadcastReceiver>> { entry.value }
//        }
//        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
//    }
//
//    fun createServiceInjector(
//        factoryMap: Map<Class<out Service>, AndroidInjector.Factory<Service>>
//    ): DispatchingAndroidInjector<Service> {
//        val map = HashMap<Class<out Service>, Provider<AndroidInjector.Factory<out Service>>>()
//        for (entry in factoryMap) {
//            map[entry.key] = Provider<AndroidInjector.Factory<out Service>> { entry.value }
//        }
//        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
//    }
//
//    fun createSupportFragmentInjector(
//        factoryMap: Map<Class<out Fragment>, AndroidInjector.Factory<Fragment>>
//    ): DispatchingAndroidInjector<Fragment> {
//
//        val map = HashMap<Class<out Fragment>, Provider<AndroidInjector.Factory<out Fragment>>>()
//        for (entry in factoryMap) {
//            map[entry.key] = Provider<AndroidInjector.Factory<out Fragment>> { entry.value }
//        }
//        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
//    }

//    fun createActivityInjector(
//        activityClass: Class<out Activity>,
//        injector: AndroidInjector.Factory<Activity>
//    ): DispatchingAndroidInjector<Activity> {
//        return createActivityInjector(mapOf(activityClass to injector))
//    }
}