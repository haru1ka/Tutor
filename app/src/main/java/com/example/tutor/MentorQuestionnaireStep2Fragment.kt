
package com.example.tutor.auth

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class MentorQuestionnaireStep2Fragment :
    Fragment(R.layout.fragment_mentor_questionnaire_step2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Возврат на первый экран
        view.findViewById<TextView>(R.id.btnBackStep2)
            .setOnClickListener {
                findNavController().navigateUp()
            }

        // Список навыков
        val skills = listOf(
            R.id.skillPython,
            R.id.skillSQL,
            R.id.skillFigma,
            R.id.skillExcel,
            R.id.skillCopywriting,
            R.id.skillProject,
            R.id.skillOther
        )

        // Способы общения
        val communication = listOf(
            R.id.communicationChat,
            R.id.communicationVideo,
            R.id.communicationOffline
        )

        // Множественный выбор
        fun setupOptions(ids: List<Int>) {
            ids.forEach { id ->
                val option = view.findViewById<TextView>(id)

                option.setOnClickListener {
                    val selected = option.tag == "selected"

                    if (selected) {
                        option.tag = null
                        option.setBackgroundResource(
                            R.drawable.option_default
                        )
                        option.setTextColor(Color.BLACK)
                    } else {
                        option.tag = "selected"
                        option.setBackgroundResource(
                            R.drawable.option_selected
                        )
                        option.setTextColor(Color.WHITE)
                    }
                }
            }
        }

        setupOptions(skills)
        setupOptions(communication)

        // Кнопка Далее
        view.findViewById<View>(R.id.btnQuestionNextStep2)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_mentorQuestionnaireStep2Fragment_to_mentorQuestionnaireStep3Fragment
                )
            }
    }
}
