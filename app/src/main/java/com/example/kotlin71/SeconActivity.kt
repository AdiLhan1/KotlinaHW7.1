package com.example.kotlin71

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SeconActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon)
        initView()
        setResultIntent()
    }
    private fun initView(){
        editText=findViewById(R.id.editText)
    }

    private fun setResultIntent() {
        val text: String = intent.getStringExtra("key")
        editText.setText(text)
    }

    fun onClickBtn(view: View) {
        var msg:String=editText.text.toString().trim()
        if (msg.trim().isNotEmpty()){
            val intent = Intent().apply {
                putExtra("key", msg)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }else{
            showToast()
        }
    }
    private fun showToast(){
        Toast.makeText(this,"Пожалуйста заполните поле",Toast.LENGTH_LONG).show()
    }
}
