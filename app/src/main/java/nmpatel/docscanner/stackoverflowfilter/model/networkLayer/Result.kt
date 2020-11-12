package nmpatel.docscanner.stackoverflowfilter.model.networkLayer

sealed class Results<out T : Any> {
    data class Success<out T : Any>(val data: T) : Results<T>()
    data class Error(val exception: Exception) : Results<Nothing>()
    object Loading : Results<Nothing>()
}