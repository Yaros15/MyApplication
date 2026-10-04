package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri

object Utils {

    fun openSecondActivity(context: Context, text: String) {
        val secondActivity = Intent(context, SecondActivity::class.java).apply {
            putExtra("KEY_MESSAGE", text)
        }
        context.startActivity(secondActivity)
    }

    fun callFriend(context: Context, phone: String) {
        val uri = Uri.parse("tel:$phone")
        val intent = Intent(Intent.ACTION_DIAL, uri)
        context.startActivity(intent)
    }

    fun shareText(context: Context, text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
            putExtra(Intent.EXTRA_SUBJECT, "Поделиться текстом")
        }
        context.startActivity(Intent.createChooser(shareIntent, "Поделиться через…"))
    }

}