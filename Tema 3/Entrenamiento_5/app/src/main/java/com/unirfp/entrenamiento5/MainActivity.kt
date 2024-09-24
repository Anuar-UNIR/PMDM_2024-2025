package com.unirfp.entrenamiento5

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
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

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

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


    private var isMaleSelected :Boolean = true
    private var isFemaleSelected :Boolean = false
    private var currentWeight = 45
    private var currentAge: Int = 23
    private var currentHeight: Double = 1.2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI()
    }



    private fun initComponents() {
        this.viewMale = findViewById(R.id.viewMale)
        this.viewFemale = findViewById(R.id.viewFemale)
        this.tvHeight = findViewById(R.id.tvHeight)
        this.rsHeight = findViewById(R.id.rsHeight)
        this.btnSubWeight = findViewById(R.id.btnSubtWeight)
        this.btnPlusWeight = findViewById(R.id.btnPlustWeight)
        this.tvWeight = findViewById(R.id.tvWeight)
        this.btnSubAge = findViewById(R.id.btnSubtAge)
        this.btnPlusAge = findViewById(R.id.btnPlustAge)
        this.tvAge = findViewById(R.id.tvAge)
        this.btnImcCalculator = findViewById(R.id.btnCalc)
    }

    private fun initListeners() {
        this.viewMale.setOnClickListener{
            if(!this.isMaleSelected) {
                changeGender()
            }
            setGenderColor()
        }
        this.viewFemale.setOnClickListener{
            if(!this.isFemaleSelected){
                changeGender()
            }
            setGenderColor()
        }

        this.rsHeight.addOnChangeListener {_, value, _ ->
            this.currentHeight = (value / 100.0).toDouble()
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = result + " cm"
        }

        this.btnPlusWeight.setOnClickListener{
            this.currentWeight += 1
            setWeight()

        }

        this.btnSubWeight.setOnClickListener{
            this.currentWeight -= 1
            setWeight()

        }

        this.btnPlusAge.setOnClickListener{
            this.currentAge += 1
            setAge()

        }

        this.btnSubAge.setOnClickListener{
            this.currentAge -= 1
            setAge()

        }

        this.btnImcCalculator.setOnClickListener{
            val resultIMC = calculateIMC()
            navigateToResult(resultIMC)
        }

    }

    private fun navigateToResult(resultIMC: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, resultIMC)
        this.startActivity(intent)

    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = this.currentWeight / (this.currentHeight * this.currentHeight)
        val result = df.format(imc).toDouble()
        Log.i("ANUAR", "El IMC es : $result")
        return result
    }

    private fun setWeight() {
        this.tvWeight.text = this.currentWeight.toString()
    }

    private fun setAge() {
        this.tvAge.text = this.currentAge.toString()

    }

    private fun changeGender(){
        this.isMaleSelected = !this.isMaleSelected
        this.isFemaleSelected = !this.isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(this.getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(this.getBackgroundColor(isFemaleSelected))

    }

    private fun getBackgroundColor(isSelectedComponet: Boolean): Int {

        val colorReference = if(isSelectedComponet){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        this.setGenderColor()
        this.setWeight()
        this.setAge()

    }



    //Continuar 5h 49minutos

}