package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class StudentQuestionnaireStep3Fragment :
    Fragment(R.layout.fragment_student_questionnaire_step3) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSingleChoice(
            view,
            listOf(
                R.id.studentTimeOneTwo,
                R.id.studentTimeThreeFour,
                R.id.studentTimeFivePlus
            )
        )

        setupSingleChoice(
            view,
            listOf(
                R.id.studentTimeMorning,
                R.id.studentTimeDay,
                R.id.studentTimeEvening
            )
        )

        setupSingleChoice(
            view,
            listOf(
                R.id.studentDurationOneMonth,
                R.id.studentDurationThreeMonths,
                R.id.studentDurationSixMonths
            )
        )

        view.findViewById<View>(R.id.btnBackStudent3)
            .setOnClickListener {
                findNavController().navigateUp()
            }

        view.findViewById<View>(R.id.btnFinishStudentQuestionnaire)
            .setOnClickListener {
                // Здесь позже подключим экран успешного заполнения
            }
    }

    private fun setupSingleChoice(view: View, ids: List<Int>) {
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
