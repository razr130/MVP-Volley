package com.spacecolony.mvp_volley.view

import com.spacecolony.mvp_volley.model.Stamp

interface PageStampContract {

    interface View:BaseView<PageStamp>{

        fun loadStamp(data:ArrayList<Stamp>)
        fun validateForm():Boolean
    }

    interface PageStamp{
        fun getStamp()
    }
}