package com.firuz.humotransfersample.Transfer

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.firuz.humotransfersample.databinding.LayoutTransferActivityBinding
import com.firuz.humotransfersample.mainScreen.MainActivity

class TransferActivity : AppCompatActivity() {

    private lateinit var binding: LayoutTransferActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutTransferActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.transferActBackToMainScreen.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        binding.numberCardTransfer.doAfterTextChanged() { s: Editable? ->

            val numberCard = s?.toString()
            if(numberCard?.length == 16 && binding.summaTransfer.text.toString().toFloatOrNull()!! in 1.0f..5400.0f){
                binding.btnApplyTransfer.setBackgroundColor(0xFFDD6018.toInt())
                binding.btnApplyTransfer.setTextColor(0xFFFFFFFF.toInt())
                binding.btnApplyTransfer.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            } else {
                binding.btnApplyTransfer.setTextColor(0xFF000000.toInt())
                binding.btnApplyTransfer.setBackgroundColor(0xFFE0E0E0.toInt())
            }
        }



    }
}
