package com.guohanlin.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object Api {
    /**
     * 注释：获取Retrofit Service
     * 时间：2021/5/24 0024 10:11
     * 作者：郭翰林
     */
    fun <T> getService(clazz: Class<T>, baseUrl: String): T {
        //创建OkhttpClient
        val okhttpBuilder = OkHttpClient.Builder()
        okhttpBuilder.connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
        val okhttpClient = okhttpBuilder.build()
        //创建Retrofit客户端
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(okhttpClient)
            .build()
        //创建并返回Service
        return retrofit.create(clazz)
    }
}