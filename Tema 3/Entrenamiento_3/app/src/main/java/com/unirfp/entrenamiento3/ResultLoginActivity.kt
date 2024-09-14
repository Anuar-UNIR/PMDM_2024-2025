package com.unirfp.entrenamiento3

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
        val resultTv = findViewById<TextView>(R.id.resultTV)

        //Mediante el intent accedemos a los extras y los recogemos
        //Tenemos que manejar la posibilidad que sea null
        val user: String = intent.extras?.getString("user").orEmpty().toString()
        val password: String = intent.extras?.getString("password").orEmpty().toString()

        //Modificamos el texto del resultTV
        resultTv.text = "Se ha logueado correctamente \n Usuario: $user \n Contraseña: $password"



    }
}