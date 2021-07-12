package com.aradhyasinghb.travelogram.ui.feed

import android.media.Image
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aradhyasinghb.travelogram.data.ImgurRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _feed = MutableLiveData<List<Image>>()

    val feed : LiveData<List<Image>> = _feed        // the data cant be changed from outside

    fun updateFeed(feedType: String){
        viewModelScope.launch(Dispatchers.IO){
            when(feedType){
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else -> Log.e("FEED", "Feed has to be either top or hot")
            }
        }
    }

}