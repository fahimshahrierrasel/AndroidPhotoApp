package com.fahimshahrierrasel.photoapp.models

import java.io.Serializable

/**
 * Created by fahim on 29/9/17.
 */
data class Photo(val id: String,
                 val likes: Int,
                 val favorites: Int,
                 val tags: String,
                 val imageWidth: Int,
                 val imageHeight: Int,
                 val previewURL: String,
                 val webformatURL: String) : Serializable {
}