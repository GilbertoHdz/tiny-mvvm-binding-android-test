package mx.com.ghg.restrooms.ui.restroom.restrooms.view

import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsUiModel.RestroomsResult
import mx.com.ghg.restrooms.utils.widget.Snack.snackError

object RestroomBinding {

  @BindingAdapter("app:items")
  @JvmStatic fun setItems(
    recyclerView: RecyclerView,
    result: RestroomsResult?
  ) {
    with(recyclerView.adapter as RestroomAdapter) {
      if (result is RestroomsResult.Succes) {
        updateData(result.items)
      }
    }
  }

  @BindingAdapter("app:showSnackMessages")
  @JvmStatic fun showSnackMessages(view: ConstraintLayout, result: RestroomsResult?) {
    if (result is RestroomsResult.Error) {
      view.let {
        // TODO(change code text error for typed error defined)
        snackError(it, result.message)
      }
    } else if (result is RestroomsResult.Failed) {
      snackError(view, result.message)
    }
  }

  @BindingAdapter("app:showProgress")
  @JvmStatic fun showProgress(progress: ProgressBar, result: RestroomsResult?) {
    progress.isVisible = result is RestroomsResult.IsLoading
  }
}
