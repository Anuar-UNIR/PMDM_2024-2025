package com.unirfp.ejemploconstraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier){
    ConstraintLayout (modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxGreen, boxMagenta, boxGray, boxCyan) = createRefs()

        val myRow = createRef()
        val myColumn = createRef()

        Box(modifier = Modifier.size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed){
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
            top.linkTo(boxRed.top)
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

        Row (modifier = Modifier.fillMaxWidth().constrainAs(myRow){
            start.linkTo(boxGray.start)
            top.linkTo(boxCyan.bottom)
        }){
            Box(modifier = Modifier.size(125.dp).background(Color.Blue))
            Box(modifier = Modifier.size(125.dp).background(Color.Yellow))
            Box(modifier = Modifier.size(125.dp).background(Color.Black))

        }

        Column (modifier = Modifier.fillMaxWidth().constrainAs(myColumn){
            start.linkTo(boxGreen.start)
            top.linkTo(parent.top)
            bottom.linkTo(boxBlue.top)
            end.linkTo(boxBlue.end)
        }){
            Box(modifier = Modifier.size(75.dp).background(Color.Cyan))
            Box(modifier = Modifier.size(75.dp).background(Color.Yellow))
            Box(modifier = Modifier.size(75.dp).background(Color.LightGray))

        }

    }
}