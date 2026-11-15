package com.example.tutor.auth

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tutor.R

/** Регистрация куратора: доступ только по инвайт-коду. */
class CuratorRegisterFragment : Fragment(R.layout.fragment_curator_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etInvite = view.findViewById<EditText>(R.id.etInviteCode)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val etConfirm = view.findViewById<EditText>(R.id.etPasswordConfirm)

        view.findViewById<TextView>(R.id.tvTerms).setupTerms(
            onAgreement = { /**/ },
            onPrivacy = { /* */ }
        )

        view.findViewById<View>(R.id.btnNext).setOnClickListener {
            val inviteOk = !etInvite.text.isNullOrBlank()
            if (!inviteOk) etInvite.error = getString(R.string.err_invite_code)

            if (validateCredentials(etEmail, etPassword, etConfirm) && inviteOk) {
                //отправить на сервер
            }
        }

        view.findViewById<View>(R.id.tvHaveAccount).setOnClickListener {
            findNavController().navigate(R.id.action_curatorRegisterFragment_to_loginFragment)
        }
    }
}
