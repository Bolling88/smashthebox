package xevenition.com.smashthebox

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SmashViewModel : ViewModel() {
    var observableSmashForce = MutableLiveData<Double>()


    fun onBoxClicked(){
        //TODO hard coded a force on the box for testing
        observableSmashForce.postValue(100.0)
    }
}