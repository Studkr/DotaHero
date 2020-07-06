package com.dotahero.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Hero(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("localized_name")
    val localName: String,
    @JsonProperty("primary_attr")
    val primaryAttr: String,
    @JsonProperty("attack_type")
    val typeRange: String,
    @JsonProperty("roles")
    val rolesList: List<String>
)

data class Roles(
    val rolesList: String
)