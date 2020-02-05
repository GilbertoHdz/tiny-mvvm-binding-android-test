package mx.com.ghg.restrooms.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import mx.com.ghg.restrooms.RestroomsApp
import mx.com.ghg.restrooms.core.api.ApiModule
import mx.com.ghg.restrooms.ui.restroom.RestroomModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetModule::class,
    ApiModule::class,
    ViewModelModule::class,
    RestroomModule::class
  ]
)
interface AppComponent: AndroidInjector<RestroomsApp> {}