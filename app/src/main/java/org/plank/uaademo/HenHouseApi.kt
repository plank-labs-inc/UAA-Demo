package org.plank.uaademo

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface HenHouseApi {

    @GET("/signin")
    fun enterHenHouse(@Query("email") email: String,
              @Query("password") password: String):
            Observable<HenHouse>

    companion object {
        fun create(): HenHouseApi {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("https://en.wikipedia.org/w/")
                .build()

            return retrofit.create(HenHouseApi::class.java)
        }
    }
}