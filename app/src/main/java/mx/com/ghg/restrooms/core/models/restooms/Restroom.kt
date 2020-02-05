package mx.com.ghg.restrooms.core.models.restooms

data class Restroom(
  val id: Int,
  val name: String,
  val street: String,
  val city: String,
  val state: String,
  val accessible: Boolean,
  val unisex: Boolean,
  val directions: String,
  val comment: String,
  val latitude: Double?,
  val longitude: Double?,
  val created_at: String,
  val updated_at: String,
  val downvote: Int,
  val upvote: Int,
  val country: String,
  val changing_table: Boolean,
  val edit_id: Int,
  val approved: Boolean
)