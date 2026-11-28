package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class StudentQuestionnaireFragment :
    Fragment(R.layout.fragment_student_questionnaire) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSphereSelection(view)

        view.findViewById<View>(R.id.btnBackStudent1)
            .setOnClickListener {
                findNavController().navigateUp()
            }

        view.findViewById<View>(R.id.btnStudentNext1)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_studentQuestionnaireFragment_to_studentQuestionnaireStep2Fragment
                )
            }
    }

    private fun setupSphereSelection(view: View) {
        val ids = listOf(
            R.id.sphereIT,
            R.id.sphereDesign,
            R.id.sphereMarketing,
            R.id.sphereProduct,
            R.id.sphereAnalytics,
            R.id.sphereOther
        )

        val options = ids.map { view.findViewById<TextView>(it) }

        options.forEach { option ->
            option.setOnClickListener {
                options.forEach {
                    it.setBackgroundResource(R.drawable.option_default)
                    it.setTextColor(
                        resources.getColor(android.R.color.black, null)
                    )
                }

                option.setBackgroundResource(R.drawable.option_selected)
                option.setTextColor(
                    resources.getColor(android.R.color.white, null)
                )
            }
        }
    }
}
