package nmpatel.docscanner.stackoverflowfilter.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("accepted_answer_id")
    val acceptedAnswerId: Int,
    @SerializedName("answer_count")
    val answerCount: Int,
    @SerializedName("creation_date")
    val creationDate: Int,
    @SerializedName("is_answered")
    val isAnswered: Boolean,
    @SerializedName("title")
    val title: String,
    @SerializedName("view_count")
    val viewCount: Int
)