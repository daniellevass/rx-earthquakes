package com.example.daniellevass.rxearthquakes.features.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.daniellevass.rxearthquakes.R
import com.example.daniellevass.rxearthquakes.models.Earthquake

class HomeActivity : AppCompatActivity(), HomePresenter.View {


    private val presenter: HomePresenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter.onViewAttached(this)
        presenter.getEarthquakes()


    }


    override fun onEarthquakes(earthquakes: List<Earthquake>) {
        Log.d("DANIELLE", "we got some earthquakes" + earthquakes.size)
    }

    override fun onError(throwable: Throwable) {
        //TODO
    }

}
