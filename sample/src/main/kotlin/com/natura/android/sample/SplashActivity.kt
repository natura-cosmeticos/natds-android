package com.natura.android.sample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import com.natura.android.sample.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var mDelayHandler: Handler
    private lateinit var binding: ActivitySplashBinding

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, BrandSelectorActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = AccelerateInterpolator()
        fadeIn.duration = 2000

        binding.splashContainer.apply {
            animation = fadeIn
        }

        mDelayHandler = Handler()

        mDelayHandler.postDelayed(mRunnable, SPLASH_DELAY)
    }

    public override fun onDestroy() {
        mDelayHandler.removeCallbacks(mRunnable)
        super.onDestroy()
    }

    companion object {
        private const val SPLASH_DELAY: Long = 3000
    }
}
