package com.unirfp.ejemploretrofitclase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.unirfp.ejemploretrofitclase.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var  binding : ActivityMainBinding

    private lateinit var  adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        this.initRecyclerView()
        //this.searchByBreed("malamute")
        binding.svDogs.setOnQueryTextListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }


    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Funcion con llamada asincrona con corrutinas
    private fun searchByBreed(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<DogsResponse> = getRetrofit()
                .create(ApiService::class.java)
                .getDogsByBreed("$query/images")

            val puppies: DogsResponse? = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    val images = puppies?.imagenes ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                /*  if(puppies != null){
                        for(image : String in puppies.imagenes){
                            Log.v("Query API", image)
                        }

                    } */

                }else{
                    showError()
                }
            }

        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error con la petición", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            this.searchByBreed(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


}