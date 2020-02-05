package mx.com.ghg.restrooms.core.interactors

import mx.com.ghg.restrooms.core.api.RestroomService
import mx.com.ghg.restrooms.core.models.restooms.Restroom
import retrofit2.HttpException
import javax.inject.Inject

class GetRestroomsInteractor @Inject constructor(
  private val restroomService: RestroomService
) {

  suspend fun restrooms(): Result {
    return try {
      val request = restroomService.getRestrooms()
      Result.Success(request)
    } catch (e: Exception) {
      e.printStackTrace()
      return when (e) {
        is HttpException -> {
          when (e.code()) {
            in 300..400 -> Result.Failed("network_or_backend_result_error")
            else -> Result.Failed("network_unknown_error")
          }
        }
        else -> Result.Error(e, "server_error")
      }
    }
  }

  sealed class Result {
    data class Success(val restrooms: List<Restroom>): Result()
    data class Failed(val message: String): Result()
    data class Error(val e: Exception, val message: String): Result()
  }
}