package mx.com.ghg.restrooms.ui.restroom.restrooms.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import mx.com.ghg.restrooms.databinding.RestroomRestroomsItemBinding
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsUiModel.RestroomItem
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsViewModel

class RestroomHolder(
  itemView: View
): RecyclerView.ViewHolder(itemView) {

  private val binding = RestroomRestroomsItemBinding.bind(itemView)

  fun bindTo(
    uiModel: RestroomItem,
    viewModel: RestroomsViewModel
  ) {
    binding.item = uiModel
    binding.viewmodel = viewModel
  }
}
