package xevenition.com.smashthebox

import androidx.lifecycle.ViewModel

class SmashViewModel : ViewModel() {
    val observableSmashForce = SingleLiveEvent<Float>()
    val observableToast = SingleLiveEvent<String>()


    fun onBoxClicked() {
        //TODO hard coded a force on the box for testing
        observableSmashForce.postValue(100f)
    }
}