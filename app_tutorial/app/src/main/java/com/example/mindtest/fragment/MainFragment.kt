package com.example.mindtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mindtest.R
import kotlinx.android.synthetic.main.fragment_main.*;

class MainFragment : Fragment() {

    lateinit var navController : NavController;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Navigation Bar 를 찾음
        navController = Navigation.findNavController(view);

        // 이 해당 버튼이 클릭을 하였을 떄 Action 을 정의할 수 있음
        btn_next.setOnClickListener {
            // 버튼을 클릭 하였을 떄 다음 페이지로 이동하게 됨
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
        }

    }

}