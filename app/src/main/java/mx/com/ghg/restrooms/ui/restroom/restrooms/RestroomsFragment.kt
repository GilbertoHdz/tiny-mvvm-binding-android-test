package mx.com.ghg.restrooms.ui.restroom.restrooms

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import mx.com.ghg.restrooms.databinding.RestroomRestroomsFragmentBinding
import mx.com.ghg.restrooms.ui.restroom.restrooms.view.RestroomAdapter
import javax.inject.Inject

class RestroomsFragment : Fragment() {

  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

  private lateinit var viewModel: RestroomsViewModel
  private lateinit var binding: RestroomRestroomsFragmentBinding

  companion object {
    fun newInstance() = RestroomsFragment()
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = provideViewModel().apply {
      val fragment = this@RestroomsFragment
      loadRestrooms()

      /* do stuff, some observer action/state from view model */
      // liveDummy.observe(fragment, dummyStateObserver)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = RestroomRestroomsFragmentBinding.inflate(inflater, container, false)
    binding.viewmodel = viewModel
    binding.lifecycleOwner = viewLifecycleOwner
    return binding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    // config view state
    configureRecyclerView()
  }

  private fun configureRecyclerView() {
    binding.restroomRestroomsItemsRecycler.adapter = RestroomAdapter(viewModel)
  }

  private fun provideViewModel(): RestroomsViewModel {
    return ViewModelProviders.of(this, viewModelFactory).get(RestroomsViewModel::class.java)
  }
}
