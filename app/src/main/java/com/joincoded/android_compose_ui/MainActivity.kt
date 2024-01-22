package com.joincoded.android_compose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.joincoded.android_compose_ui.ui.theme.Android_Compose_UITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Compose_UITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Question("Haya is 23 years old?")
                  Button(onClick = { /*TODO*/ }) {
                      Text("next question")
                  }
                  Row {
                      Button(

                          onClick = { }) {
                          Text(text = "True")
                      }
                      Button(

                          onClick = { }) {
                          Text(text = "False")
                      }
                  }
                    }
                }

            }
        }
    }
}

@Composable
fun Question(question: String, fontSize: TextUnit = 25.sp, modifier: Modifier = Modifier) {
    Text(
        text = "$question!",
        modifier = modifier,
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_Compose_UITheme {
        Question("Android")
    }
}