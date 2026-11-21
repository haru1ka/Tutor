
package com.example.tutor.auth

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tutor.R
import androidx.navigation.fragment.findNavController

class MentorQuestionnaireFragment :
    Fragment(R.layout.fragment_mentor_questionnaire) {

    private var selectedField = "IT и разработка"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.btnBack).setOnClickListener {
            findNavController().navigateUp()
        }
        val fields = listOf(
            R.id.fieldIT,
            R.id.fieldDesign,
            R.id.fieldMarketing,
            R.id.fieldProduct,
            R.id.fieldAnalytics,
            R.id.fieldOther
        )

        fun selectField(selectedId: Int) {
            fields.forEach { id ->
                val option = view.findViewById<TextView>(id)

                val selected = id == selectedId

                option.setBackgroundResource(
                    if (selected) R.drawable.option_selected
                    else R.drawable.option_default
                )

                option.setTextColor(
                    if (selected) Color.WHITE
                    else Color.BLACK
                )

                if (selected) {
                    selectedField = option.text.toString()
                }
            }
        }

        fields.forEach { id ->
            view.findViewById<TextView>(id).setOnClickListener {
                selectField(id)
            }
        }

        selectField(R.id.fieldIT)

        view.findViewById<View>(R.id.btnQuestionNext)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_mentorQuestionnaireFragment_to_mentorQuestionnaireStep2Fragment)
            }
    }
}
