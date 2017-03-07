package app.a2017
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.textservice.TextServicesManager
import java.util.*

/**
 * Created by Administrator on 2017/2/7.
 */
class WelcomActivity : NewsActivity() {
    //   var 变量      val    常量
    var  m : Int = 0
    val me="zgangh"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        getName()
    }

    fun  getName() : Int{
      return  m
    }


    fun nam() {


    }


    fun age(a: Any) :Unit {
        var tm  = getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE)
        var name = "张三"
        val price: Double = 2.0
        var num = 10
        val min = 1
        val max = 30
        println("商品单价:$price")
        println("我的名字:$name")
        println("商品总价:${price * num}")
        if (num in min..max) {
            println("Ok")
        }

        if (num !in min..max) {
            println("商品不足")
        }

        for (x in 1..10) {
            println(x)
        }

        when(num){
            1 -> println("1")
            2 -> println("2")
            3 -> println("3")
            is Int -> print("$num is int")
            !is Int -> print("$num is  not int")
            in 1..6 -> println("$num 在1-6之间")
            !in 1..6 -> println("$num 不在1-6之间")
        }
    }

    fun  main(array: String) =array


    fun set(x : Any): Unit {

    }

}