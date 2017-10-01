package com.fahimshahrierrasel.photoapp.api

import com.fahimshahrierrasel.photoapp.models.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by fahim on 29/9/17.
 */
class PhotoRetriever {
    private val service: PhotoAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(PhotoAPI::class.java)
    }

    fun getPhotoByCategory(category: String, callback: Callback<PhotoList>){
        val call = service.getPhotoJSONByCategory(category)
        call.enqueue(callback)
    }
}
