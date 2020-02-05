package mx.com.ghg.restrooms.core.api

import mx.com.ghg.restrooms.core.models.restooms.Restroom
import retrofit2.http.GET

interface RestroomService {

  @GET("restrooms.json")
  suspend fun getRestrooms(): List<Restroom>

}