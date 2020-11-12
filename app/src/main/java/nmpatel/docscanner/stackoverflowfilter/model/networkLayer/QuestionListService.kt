package nmpatel.docscanner.stackoverflowfilter.model.networkLayer

import nmpatel.docscanner.stackoverflowfilter.AppConstant
import nmpatel.docscanner.stackoverflowfilter.model.QuestionListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionListService {

    @GET(AppConstant.QUE_LIST_END_URL)
    suspend fun getQuestions(@Query ("todate") currentTime : String, @Query("answers") answersCount : String) : QuestionListModel

}