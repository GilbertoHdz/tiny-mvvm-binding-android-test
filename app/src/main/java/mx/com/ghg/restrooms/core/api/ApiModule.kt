package mx.com.ghg.restrooms.core.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

  @Provides
  @Singleton
  fun provideRestroomService(retrofit: Retrofit): RestroomService {
    return retrofit.create(RestroomService::class.java)
  }
}
