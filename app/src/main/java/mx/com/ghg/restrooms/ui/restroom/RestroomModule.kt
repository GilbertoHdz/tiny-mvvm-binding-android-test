package mx.com.ghg.restrooms.ui.restroom

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import mx.com.ghg.restrooms.di.ViewModelKey
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsFragment
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsViewModel

@Module
abstract class RestroomModule {

  @ContributesAndroidInjector
  internal abstract fun contributeRestroomsFragment(): RestroomsFragment

  @Binds
  @IntoMap
  @ViewModelKey(RestroomsViewModel::class)
  internal abstract fun bindRestroomsViewModule(restroomsViewModel: RestroomsViewModel): ViewModel
}