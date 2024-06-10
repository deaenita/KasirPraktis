package com.deaenita.posfinalproject.api

import com.deaenita.posfinalproject.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductService {

    @POST("AKfycbz_qoIepKOoEXM-kORdxr1mmspXGvLO2Gop-6HjmjlV6A_RaHTejn-I9U06fFZX1-nTBA/exec")
    fun create(@Body barang: Barang): Call<ApiResponse<String>>

    @GET("AKfycbz_qoIepKOoEXM-kORdxr1mmspXGvLO2Gop-6HjmjlV6A_RaHTejn-I9U06fFZX1-nTBA/exec")
    fun read(): Call<ApiResponse<List<Barang>>>

    @POST("AKfycbz_qoIepKOoEXM-kORdxr1mmspXGvLO2Gop-6HjmjlV6A_RaHTejn-I9U06fFZX1-nTBA/exec")
    fun update(@Body barang: Barang): Call<ApiResponse<String>>

//    @PUT("AKfycbyORlJZaJbzzZHjU9H6ujsliXY2jjwfQYeslwCe5GIL4Z6IdBd3VjCqNfqG7mlJk-YRVA/exec")
//    fun update(@Body barang: Barang): Call<ApiResponse<String>>

    @POST("AKfycbz_qoIepKOoEXM-kORdxr1mmspXGvLO2Gop-6HjmjlV6A_RaHTejn-I9U06fFZX1-nTBA/exec")
    fun delete(@Body deleteRequest: DeleteRequest): Call<ApiResponse<String>>
}