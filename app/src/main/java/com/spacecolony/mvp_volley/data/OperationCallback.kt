package com.spacecolony.mvp_volley.data

import com.spacecolony.mvp_volley.model.Stamp

interface OperationCallback {
    fun onSuccess(obj: ArrayList<Stamp>)
    fun onError(obj:Any?)
}