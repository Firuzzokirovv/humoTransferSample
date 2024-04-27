package com.firuz.humotransfersample.Login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.widget.doAfterTextChanged
import com.firuz.humotransfersample.R

import com.firuz.humotransfersample.databinding.LayoutLoginBinding
import com.firuz.humotransfersample.mainScreen.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LayoutLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.loginCloseApp.setOnClickListener{
            finish()
        }



        binding.loginCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && binding.loginRegisterPhoneNumber.text?.length == 9) {
                binding.loginContinueButton.setBackgroundColor(0xFFDD6018.toInt())
                binding.loginContinueButton.setTextColor(0xFFFFFFFF.toInt())
                binding.loginContinueButton.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

        } else {
                binding.loginContinueButton.setBackgroundColor(0xFFE0E0E0.toInt())
                binding.loginContinueButton.setTextColor(0xFF000000.toInt())
            }

        binding.loginRegisterPhoneNumber.doAfterTextChanged() { s: Editable? ->

            val phoneNumber = s?.toString()
            if(phoneNumber?.length == 9 && binding.loginCheckbox.isChecked){
                binding.loginContinueButton.setBackgroundColor(0xFFDD6018.toInt())
                binding.loginContinueButton.setTextColor(0xFFFFFFFF.toInt())
                binding.loginContinueButton.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    }
            } else {
                binding.loginContinueButton.setTextColor(0xFF000000.toInt())
                binding.loginContinueButton.setBackgroundColor(0xFFE0E0E0.toInt())
            }
    }




    }
}
}

