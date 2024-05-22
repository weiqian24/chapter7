package com.example.chapter7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chapter7.ui.theme.Chapter7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter7Theme {
                Scaffold(
                    Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "今天星期三",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var msg by remember { mutableStateOf("行動應用軟體開發")}


    Column {
        Button(
            onClick = {
                if (msg == "行動應用軟體開發"){
                    msg = "Android App"
                }
                else{
                    msg = "行動應用軟體開發"
                }
            }
        ) {
            Text(text = msg)
        }


        Button(onClick = {
            //your onclick code here
            }
            , colors = buttonColors(Color.Blue),
            shape = RoundedCornerShape(20.dp)

        ) {
            Image(
                painterResource(id = R.drawable.animal0),
                contentDescription ="button icon",
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "Click ",
                color = Color.Magenta
            )
            Text(
                text = "Here",
                color = Color.Green
            )


        }

        Row {
            Text(
                text = "$name",
                fontFamily = FontFamily(Font(R.font.kai)),
                fontSize = 25.sp,
                color = Color.Blue,
                modifier = modifier
            )

            Image(
                painter = painterResource(id = R.drawable.compose),
                contentDescription = "圖片",
                alpha = 0.7f,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            var count by remember { mutableStateOf(0) }
            Text(
                text = count.toString(),
                fontSize = 50.sp ,
                modifier = Modifier.clickable { count += 1 })



        }

    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chapter7Theme {
        Greeting("Android")
    }
}