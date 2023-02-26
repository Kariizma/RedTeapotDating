package com.example.redteapotdating.API

import android.os.Build.VERSION_CODES.M
import com.example.redteapotdating.utils.Constants.Companion.BASE_URL
import com.example.redteapotdating.utils.Constants.Companion.FAKE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {

    /**
     * Basically a Singleton object (only gets called once)
     */
    companion object {

        /**
         * Building a Moshi object with a Kotlin adapter factory that retrofit will be using
         */

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        /**
         * OkHttp Intercepts to monitor the API call, good for debugging
         * Building the retrofit object with the moshi converter
         */

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(FAKE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
        }

        /**
         * A public Api that exposes the lazy-initialized Retrofit service
         */
        val api by lazy {
            retrofit.create(RedTeapotDatingApiService::class.java)
        }
    }
}