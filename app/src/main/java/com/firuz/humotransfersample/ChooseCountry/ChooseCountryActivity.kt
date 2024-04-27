package com.firuz.humotransfersample.ChooseCountry

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firuz.humotransfersample.ChooseCountry.adapter.ChooseCountryAdapter
import com.firuz.humotransfersample.ChooseCountry.model.ChooseCountryModel
import com.firuz.humotransfersample.R
import com.firuz.humotransfersample.Transfer.TransferActivity
import com.firuz.humotransfersample.databinding.LayoutChooseCountryBinding
import com.firuz.humotransfersample.mainScreen.MainActivity
import java.util.Locale

class ChooseCountryActivity : AppCompatActivity() {

    private lateinit var binding: LayoutChooseCountryBinding
    private var countryModel = ArrayList<ChooseCountryModel>()
    private var adapter: ChooseCountryAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutChooseCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        dataCountry()
        adapter = ChooseCountryAdapter(countryModel)
        binding.recyclerView.adapter = adapter


        adapter?.onClickItem = {
            val intent = Intent(this, TransferActivity::class.java)
            intent.putExtra("item" , it)
            startActivity(intent)
        }


        binding.searchViewChooseCountry.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return false
            }

        })

    }

    private fun filterList(query: String?) {
        if (query != null){
            val filteredList = ArrayList<ChooseCountryModel>()
            for(country in countryModel){
                if(country.countryName.lowercase(Locale.ROOT).contains((query))){
                    filteredList.add(country)
                }

            }
            if(filteredList.isNotEmpty()){
                adapter?.setFilteredList(filteredList)
            } else{
                ArrayList<ChooseCountryModel>()
                Toast.makeText(this, "Ничего не найдено", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun dataCountry() {
        countryModel.add(ChooseCountryModel("Россия", R.drawable.flag_rus))
        countryModel.add(ChooseCountryModel("Таджикистан",R.drawable.flag_taj))
        countryModel.add(ChooseCountryModel("Узбекистан", R.drawable.flag_uzb))
        countryModel.add(ChooseCountryModel("Казахстан",R.drawable.flag_kz))
        countryModel.add(ChooseCountryModel("ОАЕ",R.drawable.flag_oae))
        countryModel.add(ChooseCountryModel("Корея",R.drawable.flag_korea))
        countryModel.add(ChooseCountryModel("Украина",R.drawable.flag_ukraina))
    }

}