package com.guohanlin.network.api

import com.guohanlin.model.InterfaceResponseDTO
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    /**
     * 注释：获取接口返回对应实体
     * 时间：2021/8/31 0031 15:47
     * 作者：郭翰林
     */
    @POST("/api/quickType/conversion")
    @FormUrlEncoded
    fun getInterfaceModel(@FieldMap params: Map<String, String>): Observable<InterfaceResponseDTO>
}