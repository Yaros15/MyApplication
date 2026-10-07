package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

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
        if(isValidPhoneRegex(phone)){
            context.startActivity(intent)
        }else{
            Toast.makeText(context, "Текст не похож на номер телефона", Toast.LENGTH_SHORT).show()
        }

    }

    fun shareText(context: Context, text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
            putExtra(Intent.EXTRA_SUBJECT, "Поделиться текстом")
        }
        if(text.isBlank()){
            Toast.makeText(context, "Нет смысла отправлять пустое сообщение", Toast.LENGTH_SHORT).show()
        }else {
            context.startActivity(Intent.createChooser(shareIntent, "Поделиться через…"))
        }
    }

}

private fun isValidPhoneRegex(phone: String): Boolean {
    val pattern = Regex("^\\+?7|8[0-9]{10}$")
    return pattern.matches(phone)
}