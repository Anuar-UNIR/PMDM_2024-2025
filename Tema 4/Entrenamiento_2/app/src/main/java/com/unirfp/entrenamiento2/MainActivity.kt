package com.unirfp.entrenamiento2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.unirfp.entrenamiento2.ui.theme.Entrenamiento2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Entrenamiento2Theme  {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyConstraintLayout( modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier){
    ConstraintLayout (modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxGreen, boxMagenta, boxGray, boxCyan) = createRefs()

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })

        Box(modifier = Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })

        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.start)
        })

        Box(modifier = Modifier.size(125.dp).background(Color.Gray).constrainAs(boxGray){
            end.linkTo(boxMagenta.start)
            top.linkTo(boxMagenta.bottom)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Cyan).constrainAs(boxCyan){
            start.linkTo(boxMagenta.end)
            top.linkTo(boxMagenta.bottom)
        })
    }
}

@Composable
fun MySpacer(size : Int){
    Spacer(modifier = Modifier.height(size.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyComplexLayoutPreview() {
    Entrenamiento2Theme {
        MyConstraintLayout()
    }
}