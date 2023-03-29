package com.lelha.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var inputUser: EditText?=null
    var inputPass: EditText?=null
    var textUser: TextView?=null
    var textPassword: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
    }

    private fun iniciarComponentes(){
        var btnSave: Button=findViewById(R.id.btnSave)
        btnSave.setOnClickListener{guardarDatos()}

        var btnCarry: Button=findViewById(R.id.btnCarry)
        btnCarry.setOnClickListener{cargarDatos()}

        inputUser=findViewById(R.id.user)
        inputPass=findViewById(R.id.password)
        textUser= findViewById(R.id.textUser)
        textPassword=findViewById(R.id.textPass)
    }

    private fun guardarDatos(){
        var preferences: SharedPreferences= getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var user:String = inputUser?.text.toString()
        var pass:String = inputPass?.text.toString()

        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",user)
        editor.putString("pass",pass)

        textUser?.text=user
        textPassword?.text=pass

        editor.commit()

        Toast.makeText(this,"se han registrado los datos", Toast.LENGTH_SHORT).show()
    }

    private fun cargarDatos(){

        var preferences: SharedPreferences= getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var user:String?=preferences.getString("user","no existe informacion")
        var pass:String?=preferences.getString("pass","no existe informacion")


        val intent = Intent(this,datos::class.java)
        val miBundle:Bundle =Bundle()

        miBundle.putString("Mensaje","Usuario: $user\nPassword: $pass")

        intent.putExtras(miBundle)
        startActivity(intent)
    }
}