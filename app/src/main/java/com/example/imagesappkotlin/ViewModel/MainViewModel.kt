package com.example.imagesapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.Categories
import com.example.example.ImageModelClass
import com.example.imagesapp.Repository.MainRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    var liveDataList: MutableLiveData<List<ImageModelClass>>
    val imageItem: MutableList<ImageModelClass> = mutableListOf()

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<ImageModelClass>> {
        return liveDataList
    }

    fun makeAPICall() {
            val response = repository.getAllImages()
            response.enqueue(object : Callback<Categories> {

                override fun onResponse(
                    call: Call<Categories>,
                    response: Response<Categories>
                ) {
                    Log.d("TAG", "${response.body()}")
                    val imagess: MutableList<ImageModelClass> = mutableListOf()
                    response.body()?.id?.let { movieItems ->
                        for (imageitem in imageItem) {
                            var imageItem: ImageModelClass = ImageModelClass()
                            imageItem.id = imageItem.id
                            imageItem.url=imageItem.url

                            imagess.add(imageItem)
                            imageItem.add(imagess)
                        }
                    }
                    liveDataList.postValue(imagess)
                }
                override fun onFailure(call: Call<Categories>, t: Throwable) {
                    Log.d("TAG", "onFailure")
                }
            })

    }
}