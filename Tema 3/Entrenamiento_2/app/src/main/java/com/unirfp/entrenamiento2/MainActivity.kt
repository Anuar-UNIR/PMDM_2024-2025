package com.unirfp.entrenamiento2

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Recogemos el button y capturamos su evento
        findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.loginButton)
            .setOnClickListener {
                //Recogemos los componentes EditText
                val usuario = findViewById<EditText>(R.id.userET);
                val password = findViewById<EditText>(R.id.passwordET);

                //Mostramos sus valores por el log
                Log.i("AnuarKhan","Pulsado")
                Log.i("AnuarKhan","User: "+usuario.text)
                Log.i("AnuarKhan","Password: "+password.text)
            }
    }
}