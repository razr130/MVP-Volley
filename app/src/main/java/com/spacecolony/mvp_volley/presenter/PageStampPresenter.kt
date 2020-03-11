package com.spacecolony.mvp_volley.presenter

import android.util.Log
import com.spacecolony.mvp_volley.data.JSONRepository
import com.spacecolony.mvp_volley.data.OperationCallback
import com.spacecolony.mvp_volley.model.Stamp
import com.spacecolony.mvp_volley.view.PageStampContract

class PageStampPresenter(val view:PageStampContract.View, private val repository: JSONRepository):PageStampContract.PageStamp {
    init {
        view.presenter = this
    }
    override fun getStamp() {

        if (view.validateForm()){
            repository.getStamp("199330162815",object : OperationCallback{
                override fun onSuccess(obj: ArrayList<Stamp>) {
                    obj.let {
                        view.loadStamp(it)
                    }
                }

                override fun onError(obj: Any?) {
                    obj.let {
                        Log.d("ERROR", it.toString())
                    }
                }

            })
        }
    }

}