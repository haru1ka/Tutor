package com.example.tutor.auth

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.tutor.R

/** Текст про соглашение с кликабельными подчёркнутыми ссылками. */
fun TextView.setupTerms(onAgreement: () -> Unit, onPrivacy: () -> Unit) {
    val full = context.getString(R.string.terms_text)
    val spannable = SpannableString(full)

    fun link(part: String, onClick: () -> Unit) {
        val start = full.indexOf(part)
        if (start < 0) return
        spannable.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) = onClick()
            override fun updateDrawState(ds: TextPaint) {
                ds.isUnderlineText = true
                ds.color = currentTextColor
            }
        }, start, start + part.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    link(context.getString(R.string.terms_agreement), onAgreement)
    link(context.getString(R.string.terms_privacy), onPrivacy)

    text = spannable
    movementMethod = LinkMovementMethod.getInstance()
    highlightColor = Color.TRANSPARENT
}

/** Email + пароль + подтверждение (общая часть для всех регистраций). */
fun validateCredentials(
    email: EditText,
    password: EditText,
    confirm: EditText
): Boolean {
    var ok = true
    val ctx = email.context

    if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString().trim()).matches()) {
        email.error = ctx.getString(R.string.err_email); ok = false
    }
    if (password.text.toString().length < 6) {
        password.error = ctx.getString(R.string.err_password); ok = false
    }
    if (confirm.text.toString() != password.text.toString()) {
        confirm.error = ctx.getString(R.string.err_password_match); ok = false
    }
    return ok
}

/** Регистрация ученика / наставника: имя + учётные данные. */
fun validateCommon(
    name: EditText,
    email: EditText,
    password: EditText,
    confirm: EditText
): Boolean {
    val nameOk = !name.text.isNullOrBlank()
    if (!nameOk) name.error = name.context.getString(R.string.err_name)
    return validateCredentials(email, password, confirm) && nameOk
}
