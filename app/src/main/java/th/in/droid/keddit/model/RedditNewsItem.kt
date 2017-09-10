package th.`in`.droid.keddit.model

import th.`in`.droid.keddit.adapter.AdapterConstants
import th.`in`.droid.keddit.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.NEWS
}