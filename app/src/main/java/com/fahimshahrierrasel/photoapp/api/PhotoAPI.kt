package com.fahimshahrierrasel.photoapp.api

import com.fahimshahrierrasel.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by fahim on 29/9/17.
 */
interface PhotoAPI {
    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&image_type=photo")
    fun getPhotoJSONByCategory(@Query("category") category: String): Call<PhotoList>
}
