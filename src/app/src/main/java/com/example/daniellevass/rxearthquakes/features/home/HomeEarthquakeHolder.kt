package com.example.daniellevass.rxearthquakes.features.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.example.daniellevass.rxearthquakes.R
import com.example.daniellevass.rxearthquakes.models.Earthquake
import java.text.SimpleDateFormat
import java.util.*

class HomeEarthquakeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindCard(earthquake: Earthquake) {

            val lblTitle: TextView = itemView.findViewById(R.id.lblTitle)
            lblTitle.text = getTimeString(earthquake.time)

            val lblMagnitude: TextView = itemView.findViewById(R.id.lblMagnitude)
            lblMagnitude.text = earthquake.magnitude.toString()

            val containerMagnitude:FrameLayout = itemView.findViewById(R.id.containerMagnitude);

            if (earthquake.magnitude < 2){
                containerMagnitude.setBackgroundResource(R.drawable.magnitude_square_green)
            } else if (earthquake.magnitude < 4){
                containerMagnitude.setBackgroundResource(R.drawable.magnitude_square_yellow)
            } else if (earthquake.magnitude < 6){
                containerMagnitude.setBackgroundResource(R.drawable.magnitude_square_orange)
            } else {
                containerMagnitude.setBackgroundResource(R.drawable.magnitude_square_red)
            }


            val lblDescription:TextView = itemView.findViewById(R.id.lblDescription)
            lblDescription.text = earthquake.place

        }

        fun getTimeString(time: Long) : String{

            val currentTime = System.currentTimeMillis() / 1000L
            val timeDifference = currentTime - time

            if (timeDifference < 60) { //seconds
                return String.format(Locale.ENGLISH, "%d seconds ago", timeDifference)
            } else {
                if ( ((timeDifference /60)/60) < 60 ) { //minutes
                    val minutes = timeDifference / 60
                    return String.format(Locale.ENGLISH, "%d minutes ago", minutes)
                } else {
                    val dateFormat = SimpleDateFormat("dd/MM HH:mm:ss", Locale.ENGLISH)
                    return dateFormat.format(Date(time))
                }
            }

        }

    }


