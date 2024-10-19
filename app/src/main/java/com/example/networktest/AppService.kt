package com.example.networktest

import android.provider.ContactsContract.Data
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by deqiangchen on 2024/10/18.
 */
interface AppService {

    @GET("get_data.json")
    fun getAppData():Call<List<App>>

    @GET("{page}/get_data.json")
    fun getAppData2(@Path("page") page:Int):Call<List<App>>

    @GET("get_data.json")
    fun getAppData3(@Query("u") user:String,@Query("t") token:String):Call<List<App>>

    //静态header声明
    @Headers("User-Agent:okhttp","Cache-Control:max-age=0")
    @GET("get_data.json")
    fun getAppData4():Call<List<App>>

    //动态指定header
    @GET("get_data.json")
    fun getAppData5(@Header("User-Agent") userAgent:String,@Header("Cache-Control") cacheControl:String):Call<List<App>>

    @DELETE("data/{id}")
    fun deleteData(@Path("id") id :String):Call<ResponseBody>

    @POST("data/create")
    fun createData(@Body data:Data):Call<ResponseBody>
}