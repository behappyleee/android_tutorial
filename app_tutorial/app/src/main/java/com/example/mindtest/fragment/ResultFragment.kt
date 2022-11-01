package com.example.mindtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mindtest.R
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment() {

    var option = -1;

    lateinit var navController: NavController;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // arguments 가 index 로 오게 됨
        option = arguments?.getInt("index") ?: -1;

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    
    // view 가 생성이 될 시 setResult 값을 setting 을 해 줌
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        // 화면 결과를 셋팅을 해 줌
        setResult(option);

        btn_home.setOnClickListener {
            // nav_graph 에서 설정을 하였던 것을 id 값을 가져옴
            navController.navigate(R.id.action_resultFragment_to_mainFragment);
        }
    }

    fun setResult(option : Int) {
        when(option) {
            1 -> {
                // tv_main.setText();
                // 위 형식이랑 똑같지만 코틀린은 주로 아래 형식을 많이 사용
                tv_main.text = "You are a QUITTER";
                tv_sub.text = "You can let the person easily";
            }
            2 -> {
                tv_main.text = "You should focus on yourself";
                tv_sub.text = "You become really clingy to your ex";
            }
            3 -> {
                tv_main.text = "You shoul take it easy";
                tv_sub.text = "You can do crazy things no matter what it takes";
            }
            4 -> {
                tv_main.text = "You are pretty mature";
                tv_sub.text = "You can easily accept the break-up";
            }
        }
    }

}