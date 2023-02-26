package com.example.redteapotdating.utils

class Constants {
    companion object
    {

        /**
         * I tried pulling the API data from the hinge url but i had too many problems pulling from there
         *  - Data would not populate my users list
         *  - API call would just some 100000 ms error
         *  - needed to have another Data class of Users for a List of User for the Users data
         *
         *  if needed i can upload that code aswell so i can gets some good feedback and learn from it.
         *  If i had more time i would try to find a fix for this, sorry :(
         *
         *
         *  i just created a new API with just the list of the users data instead.
         *  to access it its just FAKE_URL + users
         */
        const val BASE_URL = "https://hinge-ue1-dev-cli-android-homework.s3-website-us-east-1.amazonaws.com/"
        const val FAKE_URL = "https://w1yeg.wiremockapi.cloud/"
    }
}