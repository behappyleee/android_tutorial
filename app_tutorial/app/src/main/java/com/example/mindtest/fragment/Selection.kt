package com.example.mindtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mindtest.R
import kotlinx.android.synthetic.main.fragment_selection.*

class Selection : Fragment(), View.OnClickListener {

    lateinit var navController: NavController;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);

        btn_back.setOnClickListener(this);
        option_1.setOnClickListener(this);
        option_2.setOnClickListener(this);
        option_3.setOnClickListener(this);
        option_4.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        // id 가 null 일 수 도 있기에 물음표를 붙여주어야 함
        // v 가 null 일 시 이것은 null 을 반환
        when(v?.id) {
            R.id.option_1 -> {navigateWithIndex(1)}
            R.id.option_2 -> {navigateWithIndex(2)}
            R.id.option_3 -> {navigateWithIndex(3)}
            R.id.option_4 -> {navigateWithIndex(4)}
            R.id.btn_back -> {
                navController.popBackStack();
            }
        }
    }

    fun navigateWithIndex(index : Int) {
        // index 를 넣어 줌
        val bundle : Bundle = bundleOf("index" to index);
        navController.navigate(R.id.action_selection_to_resultFragment, bundle);
    }


}