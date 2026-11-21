
package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class StudentQuestionnaireStep2Fragment :
    Fragment(R.layout.fragment_student_questionnaire_step2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMultipleChoice(
            view,
            listOf(
                R.id.studentSkillPython,
                R.id.studentSkillSQL,
                R.id.studentSkillFigma,
                R.id.studentSkillExcel,
                R.id.studentSkillCopywriting,
                R.id.studentSkillProjectManagement,
                R.id.studentSkillOther
            )
        )

        setupMultipleChoice(
            view,
            listOf(
                R.id.studentCommunicationChat,
                R.id.studentCommunicationVideo,
                R.id.studentCommunicationOffline
            )
        )

        view.findViewById<View>(R.id.btnStudentNext2)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_studentQuestionnaireStep2Fragment_to_studentQuestionnaireStep3Fragment
                )
            }
    }
    private fun setupMultipleChoice(view: View, ids: List<Int>) {
        ids.forEach { id ->
            val option = view.findViewById<TextView>(id)

            option.setOnClickListener {
                val isSelected = option.isSelected
                option.isSelected = !isSelected

                if (option.isSelected) {
                    option.setBackgroundResource(R.drawable.option_selected)
                    option.setTextColor(
                        resources.getColor(android.R.color.white, null)
                    )
                } else {
                    option.setBackgroundResource(R.drawable.option_default)
                    option.setTextColor(
                        resources.getColor(android.R.color.black, null)
                    )
                }
            }
        }
    }
}
