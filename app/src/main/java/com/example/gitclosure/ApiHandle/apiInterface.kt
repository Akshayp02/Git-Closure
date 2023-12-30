package com.example.gitclosure.ApiHandle

import com.example.gitclosure.Models.ApiModel.myData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val ISSUES_ENDPOINT = "/issues"
        const val PER_PAGE = 20
    }

    @GET("$ISSUES_ENDPOINT?state=closed&per_page=$PER_PAGE")
    fun getIssuesData(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<myData.myDataItem>>

    @GET("search/issues?state=closed&per_page=$PER_PAGE")
    fun getSearchData(
        @Query("q") q: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<myData.myDataItem>>

}
