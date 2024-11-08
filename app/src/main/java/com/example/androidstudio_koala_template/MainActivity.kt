package com.example.androidstudio_koala_template

import android.os.Bundle
import android.util.Half.toFloat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidstudio_koala_template.ui.theme.AndroidStudioKoalaTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStudioKoalaTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var selectedText: String by remember { mutableStateOf("") }
    var expanded: Boolean by remember { mutableStateOf(false) }
    val icons = listOf(
        "ThumbUp" to Icons.Default.ThumbUp,
        "Star" to Icons.Default.Star,
        "Delete" to Icons.Default.Delete,
        "AccountBox" to Icons.Default.AccountBox,
        "CheckCircle" to Icons.Default.CheckCircle,
        "Email" to Icons.Default.Email,
        "Call" to Icons.Default.Call,
        "Create" to Icons.Default.Create,
        "Add" to Icons.Default.Add,
        "Favorite" to Icons.Default.Favorite
    )
    var min by remember { mutableStateOf("") }
    var max by remember { mutableStateOf("") }
    var currentRange: Float by remember { mutableStateOf(0f) }

    Text(
        text = "Repte 01",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding().padding(start = 16.dp)
    )

    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier.clickable { expanded = true }
                .fillMaxWidth(fraction = 0.9f)
                .padding(top = 48.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(fraction = 0.8f)
                .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                .padding(top = 48.dp)
        ) {
            icons.forEach { (text, icon) ->
                DropdownMenuItem(
                    text = { Text(text = text) },
                    onClick = {
                        expanded = false
                        selectedText = text
                    }
                )
            }
        }

        Row (
            modifier = modifier.fillMaxWidth()
        ) {
            Column (
                modifier = modifier.padding(top = 16.dp, start = 32.dp).fillMaxWidth(fraction = 0.4f)
            ) {
                Text(
                    text = "Min:",
                )
                TextField(
                    value = min,
                    onValueChange = { min = it },
                    label = { Text(text = "0") },
                    modifier = modifier.width(64.dp)
                )
            }

            Column (
                modifier = modifier.padding(top = 16.dp, start = 32.dp).fillMaxWidth(fraction = 0.4f)
            ) {
                Text(
                    text = "Max:",
                )
                TextField(
                    value = max,
                    onValueChange = { max = it },
                    label = { Text(text = "10") },
                    modifier = modifier.width(64.dp)
                )
            }
        }

        /*RangeSlider(value = currentRange,
            onValueChange = { currentRange = it },
            valueRange = min.toFloat()..max.toFloat())
        Text(text = "${currentRange}")*/
    }
}

@Preview(showBackground = true
    , showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidStudioKoalaTemplateTheme {
        Greeting()
    }
}