package com.joincoded.android_compose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
                    MyScreen()
                }

            }
        }
    }
}

@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    val questions = listOf("My name is haya ?", "Haya is a doctor?", "Is haya 26 years old?")
    val answers = listOf(true, false, true)
    var showNextQuestion by remember { mutableStateOf(false) }
    var showWrongAnswer by rememberSaveable { mutableStateOf(false) }
    var showCorrectAnswer by remember { mutableStateOf(false) }
    var currentQuestion by remember { mutableStateOf(0) }
    var showAnswerOptionRow by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = questions[currentQuestion])

        if (showWrongAnswer) {
            ResultAnswer(text = "wrong answer", color = Color.Red)
        }

        if (showCorrectAnswer) {
            ResultAnswer(text = "correct answer", color = Color.Green)
        }

        if (showNextQuestion) {
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (currentQuestion == questions.size - 1)
                        currentQuestion = 0
                    else
                        currentQuestion++
                    showNextQuestion = false
                    showCorrectAnswer = false
                    showAnswerOptionRow = true
                }) {
                Text("next question")
            }
        }

        if (showAnswerOptionRow) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = Modifier.weight(1f),
                    onClick = {
                        var isAnswerCorrect = true == answers[currentQuestion]
                        if (isAnswerCorrect) {
                            showCorrectAnswer = true
                            showNextQuestion = true
                            showAnswerOptionRow = false
                            showWrongAnswer = false
                        } else {
                            showWrongAnswer = true
                        }
                    }) {
                    Text("True")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(modifier = Modifier.weight(1f),
                    onClick = {
                        var isAnswerCorrect = false == answers[currentQuestion]
                        if (isAnswerCorrect) {
                            showCorrectAnswer = true
                            showNextQuestion = true
                            showAnswerOptionRow = false
                            showWrongAnswer = false
                        } else {
                            showWrongAnswer = true
                        }
                    }) {

                    Text("False")
                }
            }
        }

    }
}

@Composable
fun ResultAnswer(text: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(color)
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center)
        )
    }

}



