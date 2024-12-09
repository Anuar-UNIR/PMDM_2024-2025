package com.unirfp.applogin_04_11_2024

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.unirfp.applogin_04_11_2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.binding.loginButton.setOnClickListener {
            val usuario = this.binding.emailET
            val password = this.binding.passwordET

            if(usuario.text.isNotEmpty() && password.text.isNotEmpty()){
                //Log.i("LOGIN",usuario.text.toString())
                //Log.i("LOGIN", password.text.toString())

                //Navegar a la siguiente view
                val intent = Intent(this, ResultLoginActivity::class.java)

                //Añadimos los valores o paramentros que queremos pasar a la otra activity
                intent.putExtra("user", usuario.text.toString())
                intent.putExtra("password", password.text.toString())


                //Iniciamos la otra activity
                startActivity(intent)
            }
            else{
                usuario.setHintTextColor(Color.RED)
                usuario.setHint("Debe de rellenar esta campo")
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }



}