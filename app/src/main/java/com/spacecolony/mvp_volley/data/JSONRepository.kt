package com.spacecolony.mvp_volley.data

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

class JSONRepository(val context: Context) {

    companion object {

        private var INSTANCE: JSONRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [TasksRepository] instance
         */
        @JvmStatic fun getInstance(context: Context): JSONRepository {
            return INSTANCE ?: JSONRepository(context)
                .apply { INSTANCE = this }
        }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }

    private val requestQueue = Volley.newRequestQueue(context)
    private val url = EndPoint.pagestamp()
    private val gson = Gson()

    fun getStamp(cardnum: String, callback: OperationCallback){
        val ob = JSONObject()
        ob.put("card_num", cardnum)

        val jsonObjectRequest = object:StringRequest(
            Method.POST,url,
            Response.Listener { response ->
            val jsonObject:JSONObject
                try {
                    jsonObject= JSONObject(response.toString())
                    val jsonModel:JSONModel = gson.fromJson(
                        jsonObject.toString(),
                        JSONModel::class.java
                    )
                    if (jsonModel.isSuccess()){
                        callback.onSuccess(jsonModel.data)
                    }
                    else {
                        callback.onError(jsonModel.error_msg)
                    }
                }
                catch (e:JSONException){
                        callback.onError(e.message)
                }
                
            },
            Response.ErrorListener { error ->
                callback.onError(error) })
        {
            override fun getParams(): MutableMap<String, String> {
                val body = HashMap<String, String>()
                body["json"] = ob.toString()
                return body
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = EndPoint.auth
                return headers
            }
        }
            requestQueue.add(jsonObjectRequest)
    }
}