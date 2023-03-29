package com.lelha.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class datos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        val fact:TextView =findViewById(R.id.textInfo)

        var miBundle: Bundle? = this.intent.extras

        if (miBundle!=null){
            fact!!.text="${miBundle.getString("Mensaje")}"
        }else{
            fact!!.text="No hay informacion"
        }
        val btnBack: Button=findViewById(R.id.btnBack)
        btnBack.setOnClickListener{onClick()}
    }

    private fun onClick() {
        finish()
    }
}