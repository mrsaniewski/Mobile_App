package com.example.myapplication2.Model

import java.util.*

data class Teams(
    val teams: ArrayList<TeamModelClass>
)

data class TeamModelClass(
    val logo: String,
    val id: Int,
    val team: String,
    val town: String,
    val colors: String,
    val description: Description,
    val kitscolor: KitsColor,
)

data class Description(
    val since: String,
    val trophies: String
)

data class KitsColor(
    val first: String,
    val second: String
)