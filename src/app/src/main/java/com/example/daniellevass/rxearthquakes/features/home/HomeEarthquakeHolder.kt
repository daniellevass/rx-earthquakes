package com.example.daniellevass.rxearthquakes.features.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.daniellevass.rxearthquakes.R
import com.example.daniellevass.rxearthquakes.models.Earthquake
import java.text.SimpleDateFormat
import java.util.*

//
class HomeEarthquakeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView

        fun bindCard(earthquake: Earthquake) {

            val date = Date(earthquake.time)
            val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)

            val lblTitle: TextView = itemView.findViewById(R.id.lblTitle)
            lblTitle.text = dateFormat.format(date)

            val lblDescription:TextView = itemView.findViewById(R.id.lblDescription)
            lblDescription.text = String.format(Locale.ENGLISH, "%.2f @ %s ",
                    earthquake.magnitude, earthquake.place)

        }

    }


