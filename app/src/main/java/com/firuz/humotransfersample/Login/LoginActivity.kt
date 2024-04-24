package com.firuz.humotransfersample.Login

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.firuz.humotransfersample.R
import com.firuz.humotransfersample.mainScreen.MainActivity
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    private var loginPhonenumber: EditText? = null
    private var loginCheckbox: CheckBox? = null
    private var loginContinueButton: Button? = null
    private var loginTextClose: CardView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        loginPhonenumber = findViewById<EditText>(R.id.login_register_phone_number)
        loginCheckbox = findViewById(R.id.login_checkbox)
        loginContinueButton = findViewById(R.id.login_continue_button)
        loginTextClose = findViewById(R.id.login_close_text)

        loginPhonenumber?.doAfterTextChanged() {s: Editable? ->

            val phoneNumber = s?.toString()
            if(phoneNumber?.length == 9 ){
                if (loginCheckbox?.isChecked == true ) {
                        loginContinueButton?.setOnClickListener {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
            val activity: LoginActivity = LoginActivity()

            loginTextClose?.setOnClickListener{
                finish()
                System.out.close()
            }

        }




    }
}