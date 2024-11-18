package com.unirfp.imcapp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    //Creamos variables privadas para recoger los elementos visuales, inicializacion tardia (Lazy)
    private lateinit var  viewMale: CardView
    private lateinit var  viewFemale: CardView
    private lateinit var  tvHeight: TextView
    private lateinit var  rsHeight: RangeSlider
    private lateinit var  btnSubWeight: FloatingActionButton
    private lateinit var  btnPlusWeight: FloatingActionButton
    private lateinit var  tvWeight: TextView
    private lateinit var  btnSubAge: FloatingActionButton
    private lateinit var  btnPlusAge: FloatingActionButton
    private lateinit var  tvAge: TextView
    private lateinit var  btnImcCalculator: Button

    //Creamos los atributos necesarios para logica de nuestros componentes
    private var IsMaleSelected : Boolean = true
    private var IsFemaleSelected : Boolean = false
    private var currentWeight : Int = 45
    private var currentAge: Int = 23
    private var currentHeight : Double = 1.2 //metros

    //Creacion de un companion objetc que es accesible desde todas las activities
    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Nuestro codigo en el OnCreate

        //Para iniciar los componentes visuales
        initComponents()

        //Parara iniciar los listeners de los eventos
        initListeners()

        //Configuraciones visuales de los componentes
        initUI()
    }

    private fun initUI() {
        this.setWeight()
        this.setAge()
        this.setGenderColor()

    }

    private fun initListeners() {
        this.viewMale.setOnClickListener{
            if(!this.IsMaleSelected){
                this.changeGender()
                this.setGenderColor()
            }
        }

        this.viewFemale.setOnClickListener{
            if(!this.IsFemaleSelected){
                this.changeGender()
                this.setGenderColor()
            }
        }

        this.rsHeight.addOnChangeListener{_, value, _ ->
            this.currentHeight = (value / 100.0).toDouble() //metros
            //Definimos un formato
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            this.tvHeight.text = result + " cm"
        }

        this.btnSubWeight.setOnClickListener{
            this.currentWeight -= 1
            setWeight()
        }

        this.btnPlusWeight.setOnClickListener{
            this.currentWeight += 1
            setWeight()
        }

        this.btnSubAge.setOnClickListener{
            this.currentAge -= 1
            setAge()
        }

        this.btnPlusAge.setOnClickListener{
            this.currentAge += 1
            setAge()
        }

        this.btnImcCalculator.setOnClickListener{
            val resultIMC = calculateIMC()
            navigateToResult(resultIMC)
            //Navegacion

        }

    }

    private fun navigateToResult(resultIMC: Double) {
        //Creamos el objeto intent
        val intent = Intent(this, ResultIMCActivity::class.java)

        //Añadimos el extra para pasar el resultIMC
        intent.putExtra(IMC_KEY,resultIMC)

        this.startActivity(intent)
    }

    private fun calculateIMC(): Double {
        val imc = this.currentWeight / (this.currentHeight * this.currentHeight)
        val df = DecimalFormat("#.##")
        val result = df.format(imc).toDouble()
        Log.i("IMC", "El IMC es: $result")
        return result
    }

    private fun setAge() {
        this.tvAge.text = this.currentAge.toString()
    }

    private fun setWeight() {
        this.tvWeight.text = this.currentWeight.toString()
    }

    private fun initComponents() {
        this.viewMale = findViewById((R.id.viewMale))
        this.viewFemale = findViewById((R.id.viewFemale))
        this.tvHeight = findViewById(R.id.tvHeight)
        this.rsHeight = findViewById(R.id.rsHeight)
        this.btnSubWeight = findViewById(R.id.btnSubWeight)
        this.btnPlusWeight = findViewById(R.id.btnPlusWeight)
        this.tvWeight = findViewById(R.id.tvWeight)
        this.btnSubAge = findViewById(R.id.btnSubAge)
        this.btnPlusAge = findViewById(R.id.btnPlusAge)
        this.tvAge = findViewById(R.id.tvAge)
        this.btnImcCalculator = findViewById(R.id.btnCalc)

    }

    private fun changeGender(){
        this.IsMaleSelected = !this.IsMaleSelected
        this.IsFemaleSelected = !this.IsFemaleSelected
    }

    private fun setGenderColor(){
        this.viewMale.setCardBackgroundColor(this.getBackGroundColor(this.IsMaleSelected))
        this.viewFemale.setCardBackgroundColor(this.getBackGroundColor(this.IsFemaleSelected))
    }

    private fun getBackGroundColor(isSelectedComponet : Boolean) : Int {
        val colorReference = if(isSelectedComponet){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
}