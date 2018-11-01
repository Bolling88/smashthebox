package xevenition.com.smashthebox

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wrlds.sdk.Ball

class SmashViewModel : ViewModel() {
    var observableSmashForce = MutableLiveData<Float>()


    fun onBoxClicked() {
        //TODO hard coded a force on the box for testing
        observableSmashForce.postValue(100f)
    }

    fun setBall(ball: Ball) {
        ball.setOnConnectionStateChangedListener { connectionState, stateMessage ->
            when (connectionState) {
                Ball.ConnectionState.CONNECTING -> {

                }
                Ball.ConnectionState.BLE_SERVICE_READY -> {

                }
                Ball.ConnectionState.BLE_SERVICE_STARTING -> {

                }
                Ball.ConnectionState.CONNECTED -> {

                }
                Ball.ConnectionState.CONNECTION_FAILED -> {

                }
                Ball.ConnectionState.DISCONNECTED -> {

                }
                Ball.ConnectionState.DISCONNECTING -> {

                }
                Ball.ConnectionState.ERROR ->{

                }
                Ball.ConnectionState.SCANNING_ABORTED ->{

                }
                Ball.ConnectionState.SCANNING_ENDED ->{

                }
                Ball.ConnectionState.BLE_SERVICE_STARTING ->{

                }
            }
        }


        ball.setOnBounceListener { bounceType, totalForce ->
            observableSmashForce.postValue(totalForce)
            when (bounceType) {
                Ball.BounceType.HARD -> {

                }
                Ball.BounceType.NORMAL -> {

                }
                Ball.BounceType.SOFT -> {

                }
            }
        }
    }
}