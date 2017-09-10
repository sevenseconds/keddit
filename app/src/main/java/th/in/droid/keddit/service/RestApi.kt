package th.`in`.droid.keddit.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import th.`in`.droid.keddit.dto.response.RedditNewsRespons

class RestApi {
    private val redditApiService: RedditApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        redditApiService = retrofit.create(RedditApiService::class.java)
    }

    fun getNews(after: String, limit: String): Call<RedditNewsRespons> {
        return redditApiService.getTop(after, limit)
    }
}