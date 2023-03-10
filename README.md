# RedTeapotDating


### User Stories

- [x] Display User Data for RedTeapotDating
  - [x] Get the data from here: https://w1yeg.wiremockapi.cloud/users
- [x] Hide Viewgroup of User if User Data is not specified
- [x] Next button retrieves the next User Data in the List
- [x] When no more data is presented in the list
- [x] The user will be presented with a Toast notifying them of the lack of data
- [x] User will not be able to use the next button at the ending of the list.  

### Android Architecture
 - Model View ViewModel (MVVM)
 
### Problems

Pulling API Data from the Hinge users API did not work
- if i pulled from the (http://) http://hinge-ue1-dev-cli-android-homework.s3-website-us-east-1.amazonaws.com/users
- this error shows up: error: Failure: CLEARTEXT communication to hinge-ue1-dev-cli-android-homework.s3-website-us-east-1.amazonaws.com not permitted by network security policy

- if i pulled from the (https://) https://hinge-ue1-dev-cli-android-homework.s3-website-us-east-1.amazonaws.com/users
- the website data wouldnt load from my webbrowser and when i pull from the API it gives me a empty list

My Solution was just to create a duplicate of the JSON data that you guys provided and move it to my own mock API

Tried Two-Way Databinding for the Users Data through XML Views crashed the APP
  - Im assuming it didnt work because of the fragment calling the data from the list before it was being retrieved from the API
 
 My Solution was to just use the basic concepts of View binding and not use any of the advanced features Data binding provides.

### App Walkthough GIF

<img src="https://github.com/Kariizma/RedTeapotDating/blob/main/RedTeapotDating.gif" width=250><br>

## Open-source libraries used
- [Retrofit 2](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java/Kotlin
- [Retrofit Moshi Converter](https://github.com/square/moshi/) Moshi is a modern JSON library for Android, Java and Kotlin. It makes it easy to parse JSON into Java and Kotlin classes
- [Jetpack](https://developer.android.com/jetpack) - Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices so that developers can focus on the code they care about.
- [OkHttpInterceptor](https://square.github.io/okhttp/features/interceptors/) - Interceptors are a powerful mechanism that can monitor, rewrite, and retry calls.
- [Coil](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines. Coil is:
- [Coroutines](https://developer.android.com/kotlin/coroutines) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
