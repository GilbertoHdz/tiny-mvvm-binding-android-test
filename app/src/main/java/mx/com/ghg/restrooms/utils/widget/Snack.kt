package mx.com.ghg.restrooms.utils.widget

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import mx.com.ghg.restrooms.R

object Snack {

  fun snackError(view: View, error: String) {
    view.let {
      val snackbar = Snackbar.make(it, error, Snackbar.LENGTH_LONG)
      snackbar.setAction("Cerrar") { snackbar.dismiss() }
      snackbar.view.setBackgroundColor(view.context.resources.getColor(android.R.color.holo_red_dark))
      snackbar.setActionTextColor(view.context.resources.getColor(android.R.color.white))
      val tv = snackbar.view.findViewById(R.id.snackbar_text) as TextView
      tv.setTextColor(Color.WHITE)
      val button = snackbar.view.findViewById<Button>(com.google.android.material.R.id.snackbar_action)
      button.transformationMethod = null
      (snackbar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView).maxLines = 5
      snackbar.show()
    }
  }
}