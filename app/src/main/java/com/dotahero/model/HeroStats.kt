package com.dotahero.model

import com.fasterxml.jackson.annotation.JsonProperty

data class HeroStats(
    @JsonProperty("id")
    val id:Int,
    @JsonProperty("name")
    val name:String,
    @JsonProperty("localized_name")
    val localizedName:String,
    @JsonProperty("img")
    val img:String,
    @JsonProperty("icon")
    var icon:String
)