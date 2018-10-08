package com.example.daniellevass.rxearthquakes.models

data class Earthquake(
        val place: String,
        val magnitude: Float,
        val time: Long,
        val tsunami: Boolean,
        val type: String)