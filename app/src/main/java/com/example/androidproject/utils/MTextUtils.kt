package com.example.androidproject.utils

class MTextUtils {

    companion object {
        /* Trim text and add "..." after that if longer than characterCount */
        fun trimText(text: String, characterCount: Int):String = if (text.length > characterCount) text.substring(0, characterCount) + "..." else text
    }

}