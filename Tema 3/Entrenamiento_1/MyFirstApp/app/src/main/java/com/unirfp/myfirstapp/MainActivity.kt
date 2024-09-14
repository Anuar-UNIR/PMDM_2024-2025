package com.unirfp.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var pulsaciones = 0
        val btnPulsame = findViewById<Button>(R.id.btnPulsame)
        btnPulsame.setOnClickListener {

            Log.i("AnuarKhan", "Boton pulsado $pulsaciones veces")
            val texto = findViewById<TextView>(R.id.textBox)
            texto.text = "N: $pulsaciones"
            pulsaciones++

        }
    }

}