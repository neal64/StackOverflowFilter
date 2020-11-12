package nmpatel.docscanner.stackoverflowfilter

object AppConstant {

    const val BASE_URL = "https://api.stackexchange.com/2.2/"
    const val QUE_LIST_END_URL = "/search/advanced?order=desc&sort=activity&accepted=True&site=stackoverflow"
    const val ANSWER_MORE_THAN = "2"

    fun getCurrentTimeInUnixTime() : String {
       return  (System.currentTimeMillis() /1000L).toString()
    }

}