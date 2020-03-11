package com.spacecolony.mvp_volley.data

import com.spacecolony.mvp_volley.model.Stamp
import java.util.ArrayList

data class JSONModel (val tag: String, val success: String, val data:ArrayList<Stamp>, val error_msg:String?) {
    companion object{
        const val SUCCESS:Int = 1
        const val ERROR:Int = -9
        const val NOT:Int = 0
    }
    fun isSuccess():Boolean=(success==SUCCESS.toString())
}