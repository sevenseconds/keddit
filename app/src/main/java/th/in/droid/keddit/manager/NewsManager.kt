package th.`in`.droid.keddit.manager

import io.reactivex.Observable
import th.`in`.droid.keddit.model.RedditNews
import th.`in`.droid.keddit.model.RedditNewsItem
import th.`in`.droid.keddit.service.RestApi

class NewsManager(private val api: RestApi = RestApi()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val dataResponse = response.body()?.data
                val news = dataResponse?.children?.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }
                if (news != null) {
                    val redditNews = RedditNews(
                            dataResponse.after ?: "",
                            dataResponse.before ?: "",
                            news
                    )
                    subscriber.onNext(redditNews)
                    subscriber.onComplete()
                }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}