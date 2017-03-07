package app.a2017;

import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import app.a2017.fragment.LeftFragment
import app.a2017.fragment.RightFragment

class MainActivity : FragmentActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        if (v!!.id == R.id.switchs1) {
            ft = fm!!.beginTransaction()
            ft!!.replace(R.id.fg, left)
            ft!!.addToBackStack(null)
            ft!!.commit()
        } else if (v!!.id == R.id.switchs2) {
            ft = fm!!.beginTransaction()
            ft!!.replace(R.id.fg, right)
            ft!!.addToBackStack(null)
            ft!!.commit()
        } else if (v.id == R.id.change) {
                var intent=Intent()
            intent.setClass(this,WelcomActivity::class.java)
            startActivity(intent)

        }

    }

    var fm: FragmentManager? = null

    var left: LeftFragment? = null
    var right: RightFragment? = null
    var s1: Button? = null
    var ft: FragmentTransaction? = null
    var s2: Button? = null
    var change: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var key1=savedInstanceState!!.getString("key1")
        var key2=savedInstanceState.getString("key2")
        setContentView(R.layout.activity_main)
        initView()
    }


    fun initView() {
        left = LeftFragment()
        right = RightFragment()
        fm = supportFragmentManager
        s1!!.setOnClickListener(this)
        s2!!.setOnClickListener(this)
        change!!.setOnClickListener(this)
        s1!!.performClick()

        s1!!.setOnClickListener {
            Toast.makeText(this,"left", Toast.LENGTH_LONG).show()
            ft= fm!!.beginTransaction()
            ft!!.replace(R.id.fg,left)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }

        s2!!.setOnClickListener {
            Toast.makeText(this,"left",Toast.LENGTH_LONG).show()
            ft=fm!!.beginTransaction()
            ft!!.replace(R.id.fg,right)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }
         s1!!.performClick()

    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putString("key1", s1!!.text.toString())
        outState.putString("key2", s2!!.text.toString())
    }

    override fun onStart() {
        super.onStart()
    }

}
