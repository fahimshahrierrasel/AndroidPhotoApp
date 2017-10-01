package com.fahimshahrierrasel.photoapp.api

import com.fahimshahrierrasel.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by fahim on 29/9/17.
 */
interface PhotoAPI {
    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=nature&image_type=photo")
    fun getNaturePhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=backgrounds&image_type=photo")
    fun getBackgroundPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=science&image_type=photo")
    fun getSciencePhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=education&image_type=photo")
    fun getEducationPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=people&image_type=photo")
    fun getPeoplePhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=health&image_type=photo")
    fun getHealthPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=places&image_type=photo")
    fun getPlacesPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=animals&image_type=photo")
    fun getAnimalsPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=industry&image_type=photo")
    fun getIndustryPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=food&image_type=photo")
    fun getFoodPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=computer&image_type=photo")
    fun getComputerPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=sports&image_type=photo")
    fun getSportsPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=transportation&image_type=photo")
    fun getTransportationPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=travel&image_type=photo")
    fun getTravelPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=buildings&image_type=photo")
    fun getBuildingsPhotos(): Call<PhotoList>

    @GET("?key=6582767-4a7c93bb6669d3b9e20026474&category=business&image_type=photo")
    fun getBusinessPhotos(): Call<PhotoList>


}