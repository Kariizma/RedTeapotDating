package com.example.redteapotdating.utils

class Constants {
    companion object
    {

        /**
         * I tried pulling the API data from the hinge url but i had too many problems pulling from there
         *  - Data would not populate my users list
         *  - needed to have another Data class of Users for a List of User for the Users data
         *  - tried to access with a http://
         *      - error: Failure: CLEARTEXT communication to hinge-ue1-dev-cli-android-homework.s3-website-us-east-1.amazonaws.com not permitted by network security policy
         *  - tried to access with a https://
         *      - no response from the Data and when i put it into a web brower i cant connect to the link
         *
         *
         *  i just created a new API with just the list of the users data instead.
         *  to access it its just FAKE_URL + users
         */
        const val BASE_URL = "https://hinge-ue1-dev-cli-android-homework.s3-website-us-east-1.amazonaws.com/"
        const val FAKE_URL = "https://w1yeg.wiremockapi.cloud/"
    }
}