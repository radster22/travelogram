package com.aradhyasinghb.travelogram.data

import android.media.Image
import com.aradhyasinghb.libimgur.ImgurClient

class ImgurRepository {
    val api = ImgurClient.api
    suspend fun getHotFeed(): List<Image>? { //TODO: return a proper error object if null
        val response = api.getGallery(Section.HOT)
        return response.body()?.data

    }
    suspend fun getTopFeed(){
        val response = api.getGallery(Section.TOP)
        return response.body()?.data

    }
}