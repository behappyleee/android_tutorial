package com.example.mindtest


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // lateinit 키워드는 나중에 정의 하겠다는 키워드는
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 강의 37:38 에
        // TODO navController 정의가 안됨 nav_host_fragment 를 찾지 못함
        // TODO navController = nav_host_fragment
        
        // kotlin 은 findViewId 를 사용할 필요가 없읍
        navController = nav_host_fragment.findNavController();

    }
}