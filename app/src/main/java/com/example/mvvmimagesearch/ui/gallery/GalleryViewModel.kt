package com.example.mvvmimagesearch.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.mvvmimagesearch.data.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel
@Inject constructor(private val repository: UnsplashRepository):ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString)

    }

    fun searchPhotos(query:String){
        currentQuery.value = query
    }

    companion object{
        private const val DEFAULT_QUERY = "cats"
    }

}