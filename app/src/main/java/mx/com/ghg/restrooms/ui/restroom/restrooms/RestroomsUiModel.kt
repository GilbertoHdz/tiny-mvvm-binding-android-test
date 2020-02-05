package mx.com.ghg.restrooms.ui.restroom.restrooms

class RestroomsUiModel {

  sealed class RestroomsResult {
    object IsLoading : RestroomsResult()
    data class Succes(val items: List<RestroomItem>) : RestroomsResult()
    data class Failed(val message: String) : RestroomsResult()
    data class Error(val message: String) : RestroomsResult()
  }

  data class RestroomItem(
    val id: Int,
    val name: String,
    val city: String,
    val comment: String,
    val unisex: Boolean,
    val latitude: Double,
    val longitude: Double
  ) {

    fun showLocationInGoogleMaps(): String {
      return if (this.latitude > 0.0 && this.longitude > 0.0) {
        "have location, show maps to gatolandia!"
      } else {
        "don't have location..."
      }
    }

    fun commentValue(): String {
      return if (this.comment.isEmpty() || this.comment.isBlank()) "Sin comentarios" else this.comment
    }
  }
}