package mx.com.ghg.restrooms

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import mx.com.ghg.restrooms.di.AppModule
import mx.com.ghg.restrooms.di.DaggerAppComponent
import javax.inject.Inject

class RestroomsApp: Application(), HasActivityInjector, HasSupportFragmentInjector {

  @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate() {
    super.onCreate()

    DaggerAppComponent
      .builder()
      .appModule(AppModule(this))
      .build()
      .inject(this)
  }

  /** Returns an [AndroidInjector] of [Activity]s.  */
  override fun activityInjector(): AndroidInjector<Activity> = activityInjector

  /** Returns an [AndroidInjector] of [Fragment]s.  */
  override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}