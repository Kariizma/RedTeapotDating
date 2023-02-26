package com.example.redteapotdating.models

import com.squareup.moshi.Json


/**
 * Data class for Dating App Users
 * @property id is the User ID
 * @property name is the name of the person
 * @property photo is the picture of the person
 * @property gender is the gender identity of the person
 * @property school is the college or university of the person that they are currently or previously attended
 * @property hobbies is a list of hobbies the person has
 *
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */


data class Users (
    @Json(name = "id")val id: Int,
    @Json(name = "name")val name: String,
    @Json(name = "photo")val photo: String?,
    @Json(name = "gender")val gender: String?,
    @Json(name = "about")val about: String?,
    @Json(name = "school")val school: String?,
    @Json(name = "hobbies") val hobbies: List<String>?
)