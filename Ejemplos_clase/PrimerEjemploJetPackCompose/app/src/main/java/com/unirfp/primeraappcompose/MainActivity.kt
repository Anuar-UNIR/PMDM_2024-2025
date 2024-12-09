package com.unirfp.primeraappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import com.unirfp.primeraappcompose.ui.theme.PrimeraAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PrimeraAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun MyComplexLayout(modifier: Modifier = Modifier){
    Column (Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxSize()
            .weight(1f)
            .background(Color.Cyan),
            contentAlignment = Alignment.Center){
            Text("Primer ejemplo de compose")
        }
        
        Row(Modifier.fillMaxSize().weight(1f)){
            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Red),
                contentAlignment = Alignment.TopCenter){
                Text("Primer ejemplo de compose")
            }

            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Gray),
                contentAlignment = Alignment.BottomEnd){
                Text("Primer ejemplo de compose")
            }

            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Blue),
                contentAlignment = Alignment.TopEnd){
                Text("Primer ejemplo de compose")
            }

        }

    }
}


//Preview para probar nuestra primera funcion composable
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun MyComplexLayoutPreview(){
    PrimeraAppComposeTheme {
        MyComplexLayout()
    }
}


