package com.example.daniellevass.rxearthquakes.features.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.daniellevass.rxearthquakes.R
import com.example.daniellevass.rxearthquakes.models.Earthquake

class HomeRecyclerViewAdapter(private var earthquakes: List<Earthquake>, private val context: Context)
    : RecyclerView.Adapter<HomeEarthquakeHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeEarthquakeHolder {
            return HomeEarthquakeHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.activity_home_row_item, parent, false))
        }

        override fun getItemCount(): Int {
           return earthquakes.size
        }

        override fun onBindViewHolder(holder: HomeEarthquakeHolder, position: Int) {
            holder.bindCard(earthquakes[position])
        }

        fun setEarthquakes(earthquakes: List<Earthquake>) {
            this.earthquakes = earthquakes
            notifyDataSetChanged()
        }

    }