package com.unirfp.imcapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.unirfp.imcapp.MainActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalcularIMC: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultIMC = intent.extras?.getDouble(IMC_KEY)?: -1.0

        initComponents()

        initListenners()

        initUI(resultIMC)
    }

    private fun initUI(resultIMC: Double) {
        this.tvIMC.text = resultIMC.toString()
        when(resultIMC){
            in 0.00..18.50 -> { //Bajo Peso
                this.tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                this.tvResult.text = "Bajo peso"
                this.tvDescription.text = "Tu peso esta por debajo de lo optimo"
            }

            in 18.51..24.99 -> { //Peso Normal
                this.tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                this.tvResult.text = "Normal"
                this.tvDescription.text = "Peso Saludable"
            }
            in 25.00..29.99 -> { //SobrePeso
                this.tvResult.setTextColor(ContextCompat.getColor(this,R.color.sobre_peso))
                this.tvResult.text = "Sobrepeso"
                this.tvDescription.text = "Tu peso esta algo por encima de lo optimo"
            }
            in 30.00..99.00 -> { //Obesidad
                this.tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                this.tvResult.text = "Obesidad"
                this.tvDescription.text = "Tu peso esta muy por encima de lo optimo y saludable"
            }
            else ->{
                this.tvResult.setTextColor(ContextCompat.getColor(this,R.color.error))
                this.tvIMC.text = getString(R.string.error)
                this.tvResult.text = getString(R.string.error)
                this.tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initListenners() {
        this.btnReCalcularIMC.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initComponents() {
        this.tvIMC = findViewById(R.id.tvIMC)
        this.tvResult = findViewById(R.id.tvResult)
        this.tvDescription = findViewById(R.id.tvDescription)
        this.btnReCalcularIMC = findViewById(R.id.btnReCalc)
    }
}