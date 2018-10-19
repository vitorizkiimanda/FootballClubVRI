package com.example.vitorizkiimanda.footballclubvri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        MainActivityUI().setContentView(this)
        setContentView(R.layout.activity_main)

        val mProgressDialog = indeterminateProgressDialog("Loading data..")
        mProgressDialog.show()

        initData()

        Handler().postDelayed(
                {
                    // This method will be executed once the timer is over
                    mProgressDialog.dismiss()
                },
                2000 // value in milliseconds
        )

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){
            startActivity<ClubDetailActivity>("data" to it)
        }
    }

    private fun initData(){

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_description)
        items.clear()
        for (i in name.indices) {
            items.add(
                    Item(
                            name[i],
                            description[i],
                            image.getResourceId(i, 0)
                    )
            )
        }

        //Recycle the typed array
        image.recycle()
    }

}
