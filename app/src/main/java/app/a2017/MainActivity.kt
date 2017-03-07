package app.a2017

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.Button
import android.widget.Toast
import app.a2017.fragment.LeftFragment
import app.a2017.fragment.RightFragment

class MainActivity : FragmentActivity(), View.OnClickListener {
     var TAG : String=MainActivity::class.java.simpleName
    // ?  如果为空时返回空 ，否则返回真实的值，不会空指针异常
    val a: String?=null


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
        var key1=savedInstanceState?.getString("key1")
        var key2=savedInstanceState?.getString("key2")
        setContentView(R.layout.activity_main)
        // ?  如果为空时返回空 ，否则返回真实的值，不会空指针异常
        print(a?.length)
        var length= a?.length ?: -1

        //区间表示
        if( length in 1..10){

        }

        //for 循环   1-10    隔2循环一次
        for (length in 1..10 step  2){

        }

        //for 你循环
        for (length in 10 downTo 1 step 2){

        }


        initView()
    }


    fun initView() {
        left = LeftFragment()
        right = RightFragment()
        fm = supportFragmentManager
        s1=findViewById(R.id.switchs1) as  Button
        s2=findViewById(R.id.switchs2) as  Button
        change=findViewById(R.id.change) as Button
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
            print("left change:$TAG")
        }

        s2!!.setOnClickListener {
            Toast.makeText(this,"right",Toast.LENGTH_LONG).show()
            ft=fm!!.beginTransaction()
            ft!!.replace(R.id.fg,right)
            ft!!.addToBackStack(null)
            ft!!.commit()
            println("right change:"+"$TAG")
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
