package nmpatel.docscanner.stackoverflowfilter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.QuestionListService
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.Results
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.repository.QuestionListRepository
import java.lang.Exception
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var dataRepository : QuestionListRepository

    @Inject
    lateinit var questionListService: QuestionListService

    fun getCurrentQuestionDataData() = liveData(Dispatchers.IO) {
        emit(Results.Loading)
        try {
            emit(Results.Success(dataRepository.getRecentQuestionList(questionListService)))
        } catch (exception : Exception){
            emit(Results.Error(exception))
        }
    }
}