package com.spacecolony.mvp_volley.data

import android.content.Context

object Injection {

    //private lateinit var context: Context

    /*fun setUp(mContext: Context){
        context= mContext
    }*/
    fun provideRepository(context: Context):JSONRepository{
        return JSONRepository.getInstance(context)
    }
}