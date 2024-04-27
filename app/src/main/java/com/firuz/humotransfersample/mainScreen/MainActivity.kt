package com.firuz.humotransfersample.mainScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.firuz.humotransfersample.ChooseCountry.ChooseCountryActivity
import com.firuz.humotransfersample.Login.LoginActivity
import com.firuz.humotransfersample.R
import com.firuz.humotransfersample.Transfer.TransferActivity
import com.firuz.humotransfersample.databinding.LayoutActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: LayoutActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendTransfer.setOnClickListener {
            val intent = Intent(this, ChooseCountryActivity::class.java)
            startActivity(intent)
        }
        binding.btnBackToLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}