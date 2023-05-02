package com.dev.jetpackcomponentscatalog

import android.os.Bundle
import android.os.DropBoxManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.jetpackcomponentscatalog.ui.data.CheckInfo
import com.dev.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val myOptions = getOptions(listOf("Aries", "Example", "Kotlin"))

                    var selected by rememberSaveable {
                        mutableStateOf("Aris")
                    }

                    //MyText()
                    //MyTextField()
                    //MyTriStatusCheckBox()
                    //MyRadioButtonList(name = selected, onItemSelected = { selected = it })
                    //myOptions.forEach {
                    // MyCheckBoxWithTextCompleted(it)
                    //}

                    //MyCard()
                    //MyBadgeBox()
                    //MyDropDownMenu()
                    Column {
                        //BasicSlider()
                        //AdvancedSlider()
                        RangeSlider()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComponentsCatalogTheme {
        //MyText()
        //MyTextField()
        //MySwitch()
        //MyCheckBoxWithText()
        //MyCheckBoxWithTextCompleted()
        //MyTriStatusCheckBox()
        //MyRadioButton()
        //MyRadioButtonList()
        //MyCard()
        //MyBadgeBox()
        //MyDivider()
        MyDropDownMenu()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val list = listOf("cafe", "frutas", "chiles", "donas")

    Column(
        Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = !expanded }
                .fillMaxWidth()
                .padding(20.dp),
            label = { Text(text = "Select Item") }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            list.forEach { x ->
                DropdownMenuItem(
                    text = { Text(text = x) },
                    onClick = {
                        expanded = !expanded
                        selectedText = x
                    },
                )
            }
        }
    }
}


@Composable
fun MyDivider() {
    Column() {
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), color = Color.Red
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BadgedBox(badge = {
            Text(
                "8",
                modifier = Modifier
                    .background(Color.Red, shape = CircleShape)
                    .padding(1.dp)
                    .align(Alignment.CenterEnd)
                    .width(20.dp)
                    .height(20.dp),
                color = Color.White
            )
        }) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Favorite"
            )
        }
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(
                elevation = 12.dp,
                ambientColor = Color.Blue,
                //spotColor = Color.DarkGray,
                shape = MaterialTheme.shapes.medium
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White),

        ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Example one")
            Text(text = "Example one")
            Text(text = "Example one")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Aris", onClick = { onItemSelected("Aris") })
            Text(text = "Aris")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Jose", onClick = { onItemSelected("Jose") })
            Text(text = "Jose")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Cristofer", onClick = { onItemSelected("Cristofer") })
            Text(text = "Cristofer")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Marcos", onClick = { onItemSelected("Marcos") })
            Text(text = "Marcos")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "Luis", onClick = { onItemSelected("Luis") })
            Text(text = "Luis")
        }

        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = name)
        }
    }
}


@Composable
fun MyRadioButton() {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(
                selected = false,
                onClick = { },
                enabled = false,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledSelectedColor = Color.Green,
                )
            )
            Text(text = "Texto de ejemplo")
        }
    }
}


@Composable
fun getOptions(title: List<String>): List<CheckInfo> {

    return title.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}


@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title + " " + checkInfo.selected.toString())
    }

}


@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.padding(8.dp)) {
            Checkbox(checked = state, onCheckedChange = { state = !state })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = state.toString())
        }
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Text(text = state.toString())
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.DarkGray,
                checkedThumbColor = Color.Green,
                uncheckedTrackColor = Color.Magenta,
                checkedTrackColor = Color.Cyan
            )
        )
        Text(text = state.toString())
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

        TextField(value = myText2, onValueChange = {
            myText2 = if (it.contains(("a"))) {
                it.replace("a", "")
            } else {
                it
            }
        }, label = {
            Text(text = "Ingresa tu nombre")
        }, modifier = Modifier.fillMaxWidth()
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
                focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Blue
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
            text = "Example", color = Color.Black, fontWeight = FontWeight.Light, style = TextStyle(
                fontFamily = FontFamily.Cursive, textDecoration = TextDecoration.Underline
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