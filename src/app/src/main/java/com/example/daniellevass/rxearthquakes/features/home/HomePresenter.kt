package com.example.daniellevass.rxearthquakes.features.home

import com.example.daniellevass.rxearthquakes.features.BasePresenter
import com.example.daniellevass.rxearthquakes.models.Earthquake

class HomePresenter : BasePresenter<HomePresenter.View>() {

    interface View {
        fun onEarthquakes(earthquakes: List<Earthquake>)
        fun onError(throwable: Throwable)
    }


    fun HomePresenter(){
        //todo inject the interactor
    }


    fun getEarthquakes(){
        //todo replace here with an interactor
        if (isViewAttached()){
            view?.onEarthquakes(generateEarthquakes())
        }
    }

    fun generateEarthquakes():List<Earthquake>{

        val currentEpoch = System.currentTimeMillis() / 1000L

        return arrayListOf<Earthquake>(
                Earthquake("not near my house", 1.4f, currentEpoch - 10, false, "type"),
                Earthquake("not near my house", 3.4f, currentEpoch - 200, false, "type"),
                Earthquake("not near my house", 5.4f, currentEpoch - 3000, false, "type"),
                Earthquake("not near my house", 7.4f, 1539026391, false, "type")
        )
    }

}