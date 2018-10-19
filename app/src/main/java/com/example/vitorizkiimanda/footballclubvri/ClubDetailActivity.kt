package com.example.vitorizkiimanda.footballclubvri

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_club_detail.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.toast

class ClubDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_detail)

        val data:Item = intent.getParcelableExtra<Item>("data")

        club_name.text = data.name
        club_description.text = data.description
        Glide.with(baseContext).load(data.image).into(club_logo)
    }
}
