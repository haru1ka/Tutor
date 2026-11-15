package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val role = Role.valueOf(requireArguments().getString(ARG_ROLE) ?: Role.STUDENT.name)

        val etName = view.findViewById<EditText>(R.id.etName)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val etConfirm = view.findViewById<EditText>(R.id.etPasswordConfirm)

        view.findViewById<View>(R.id.tvBack).setOnClickListener {
            findNavController().popBackStack()
        }

        view.findViewById<TextView>(R.id.tvTerms).setupTerms(
            onAgreement = { /* */ },
            onPrivacy = { /* */ }
        )

        view.findViewById<View>(R.id.btnNext).setOnClickListener {
            if (validateCommon(etName, etEmail, etPassword, etConfirm)) {
                // отправить на сервер
            }
        }

        view.findViewById<View>(R.id.tvHaveAccount).setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment2_to_loginFragment)
        }
    }

    companion object {
        const val ARG_ROLE = "role"
    }
}
