package com.unirfp.entrenamiento3

import android.content.Intent
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

        findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.loginButton)
            .setOnClickListener {
                val usuario = findViewById<EditText>(R.id.userET);
                val password = findViewById<EditText>(R.id.passwordET);

                //Comprobamos que  los textview esten rellenos, podiamos comprobar el formato de un email
                if(usuario.text.isNotEmpty() && password.text.isNotEmpty())

                    //Creamos un objeto de Intent, el cual nos permite gestionar el cambio de ventana
                    val intent = Intent(this, ResultLoginActivity::class.java)

                    //Añadimos los valores o parametros que queremos pasar a la otra ventana
                    intent.putExtra("user", usuario.text.toString())
                    intent.putExtra("password", password.text.toString())

                    Log.i("LOGIN", usuario.text.toString())
                    Log.i("LOGIN", password.text.toString())

                    //Iniciamos la otra ventana
                    startActivity(intent)
                }
            }
    }
}