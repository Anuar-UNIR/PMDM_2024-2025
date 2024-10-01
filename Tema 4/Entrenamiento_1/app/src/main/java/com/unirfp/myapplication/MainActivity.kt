package com.unirfp.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.unirfp.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyComplexLayout( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout(modifier: Modifier = Modifier){
    Column (Modifier.fillMaxSize()){
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Cyan),
            contentAlignment = Alignment.CenterEnd){
            Text("Entrenamiento 1!!!!")
        }
        Row(Modifier.fillMaxWidth().weight(1f)){
            Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Red),
                contentAlignment = Alignment.TopCenter)
            {
                Text("Entrenamiento 1!!!!")
            }
            Box(modifier = Modifier.weight(1f)
                .fillMaxHeight()
                .background(Color.Gray),
                contentAlignment = Alignment.Center
                )
            {
                Text("Entrenamiento 1!!!!")
            }

        }
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Green)
        ,contentAlignment = Alignment.BottomCenter){
            Text("Entrenamiento 1!!!!")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyComplexLayoutPreview() {
    MyApplicationTheme {

        MyComplexLayout()
    }
}