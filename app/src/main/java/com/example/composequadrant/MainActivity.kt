package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        window.statusBarColor = android.graphics.Color.parseColor(getString(R.string.customColor1))
        setContent {
            ComposeQuadrantTheme {
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
    Column{
        Row(Modifier.weight(1f)) {
            ContentColumn(modifier = modifier.weight(1f) , title = stringResource(R.string.contentTitle1), description = stringResource(
                R.string.contentDescription1
            ), Color.Red)
            ContentColumn(modifier = modifier.weight(1f), title = stringResource(R.string.contentTitle2), description = stringResource(
                R.string.contentDescription2
            ), Color.Cyan)
        }

        Row(Modifier.weight(1f)){
            ContentColumn(modifier = modifier.weight(1f), title = stringResource(R.string.contentTitle3), description = stringResource(
                R.string.contentDescription3
            ), Color.Blue)
            ContentColumn(modifier = modifier.weight(1f), title = stringResource(R.string.contentTitle4), description = stringResource(
                R.string.contentDescription4
            ), Color.Yellow)
        }
    }

}


@Composable
private fun ContentColumn(modifier: Modifier = Modifier, title: String, description: String, color: Color) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color)
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(bottom = 20.dp))
        Text(text = description, textAlign = TextAlign.Justify)
    }
}



