package com.dharamveer.androidlibrary

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dharamveer.androidlibrary.ui.theme.AndroidLibraryTheme
import com.dharamveer.image_preview.ImagePreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidLibraryTheme {
                ShowImagePreview(description = "Hello World!")
            }
        }
    }
}

@Composable
fun ShowImagePreview(description: String) {
    val localContext = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        ImagePreview(
            modifier = Modifier
                .align(Alignment.Center)
                .size(150.dp),
            image = "https://png.pngtree.com/png-clipart/20220305/ourmid/pngtree-maha-shivratri-shiv-shankar-png-design-png-image_4472602.png",
            description = "Har Har Mahadev",
            onImageClick = {
                showToast(localContext, description, Toast.LENGTH_SHORT)
            }
        )
    }
}

fun showToast(ctx: Context, msg: String, length: Int) {
    Toast.makeText(ctx, msg, length).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidLibraryTheme {
        ShowImagePreview(description = "Android")
    }
}