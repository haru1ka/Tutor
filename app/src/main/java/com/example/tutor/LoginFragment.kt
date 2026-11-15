package com.example.tutor.auth

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)

        view.findViewById<View>(R.id.tvBack).setOnClickListener {
            findNavController().popBackStack()
        }

        view.findViewById<View>(R.id.btnLogin).setOnClickListener {
            var ok = true
            if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString().trim()).matches()) {
                etEmail.error = getString(R.string.err_email); ok = false
            }
            if (etPassword.text.isNullOrEmpty()) {
                etPassword.error = getString(R.string.err_field_empty); ok = false
            }
            if (ok) {
                //запрос авторизации
            }
        }

        view.findViewById<View>(R.id.tvForgot).setOnClickListener {
            // экран восстановления пароля
        }

        view.findViewById<View>(R.id.tvRegisterNew).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_roleSelectFragment)
        }
    }
}
