package com.mytests

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.mytests.test_exam.presentation.ExamScaffold
import com.mytests.ui.theme.MyTestsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestsTheme {
                Surface(Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    ExamScaffold { message: String ->
                        Toast.makeText(this@MainActivity,message,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}