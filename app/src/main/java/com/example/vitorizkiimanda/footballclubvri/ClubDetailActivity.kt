package com.example.vitorizkiimanda.footballclubvri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_club_detail.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import android.graphics.Bitmap



class ClubDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_club_detail)

        val data:Item = intent.getParcelableExtra<Item>("data")

        ClubDetailActivityUI(data).setContentView(this)
    }

    class ClubDetailActivityUI (val data:Item) : AnkoComponent<ClubDetailActivity> {
        override fun createView(ui: AnkoContext<ClubDetailActivity>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                padding = dip(16)

                imageView(data.image!!) {
                    id = Ids.club_logo
                }.lparams(width = matchParent, height = dip(96))

                textView {
                    id = Ids.club_name
                    text = data.name
                    textSize = 18f
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = dip(16)
                }

                textView {
                    id = Ids.club_description
                    text = data.description
                    textSize = 14f
                }.lparams(width = matchParent, height = wrapContent) {
                    margin = dip(16)
                }
            }
        }
    }

    private object Ids {
        val club_description = 1
        val club_logo = 2
        val club_name = 3
    }
}
