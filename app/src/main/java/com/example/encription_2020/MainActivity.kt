package com.example.encription_2020

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var anta: MyMethods? = null

    fun codificar(view: View?) {
      anta = MyMethods()
        val texto: String
        val llave: String
        val mensajecod: String
       // val intent = Intent(this, DisplayMessageActivity::class.java)

        //Recepcion del texto y llave

        val editllave = findViewById<EditText>(R.id.editllave)
        val edittexto = findViewById<EditText>(R.id.edittexto)
        texto = edittexto.text.toString()
        llave = editllave.text.toString()

        // Envio de parametros para su codificacion
        //mensajecod = anta!!.codifica(texto, llave)

        // Se copia mensaje codificado al portapapeles
      //  val clipboard =
        //    ContextCompat.getSystemService<Any>(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        //val clip = ClipData.newPlainText("simple text", mensajecod)
        //clipboard!!.setPrimaryClip(clip)

        // Envio de mensaje codificado para su despliegue en la nueva actividad
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, texto)
        }
        startActivity(intent)

    }

    fun decodificar(view: View?) {

       anta = MyMethods()
        val texto: String
        val llave: String
        val mensajedecod: String


        //Recepcion del texto y llave
        val editllave = findViewById<EditText>(R.id.editllave)
        val edittexto = findViewById<EditText>(R.id.edittexto)
        texto = edittexto.text.toString()
        llave = editllave.text.toString()

        // Envio de parametros para su decodificacion
        mensajedecod = anta!!.decodifica(texto, llave)

        // Se copia mensaje codificado al portapapeles
       // val clipboard: ClipboardManager? = ContextCompat.getSystemService<Any>(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        //val clip = ClipData.newPlainText("simple text", mensajedecod)
        //clipboard!!.setPrimaryClip(clip)

        // Envio de mensaje decodificado para su despliegue en la nueva actividad
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensajedecod)
        }
        startActivity(intent)

    }






}
