package com.example.networktest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.composetutorial.databinding.ActivityNetworkTestBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
//import okhttp3.Response
import org.json.JSONArray
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread

class NetworkTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNetworkTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sendRequestBtn.setOnClickListener {
            //sendRequestWithHttpURLConnection()
            sendRequestWithOkhttp()
        }
        binding.getAppDataBtn.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val appService = retrofit.create(AppService::class.java)
            appService.getAppData().enqueue(object : Callback<List<App>> {
                override fun onResponse(
                    call: Call<List<App>>,
                    response: Response<List<App>>
                ) {
                    val list = response.body()
                    if (list!=null){
                        for (app in list){
                            Log.d("NetworkTestActivity","id is ${app.id}")
                            Log.d("NetworkTestActivity","name is ${app.name}")
                            Log.d("NetworkTestActivity","version is ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }

    private fun sendRequestWithOkhttp() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    //.url("http://10.0.2.2/get_data.xml")
                    .url("http://10.0.2.2/get_data.json")
                    .build()
                val response = client.newCall(request).execute()
                val responseData = response.body()?.string()
                //showResponse(responseData)
                //parseXMLWithPull(response)
                //parseXMLWithSAX(response)
                //parserJSONWithJSONObject(responseData)
                parserJSONWithGSON(responseData)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    private fun parserJSONWithGSON(responseData: String?) {
        val gson = Gson()
        val typeOf = object :TypeToken<List<App>>(){}.type
        val appList = gson.fromJson<List<App>>(responseData,typeOf)
        for (app in appList){
            Log.d("NetworkTestActivity","id is ${app.id}")
            Log.d("NetworkTestActivity","name is ${app.name}")
            Log.d("NetworkTestActivity","version is ${app.version}")
        }
    }

    private fun parserJSONWithJSONObject(jsonData: String?) {
        try {
            val jsonArray = JSONArray(jsonData)
            for (i in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(i)
                val id = jsonObject.getString("id")
                val name =jsonObject.getString("name")
                val version = jsonObject.getString("version")
                Log.d("NetworkTestActivity","id is $id")
                Log.d("NetworkTestActivity","name is $name")
                Log.d("NetworkTestActivity","version is $version")
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

//    private fun parseXMLWithSAX(response: Response) {
//        try {
//            val factory = SAXParserFactory.newInstance()
//            val xmlReader = factory.newSAXParser().xmlReader
//            val handler = ContentHandler()
//            xmlReader.contentHandler =handler
//            val input =InputSource(response.body()?.charStream())
//            xmlReader.parse(input)
//        }catch (e:Exception){
//            e.printStackTrace()
//        }
//    }

//    private fun parseXMLWithPull(response: Response) {
//        try {
//            val factory = XmlPullParserFactory.newInstance()
//            val xmlPullParser = factory.newPullParser()
//            val input = ByteArrayInputStream(response.body()?.bytes())
//            xmlPullParser.setInput(input,"utf-8")
//            var eventType = xmlPullParser.eventType
//            var id =""
//            var name =""
//            var version =""
//            while (eventType != XmlPullParser.END_DOCUMENT){
//                val nodeName = xmlPullParser.name
//                when(eventType){
//                    XmlPullParser.START_TAG ->{
//                        when(nodeName){
//                            "id" -> id =xmlPullParser.nextText()
//                            "name" -> name = xmlPullParser.nextText()
//                            "version" ->version=xmlPullParser.nextText()
//                        }
//                    }
//                    XmlPullParser.END_TAG ->{
//                        if ("app"==nodeName){
//                            Log.d("NetworkTestActivity","id is $id")
//                            Log.d("NetworkTestActivity","name is $name")
//                            Log.d("NetworkTestActivity","version is $version")
//                        }
//                    }
//                }
//                eventType =xmlPullParser.next()
//            }
//        }catch (e:Exception){
//            e.printStackTrace()
//        }
//    }


    private fun sendRequestWithHttpURLConnection() {
        //开启线程发起网络请求
        thread {
            var connection : HttpURLConnection?=null
            try {
                val response =StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout=8000
                connection.readTimeout=8000
                val input = connection.inputStream
                //对获取到的输入流进行读取
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                connection?.disconnect()
            }
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            binding.responseText.setText(response)
        }
    }
}