package mx.com.ghg.restrooms.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val mApplication: Application) {

  @Provides
  @Singleton
  fun provideApplication(): Application {
    return mApplication
  }

  @Provides
  @Singleton
  fun provideContext(): Context {
    return mApplication
  }
}