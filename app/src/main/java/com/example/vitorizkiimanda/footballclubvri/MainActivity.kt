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

//    class MainActivityUI : AnkoComponent<MainActivity> {
//        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
//            linearLayout {
//                orientation = LinearLayout.HORIZONTAL
//                padding = dip(16)
//
//                imageView(R.drawable.img_barca) {
//                    id = Ids.image
//                }.lparams(width = dip(50), height = dip(50))
//
//                textView {
//                    id = Ids.name
//                    text = "Barcelona FC"
//                }.lparams(width = wrapContent, height = wrapContent) {
//                    margin = dip(10)
//                }
//            }
//        }
//
//    }
//
//    private object Ids {
//        val image = 1
//        val name = 2
//    }
}
