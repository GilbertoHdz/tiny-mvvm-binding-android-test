package mx.com.ghg.restrooms.ui.restroom.restrooms

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import mx.com.ghg.restrooms.core.interactors.GetRestroomsInteractor
import mx.com.ghg.restrooms.core.interactors.GetRestroomsInteractor.Result as GetRestroomResult
import mx.com.ghg.restrooms.ui.restroom.restrooms.RestroomsUiModel.RestroomsResult
import javax.inject.Inject

class RestroomsViewModel @Inject constructor(
  private val getRestroomsInteractor: GetRestroomsInteractor
) : ViewModel() {

  private val supervisorJob = SupervisorJob()
  private val ioContext = Dispatchers.IO + supervisorJob

  val restroomsResult: MutableLiveData<RestroomsResult?> = MutableLiveData(RestroomsResult.IsLoading)

  fun loadRestrooms() {
    CoroutineScope(ioContext).launch {
      val result = getRestroomsInteractor.restrooms()
      restroomsResult.postValue(transformGetRestroomsResult(result))
    }
  }

  private fun transformGetRestroomsResult(
    result: GetRestroomResult
  ): RestroomsResult {
    return when (result) {
      is GetRestroomResult.Success -> {
        val items = result.restrooms.map { restroom ->
          RestroomsUiModel.RestroomItem(
            id = restroom.id,
            name = restroom.name,
            city = restroom.city,
            comment = restroom.comment,
            unisex = restroom.unisex,
            latitude = restroom.latitude ?: 0.0,
            longitude = restroom.longitude ?: 0.0
          )
        }

        RestroomsResult.Succes(items)
      }
      is GetRestroomResult.Failed -> RestroomsResult.Failed(result.message)
      is GetRestroomResult.Error -> RestroomsResult.Error(result.message)
    }
  }

  fun restroomClicked(restroomsUiModel: RestroomsUiModel.RestroomItem) {
    // do stuff
  }

  override fun onCleared() {
    super.onCleared()
    if (supervisorJob.isActive) {
      supervisorJob.cancelChildren()
    }
  }
}
