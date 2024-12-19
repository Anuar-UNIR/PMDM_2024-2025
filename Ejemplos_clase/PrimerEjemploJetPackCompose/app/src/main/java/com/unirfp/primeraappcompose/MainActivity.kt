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
                    MyComplexLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun MyComplexLayout(modifier: Modifier = Modifier){
    Column (Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxSize().weight(1f)) {
            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Cyan),
                contentAlignment = Alignment.Center){
                Text("Soy una caja en una columna")
            }

            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Green),
                contentAlignment = Alignment.Center){
                Text("Soy una caja en una columna")
            }

            Row(Modifier.fillMaxSize().weight(1f)){
                Box(Modifier.fillMaxSize()
                    .weight(1f)
                    .background(Color.Magenta),
                    contentAlignment = Alignment.Center){
                    Text("Soy una caja en una columna dentro de una fila")
                }

                Box(Modifier.fillMaxSize()
                    .weight(1f)
                    .background(Color.LightGray),
                    contentAlignment = Alignment.Center){
                    Text("Soy una caja en una columna dentro de una fila")
                }

                Box(Modifier.fillMaxSize()
                    .weight(1f)
                    .background(Color.Yellow),
                    contentAlignment = Alignment.Center){
                    Text("Soy una caja en una columna dentro de una fila")
                }
            }

            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Transparent),
                contentAlignment = Alignment.Center){
                Text("Soy una caja en una columna")
            }

        }

        
        Row(Modifier.fillMaxSize().weight(1f)){
            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Red),
                contentAlignment = Alignment.TopCenter){
                Text("Soy una caja en una fila")
            }

            Box(Modifier.fillMaxSize()
                .weight(1f)
                .background(Color.Gray),
                contentAlignment = Alignment.BottomEnd){
                Text("Soy una caja en una fila")
            }

            Column(Modifier.fillMaxSize().weight(1f)) {
                Box(Modifier.fillMaxSize()
                    .weight(1f)
                    .background(Color.Blue),
                    contentAlignment = Alignment.TopEnd){
                    Text("Soy una caja en una fila")
                }

                Box(Modifier.fillMaxSize()
                    .weight(1f)
                    .background(Color.Green),
                    contentAlignment = Alignment.TopEnd){
                    Text("Soy una caja en una fila")
                }

                Box(Modifier.fillMaxSize()
                    .weight(1f)
                    .background(Color.Transparent),
                    contentAlignment = Alignment.TopEnd){
                    Text("Soy una caja en una fila")
                }
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


