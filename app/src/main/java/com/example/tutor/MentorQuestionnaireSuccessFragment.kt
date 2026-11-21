package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class MentorQuestionnaireSuccessFragment :
    Fragment(R.layout.fragment_mentor_questionnaire_success) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btnGoHome).setOnClickListener {
            findNavController().navigate(R.id.roleSelectFragment)
        }
    }
}
