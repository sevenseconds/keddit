package th.`in`.droid.keddit.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import th.`in`.droid.keddit.dto.response.RedditNewsRespons

interface RedditApiService {
    @GET("/top.json")
    fun getTop(@Query("after") after: String, @Query("limit") limit: String): Call<RedditNewsRespons>
}