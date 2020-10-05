package com.flpereira.prototipocovid.data.network

import com.flpereira.prototipocovid.data.network.response.WorldCasesResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("all")
    suspend fun getWorldCasesData(): Response<WorldCasesResponse>

    companion object{
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): MyApi{

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://disease.sh/v3/covid-19/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}