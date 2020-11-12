package nmpatel.docscanner.stackoverflowfilter.model.networkLayer.repository

import nmpatel.docscanner.stackoverflowfilter.AppConstant
import nmpatel.docscanner.stackoverflowfilter.model.QuestionListModel
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.QuestionListService

class QuestionListRepository{

    suspend fun getRecentQuestionList(questionListService: QuestionListService): QuestionListModel {
        return questionListService.getQuestions (AppConstant.getCurrentTimeInUnixTime(), AppConstant.ANSWER_MORE_THAN)
    }
}