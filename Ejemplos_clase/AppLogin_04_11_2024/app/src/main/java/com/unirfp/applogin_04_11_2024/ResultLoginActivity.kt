package com.unirfp.applogin_04_11_2024

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recogemos el textView
        val resultTV = findViewById<TextView>(R.id.resultTVLogin)

        //Recoger los putExtra de la activity anterior
        val user: String = intent.extras?.getString("user").orEmpty()
        val password: String = intent.extras?.getString("password").orEmpty()

        //Modificamos el contenido del resultTV
        resultTV.text = "Se ha logueado correctamente \n Usuario: $user \n Contraseña: $password"
    }

}