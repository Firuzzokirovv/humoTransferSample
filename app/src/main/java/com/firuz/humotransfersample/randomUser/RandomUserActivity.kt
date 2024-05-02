package com.firuz.humotransfersample.randomUser

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firuz.humotransfersample.databinding.LayoutRandomUserBinding
import com.firuz.humotransfersample.randomUser.adapter.RandomUserAdapter
import com.firuz.humotransfersample.randomUser.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class RandomUserActivity : AppCompatActivity() {

    private lateinit var binding: LayoutRandomUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LayoutRandomUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.root.layoutManager = LinearLayoutManager(this)

        RandomUserRetrofitApi.getUser().enqueue(object : Callback<User> {
            override fun onResponse(p0: Call<User>, p1: Response<User>) {

                if (p1.isSuccessful) {
                    val resultList = p1.body()?.results ?: emptyList()
                  binding.root.adapter = RandomUserAdapter(resultList)
                    Log.d("TAG_TEST", "isSuccessful: ${resultList}")
                    Log.d("TAG_TEST", "isSuccessful: ${resultList.size}")



                } else {
//                    binding.textviewRandomUser.text = "!isSuccessful: что то пошло не так"
                    Log.d("TAG_TEST", "!isSuccessful: что то пошло не так")
                }
            }

            override fun onFailure(p0: Call<User>, p1: Throwable) {
//                binding.textviewRandomUser.text = "вообще что то пошло не так ${p1.message}"
                Log.d("TAG_TEST", "onFailure: вообще что то пошло не так ${p1.message}")
            }
        })



    }

}

