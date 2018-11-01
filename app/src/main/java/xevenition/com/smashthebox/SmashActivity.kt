package xevenition.com.smashthebox

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wrlds.sdk.Ball
import xevenition.com.smashthebox.databinding.ActivitySmashBinding


class SmashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySmashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_smash)

        val ball = Ball(this)

        val model = ViewModelProviders.of(this).get(SmashViewModel::class.java)
        model.setBall(ball)
        binding.viewModel = model
        model.observableSmashForce.observe(this, Observer {
            it?.let {
                //apply force on the box
                val myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce)
                binding.imageView.startAnimation(myAnim)
            }
        })
    }
}
