package mx.com.ghg.restrooms.ui.restroom.restrooms.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.com.ghg.restrooms.R
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsViewModel
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsUiModel.RestroomItem

class RestroomAdapter(
  private val viewModel: RestroomsViewModel
): RecyclerView.Adapter<RestroomHolder>() {

  private val items = mutableListOf<RestroomItem>()

  fun ViewGroup.inflate(
    layoutResId: Int
  ): View = LayoutInflater.from(this.context).inflate(layoutResId, this, false)

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): RestroomHolder = RestroomHolder(parent.inflate(R.layout.restroom_restrooms_item))

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: RestroomHolder, position: Int) {
    holder.bindTo(items[position], viewModel)
  }

  fun updateData(restrooms: List<RestroomItem>) {
    items.clear()
    items.addAll(restrooms)
    notifyDataSetChanged()
  }
}
