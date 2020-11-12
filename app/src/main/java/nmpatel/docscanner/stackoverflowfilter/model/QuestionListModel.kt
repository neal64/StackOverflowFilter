package nmpatel.docscanner.stackoverflowfilter.model

import com.google.gson.annotations.SerializedName


data class QuestionListModel(
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("items")
    val items: ArrayList<Item>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
)