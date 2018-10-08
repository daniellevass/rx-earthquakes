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
        return arrayListOf<Earthquake>(
                Earthquake("place", 5.4f, 1539026391, false, "type")
        )
    }

}