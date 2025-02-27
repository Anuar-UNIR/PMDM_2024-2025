package com.unirfp.usersretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.unirfp.usersretrofit.databinding.ActivityMainBinding
import com.unirfp.usersretrofit.model.ResponseUser
import com.unirfp.usersretrofit.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    private lateinit var adapter: UserAdapter
    private val usersList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
        fetchUsers("users/?page=0")
    }

    private fun initRecyclerView() {
        adapter = UserAdapter((usersList))
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://peticiones.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Manejar asincronamente con corrutinas
    private fun fetchUsers(query : String){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<ResponseUser> = getRetrofit()
                .create(ApiService::class.java)
                .getAllUsers(query);

            val response :ResponseUser? = call.body()

            runOnUiThread {
                if(call.isSuccessful){
                    val usersL = response?.results?: emptyList() //clave recoger los datos de la api que queremos, users
                    usersList.clear()
                    usersList.addAll(usersL)
                    adapter.notifyDataSetChanged()

                }else{
                    showError()
                }
            }

        }
    }


    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}