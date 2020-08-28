package com.example.rssfinaltask.viewmodel.mainscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rssfinaltask.data.Constants.LOG_TAG
import com.example.rssfinaltask.data.model.Movie
import com.example.rssfinaltask.data.repository.Repository
import com.example.rssfinaltask.data.repository.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val repository: Repository) : ViewModel() {

    fun log(msg: String) = Log.d(LOG_TAG, "[${Thread.currentThread().name}] $msg")

//    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//        Log.e(LOG_TAG, exception.message.toString())
//        Log.e(LOG_TAG, exception.printStackTrace().toString())
//    }

    private val _movies = MutableLiveData<Resource<List<Movie>>>()
    private val movies: LiveData<Resource<List<Movie>>> = _movies

    @ExperimentalCoroutinesApi
    fun getMovies(): LiveData<Resource<List<Movie>>> {
        viewModelScope.launch {
            repository.getMovies()
                .flowOn(Dispatchers.IO)
                .onStart {
                    log("onStart flow")
                    _movies.value = Resource.Loading
                }
                .catch { exception ->
                    log("catch")
                    _movies.value = Resource.Error(exception)
                }
                .onCompletion {
                    log("onCompletion flow")
                }
                .collect {
                    log("collect")
                    _movies.value = Resource.Success(it)
                }
        }
        return movies
    }
}
