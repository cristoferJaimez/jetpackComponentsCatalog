package com.dev.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyText()
                    MyTextField()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComponentsCatalogTheme {
        //MyText()
        MyTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }

    var myText2 by remember {
        mutableStateOf("")
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(value = myText, onValueChange = { myText = it }, placeholder = {})

        Spacer(
            modifier = Modifier
                .width(0.dp)
                .height(10.dp)
        )

        TextField(value = myText2,
            onValueChange = {
                myText2 = if (it.contains(("a"))) {
                    it.replace("a", "")
                } else {
                    it
                }
            },
            label = {
                Text(text = "Ingresa tu nombre")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .width(0.dp)
                .height(10.dp)
        )

        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 24.dp),
            label = { Text(text = "Ingresa tu nombre") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue
            )
        )
    }
}

@Composable
fun MyText() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Example")
        Text(text = "Example", color = Color.Blue)
        Text(text = "Example", color = Color.Red, fontWeight = FontWeight.Light)
        Text(
            text = "Example",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(
            text = "Example",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            style = TextStyle(fontFamily = FontFamily.Default)
        )
        Text(
            text = "Example",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            style = TextStyle(fontFamily = FontFamily.Monospace)
        )
        Text(
            text = "Example",
            color = Color.Black,
            fontWeight = FontWeight.Light,
            style = TextStyle(
                fontFamily = FontFamily.Cursive,
                textDecoration = TextDecoration.Underline
            )
        )
        Text(
            text = "Example", color = Color.Black, fontWeight = FontWeight.Light, style = TextStyle(
                fontFamily = FontFamily.Cursive, textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )

        Text(text = "Example", fontSize = 30.sp, fontFamily = FontFamily.Cursive)
    }
}