
package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class MentorQuestionnaireStep3Fragment :
    Fragment(R.layout.fragment_mentor_questionnaire_step3) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.btnBackStep3)
            .setOnClickListener {
                findNavController().navigateUp()
            }

        // Время
        setupSingleChoice(
            view,
            listOf(
                R.id.timeOneTwo,
                R.id.timeThreeFour,
                R.id.timeFivePlus
            )
        )

        // Условия менторства
        setupSingleChoice(
            view,
            listOf(
                R.id.conditionFree,
                R.id.conditionGameCurrency,
                R.id.conditionPaid
            )
        )

        // Срок менторства
        setupSingleChoice(
            view,
            listOf(
                R.id.durationOneMonth,
                R.id.durationThreeMonths,
                R.id.durationSixMonths
            )
        )

        // Завершение анкеты
        view.findViewById<View>(R.id.btnFinishQuestionnaire)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_mentorQuestionnaireStep3Fragment_to_mentorQuestionnaireSuccessFragment
                )
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
