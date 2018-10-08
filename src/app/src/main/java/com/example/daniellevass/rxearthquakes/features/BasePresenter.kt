package com.example.daniellevass.rxearthquakes.features

import android.support.annotation.CallSuper


abstract class BasePresenter<T> {

    var view: T? = null

    fun isViewAttached(): Boolean{
        return this.view != null
    }


    @CallSuper
    fun onViewAttached(view: T) {
        if (isViewAttached()) {
            throw Throwable(
                    "View " + this.view + " is already attached. Cannot attach " + view)
        }
        this.view = view
    }

    @CallSuper
    fun onViewDetached() {
        if (!isViewAttached()) {
            throw IllegalStateException("View is already detached")
        }
        view = null
    }
}