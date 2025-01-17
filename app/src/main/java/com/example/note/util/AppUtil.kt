package com.example.note.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.Window
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import java.util.UUID


object AppUtil {
    fun logcat(message: String, tag: String = "Jetpack Compose", enableDivider: Boolean = false) {
        if(enableDivider){
            Log.d(tag, "----------------------------")
        }
        Log.d(tag, "-> message = $message")

    }

    fun generateUUID(): String = UUID.randomUUID().toString()

    fun Context.showToast(message: String){
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }

    fun openWebsite(context: Context, url: String) {
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(uri)
        context.startActivity(intent)
    }



    fun hideNavigationBar(window: Window) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            isAppearanceLightNavigationBars = false
            hide(WindowInsetsCompat.Type.navigationBars())
        }
    }



    fun copyToClipboard(context: Context, text: String){
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", text)
        clipboard.setPrimaryClip(clip)
    }

}