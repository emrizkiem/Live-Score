package emrizkiem.dev.secondkade.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import emrizkiem.dev.secondkade.R
import emrizkiem.dev.secondkade.feature.league.LeagueActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val topToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
        title_splash.startAnimation(topToBottom)

        val bottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)
        shape_splash.startAnimation(bottomToTop)

        Handler().postDelayed({
            val intent = Intent(this, LeagueActivity::class.java)

            startActivity(intent)
            finish()
        }, 2000)
    }
}
