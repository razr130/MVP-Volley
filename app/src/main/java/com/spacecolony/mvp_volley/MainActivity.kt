package com.spacecolony.mvp_volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.spacecolony.mvp_volley.adapter.PageStampAdapter
import com.spacecolony.mvp_volley.data.Injection
import com.spacecolony.mvp_volley.model.Stamp
import com.spacecolony.mvp_volley.presenter.PageStampPresenter
import com.spacecolony.mvp_volley.view.PageStampContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PageStampContract.View {

    override lateinit var presenter: PageStampContract.PageStamp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Recycler_Stamp.setHasFixedSize(true)
        Recycler_Stamp.layoutManager = LinearLayoutManager(this)

        presenter = PageStampPresenter(this,Injection.provideRepository(this))
        presenter.getStamp()

    }

    override fun loadStamp(data: ArrayList<Stamp>) {
        Recycler_Stamp.adapter = PageStampAdapter(data) {
            Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
        }
    }


    override fun validateForm(): Boolean {
        return true
    }

}
