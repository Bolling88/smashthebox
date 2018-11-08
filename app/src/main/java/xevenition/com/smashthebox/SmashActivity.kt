package xevenition.com.smashthebox

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.wrlds.sdk.Ball
import xevenition.com.smashthebox.databinding.ActivitySmashBinding


class SmashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySmashBinding

    private lateinit var ball: Ball

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_smash
        )
        val model = ViewModelProviders.of(this).get(SmashViewModel::class.java)
        binding.viewModel = model
//        model.observableSmashForce.observe(this, Observer {
//            it?.let {
//                //apply force on the box
//                val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
//                binding.imageView.startAnimation(myAnim)
//            }
//        })

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                MY_PERMISSIONS_REQUEST_BLE
            )
        } else {
            // Permission has already been granted
            ball = Ball(this)
            //handleBallConnectionState(ball)
            //handleBallBounce(ball)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_BLE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }
    }

    private fun handleBallBounce(ball: Ball) {
        ball.setOnBounceListener { bounceType, totalForce ->
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

    private fun handleBallConnectionState(ball: Ball) {
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
                Ball.ConnectionState.ERROR -> {

                }
                Ball.ConnectionState.SCANNING_ABORTED -> {

                }
                Ball.ConnectionState.SCANNING_ENDED -> {

                }
                Ball.ConnectionState.BLE_SERVICE_STARTING -> {

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        ball.disconnectDevice()
//        ball.onDestroy()
    }

    companion object {
        const val MY_PERMISSIONS_REQUEST_BLE = 34231
    }

}
