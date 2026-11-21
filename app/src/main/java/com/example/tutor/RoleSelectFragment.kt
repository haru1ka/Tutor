package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class RoleSelectFragment : Fragment(R.layout.fragment_role_select) {

    private var selectedRole = Role.STUDENT

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = mapOf(
            view.findViewById<TextView>(R.id.roleStudent) to Role.STUDENT,
            view.findViewById<TextView>(R.id.roleMentor) to Role.MENTOR,
            view.findViewById<TextView>(R.id.roleCurator) to Role.CURATOR
        )

        fun select(role: Role) {
            selectedRole = role
            options.forEach { (v, r) -> v.isSelected = (r == role) }
        }

        options.forEach { (v, r) -> v.setOnClickListener { select(r) } }

        select(
            savedInstanceState?.getString(KEY_ROLE)?.let { Role.valueOf(it) } ?: Role.STUDENT
        )


        view.findViewById<View>(R.id.btnNext).setOnClickListener {

            val nav = findNavController()

            when (selectedRole) {

                Role.MENTOR -> {
                    nav.navigate(R.id.mentorQuestionnaireFragment)
                }

                Role.CURATOR -> {
                    nav.navigate(
                        R.id.action_roleSelectFragment_to_curatorRegisterFragment
                    )
                }

                Role.STUDENT -> {
                    nav.navigate(R.id.studentQuestionnaireFragment)
                }
            }
        }


        view.findViewById<View>(R.id.tvHaveAccount).setOnClickListener {
            findNavController().navigate(R.id.action_roleSelectFragment_to_loginFragment)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_ROLE, selectedRole.name)
    }

    private companion object {
        const val KEY_ROLE = "selected_role"
    }
}
