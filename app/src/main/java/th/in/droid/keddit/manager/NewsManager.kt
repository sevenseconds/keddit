package th.`in`.droid.keddit.manager

import io.reactivex.Observable
import th.`in`.droid.keddit.model.RedditNewsItem

class NewsManager {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->
            val news = (1..10).map {
                RedditNewsItem(
                        "author$it",
                        "Title $it",
                        it, // number of comments
                        1457207701L - it * 200, // time
                        "http://lorempixel.com/200/200/technics/$it", // image url
                        "url"
                )
            }
            subscriber.onNext(news)
        }
    }
}