package com.example.daniellevass.rxearthquakes.features.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.daniellevass.rxearthquakes.R
import com.example.daniellevass.rxearthquakes.models.Earthquake


class HomeActivity : AppCompatActivity(), HomePresenter.View {


    private val presenter: HomePresenter = HomePresenter()

    lateinit var recyclerView: RecyclerView

    private lateinit var adapter: HomeRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)

        presenter.onViewAttached(this)


        adapter = HomeRecyclerViewAdapter(arrayListOf(), HomeActivity@ this)

        recyclerView.layoutManager = LinearLayoutManager(HomeActivity@ this)
        recyclerView.adapter = adapter


        presenter.getEarthquakes()

    }


    override fun onEarthquakes(earthquakes: List<Earthquake>) {
        Log.d("DANIELLE", "we got some earthquakes" + earthquakes.size)
        adapter.setEarthquakes(earthquakes)
    }

    override fun onError(throwable: Throwable) {
        //TODO
    }


}
