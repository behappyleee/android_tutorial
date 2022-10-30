package com.example.mindtest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mindtest.R
import kotlinx.android.synthetic.main.fragment_question.*


// View.OnClickListener 인터페이스를 상속 함
class QuestionFragment : Fragment(), View.OnClickListener {

    lateinit var navController : NavController;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);

        // this 에 의미는 View.OnClickListener 에서 구현된 view 를 사용하겠다는 의미
        btn_next.setOnClickListener(this);
    }

    // View.OnClickListener 인터페이스의 상속하여야 할 메서드임
    override fun onClick(v : View?) {
        when(v?.id) {
            R.id.btn_next -> {
                navController.navigate(R.id.action_questionFragment_to_selection);
            }
        }
    }
}