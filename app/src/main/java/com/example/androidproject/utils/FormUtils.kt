package com.example.androidproject.utils

import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout

class FormUtils {

    companion object {
        /* Validate form at Settings fragment */
        fun validateSettingsForm(
            nameLayout: TextInputLayout,
            addressLayout: TextInputLayout,
            emailLayout: TextInputLayout,
            phoneLayout: TextInputLayout
        ): Boolean {
            val isValid: Boolean = true
            if (nameLayout.editText?.text.toString().length < 6 || nameLayout.editText?.text.toString().length > 40) {
                nameLayout.error = "Invalid length! (must be between 6 and 40)"
            } else nameLayout.error =""
            if (addressLayout.editText?.text.toString().length < 6 || addressLayout.editText?.text.toString().length > 80) {
                addressLayout.error = "Invalid length! (must be between 6 and 80)"
            } else nameLayout.error =""
            if (!Patterns.EMAIL_ADDRESS.matcher(emailLayout.editText?.text.toString()).matches()) {
                emailLayout.error = "Invalid e-mail address!"
            } else nameLayout.error =""
            if (!Patterns.PHONE.matcher(phoneLayout.editText?.text.toString()).matches()) {
                phoneLayout.error = "Invalid phone number format!"
            } else nameLayout.error =""
            return isValid
        }
    }

}