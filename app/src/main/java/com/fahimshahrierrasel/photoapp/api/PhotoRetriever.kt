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

    fun getNaturePhotos(callback: Callback<PhotoList>){
        val call = service.getNaturePhotos()
        call.enqueue(callback)
    }

    fun getBackgroundsPhotos(callback: Callback<PhotoList>){
        val call = service.getBackgroundPhotos()
        call.enqueue(callback)
    }

    fun getSciencePhotos(callback: Callback<PhotoList>){
        val call = service.getSciencePhotos()
        call.enqueue(callback)
    }

    fun getEducationPhotos(callback: Callback<PhotoList>){
        val call = service.getEducationPhotos()
        call.enqueue(callback)
    }

    fun getPeoplePhotos(callback: Callback<PhotoList>){
        val call = service.getPeoplePhotos()
        call.enqueue(callback)
    }

    fun getHealthPhotos(callback: Callback<PhotoList>){
        val call = service.getHealthPhotos()
        call.enqueue(callback)
    }

    fun getPlacesPhotos(callback: Callback<PhotoList>){
        val call = service.getPlacesPhotos()
        call.enqueue(callback)
    }

    fun getAnimalsPhotos(callback: Callback<PhotoList>){
        val call = service.getAnimalsPhotos()
        call.enqueue(callback)
    }

    fun getIndustryPhotos(callback: Callback<PhotoList>){
        val call = service.getIndustryPhotos()
        call.enqueue(callback)
    }

    fun getFoodPhotos(callback: Callback<PhotoList>){
        val call = service.getFoodPhotos()
        call.enqueue(callback)
    }

    fun getComputerPhotos(callback: Callback<PhotoList>){
        val call = service.getComputerPhotos()
        call.enqueue(callback)
    }

    fun getSportsPhotos(callback: Callback<PhotoList>){
        val call = service.getSportsPhotos()
        call.enqueue(callback)
    }

    fun getTransportationPhotos(callback: Callback<PhotoList>){
        val call = service.getTransportationPhotos()
        call.enqueue(callback)
    }

    fun getTravelPhotos(callback: Callback<PhotoList>){
        val call = service.getTravelPhotos()
        call.enqueue(callback)
    }

    fun getBuildingPhotos(callback: Callback<PhotoList>){
        val call = service.getBuildingsPhotos()
        call.enqueue(callback)
    }

    fun getBusinessPhotos(callback: Callback<PhotoList>){
        val call = service.getBusinessPhotos()
        call.enqueue(callback)
    }
}
