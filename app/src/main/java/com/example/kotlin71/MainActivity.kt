package com.example.kotlin71

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private val CODE: Int = 100
    private lateinit var sendMsg: String
    private var name: String = "Пожалуйста, заполните поле"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        actionClick()
    }

    private fun actionClick() {
        button.setOnClickListener {
            sendMsg = editText.text.toString().trim()
            if (sendMsg.trim().isNotEmpty()) {
                val intent = Intent(this@MainActivity, SeconActivity::class.java)
                intent.putExtra("key", sendMsg)
                startActivityForResult(intent, CODE)
            } else {
                showToast(name)
            }

        }
    }

    private fun initView() {
        button = findViewById(R.id.button)
        editText = findViewById(R.id.Edit_text)
    }

    private fun showToast(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == CODE && data != null) {
            val getMsg = data.getStringExtra("key")
            if (sendMsg.equals(getMsg)) {
                showToast("старые данные")
            } else {
                showToast("данные изменились c $sendMsg на $getMsg")
            }
        }
    }

}
