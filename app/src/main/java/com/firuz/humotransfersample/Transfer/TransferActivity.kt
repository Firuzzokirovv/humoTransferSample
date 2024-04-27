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



        binding.summaTransfer.doAfterTextChanged() { s: Editable? ->

            val isSumma = s.toString().toFloatOrNull()!! in (1.0F..5400.0F)
            val isNumberCard = binding.numberCardTransfer.text.length == 16
            binding.btnApplyTransfer.isEnabled = isSumma && isNumberCard

            if (binding.btnApplyTransfer.isEnabled){
                binding.btnApplyTransfer.setBackgroundColor(0xFFDD6018.toInt())
                binding.btnApplyTransfer.setTextColor(0xFFFFFFFF.toInt())
                binding.btnApplyTransfer.setOnClickListener {
                    Toast.makeText(this, "Перевод успешно завершенно", Toast.LENGTH_SHORT).show()
                }
            } else {
                binding.btnApplyTransfer.setTextColor(0xFF000000.toInt())
                binding.btnApplyTransfer.setBackgroundColor(0xFFE0E0E0.toInt())
            }
        }


            binding.numberCardTransfer.doAfterTextChanged() { s: Editable? ->

                val isNumberCard = s?.length == 16
                val isSumma = binding.summaTransfer.text.toString().toFloatOrNull()!! in 1.0F..5400.0F
                binding.btnApplyTransfer.isEnabled = isNumberCard && isSumma

                if (binding.btnApplyTransfer.isEnabled){
                    binding.btnApplyTransfer.setBackgroundColor(0xFFDD6018.toInt())
                    binding.btnApplyTransfer.setTextColor(0xFFFFFFFF.toInt())
                    binding.btnApplyTransfer.setOnClickListener {
                        Toast.makeText(this, "Перевод успешно завершенно", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    binding.btnApplyTransfer.setTextColor(0xFF000000.toInt())
                    binding.btnApplyTransfer.setBackgroundColor(0xFFE0E0E0.toInt())
                }
            }



    }
}
