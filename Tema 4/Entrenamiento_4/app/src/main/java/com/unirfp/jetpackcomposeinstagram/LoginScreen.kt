package com.unirfp.jetpackcomposeinstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen (name: String, modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize().padding(16.dp)){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }

}

@Composable
fun Footer(modifier: Modifier) {
    Column (modifier = modifier.fillMaxWidth()){
        HorizontalDivider(
            Modifier.background(Color(0XFF9F9F9)).height(1.dp).fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        SignUp()
        Spacer(modifier = Modifier.size(16.dp))
    }


}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        Text(text = "Don´t have  an account?", fontSize = 12.sp, color = Color(0xFFB5B5B5))
        Text(text = "Sign up", Modifier.padding(horizontal = 8.dp), fontSize = 12.sp,
        fontWeight = FontWeight.Bold, color = Color(0xFF4EA8E9)
        )

    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable { mutableStateOf(false) }
    
    Column(modifier = modifier){
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email, {email = it})
        Spacer(modifier = Modifier.size(8.dp))
        Password(password, {password = it})
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(32.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(48.dp))
        SocialLogin()

    }
}

@Composable
fun SocialLogin() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =  Arrangement.Center){
        Image(painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social login FB", modifier = Modifier.size(16.dp))
        Text(text = "Continue as Android Develop", fontSize = 14.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        HorizontalDivider(
            Modifier.background(Color(0XFF9F9F9)).height(1.dp).weight(1f)
        )
        Text(
            text = "OR", modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold, color = Color(0xFFB5B5B5)
        )
        HorizontalDivider(
            Modifier.background(Color(0XFF9F9F9)).height(1.dp).weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(onClick =  { }, enabled = loginEnable, modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(

        )){
        Text(text = "Log In")

    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "Forgot password", fontSize = 12.sp, fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9), modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(text = "Email")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    TextField(value = password, onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text(text = "Password")},
        maxLines = 1,
        singleLine = true,
        keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        ),

    )
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "logo", modifier = modifier)
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close, contentDescription = "close app",
        modifier = modifier.clickable { activity.finish() })
}
