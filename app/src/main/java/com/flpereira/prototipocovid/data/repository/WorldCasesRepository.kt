package com.flpereira.prototipocovid.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.flpereira.prototipocovid.data.network.MyApi
import com.flpereira.prototipocovid.data.network.SafeApiRequest
import com.flpereira.prototipocovid.data.network.response.WorldCasesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorldCasesRepository(private val api: MyApi): SafeApiRequest() {

    private val _worldCasesData = MutableLiveData<WorldCasesResponse>()


    suspend fun getWorldCasesData(){
        return withContext(Dispatchers.IO){
            fetchData()
        }
    }

    private suspend fun fetchData() {
        val response = apiRequest { api.getWorldCasesData() }
        _worldCasesData.postValue(response)

    }
}