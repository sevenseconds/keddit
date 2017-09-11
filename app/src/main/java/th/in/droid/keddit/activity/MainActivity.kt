package th.`in`.droid.keddit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import th.`in`.droid.keddit.R
import th.`in`.droid.keddit.fragment.NewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            changeFragment(NewsFragment.newInstance())
        }
    }

    fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val fm = supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }
        fm.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit
        )
        fm.replace(R.id.container, f)
        fm.addToBackStack(null)
        fm.commit()
    }

    private fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
