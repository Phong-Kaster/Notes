package com.example.jetpack.core


import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.example.note.util.AppUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
open class CoreActivity
@Inject
constructor() : AppCompatActivity(), CoreBehavior {


    @Composable
    open fun ComposeView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hideNavigationBar()

        setContent {
            ComposeView()
        }
    }

    override fun hideNavigationBar() {
        AppUtil.hideNavigationBar(window = this.window)
    }


    override fun makeStatusBarTransparent() {
        /*with(window) {
            setFlags(
                android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }*/
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}