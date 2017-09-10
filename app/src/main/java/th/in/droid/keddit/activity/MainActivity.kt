package th.`in`.droid.keddit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import th.`in`.droid.keddit.R
import th.`in`.droid.keddit.fragment.NewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager.beginTransaction()
                .add(R.id.container, NewsFragment.newInstance())
                .commit()
    }
}
