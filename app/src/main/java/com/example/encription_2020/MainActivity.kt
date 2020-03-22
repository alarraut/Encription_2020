package com.example.encription_2020

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
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
        var myClipboard: ClipboardManager? = null
        var myClip: ClipData? = null
       // val intent = Intent(this, DisplayMessageActivity::class.java)

        //Recepcion del texto y llave

        val editllave = findViewById<EditText>(R.id.editllave)
        val edittexto = findViewById<EditText>(R.id.edittexto)
        texto = edittexto.text.toString()
        llave = editllave.text.toString()

        // Envio de parametros para su codificacion
        mensajecod = anta!!.codifica(texto, llave)

        // Se copia mensaje codificado al portapapeles
        myClipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?;
        myClip = ClipData.newPlainText("text", mensajecod);
        myClipboard?.setPrimaryClip(myClip);

        Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();

        // Envio de mensaje codificado para su despliegue en la nueva actividad
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensajecod)
        }
        startActivity(intent)

    }

    fun decodificar(view: View?) {

       anta = MyMethods()
        val texto: String
        val llave: String
        val mensajedecod: String
        var myClipboard: ClipboardManager? = null
        var myClip: ClipData? = null

        //Recepcion del texto y llave
        val editllave = findViewById<EditText>(R.id.editllave)
        val edittexto = findViewById<EditText>(R.id.edittexto)
        texto = edittexto.text.toString()
        llave = editllave.text.toString()

        // Envio de parametros para su decodificacion
        mensajedecod = anta!!.decodifica(texto, llave)

        // Se copia mensaje codificado al portapapeles
        myClipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?;
        myClip = ClipData.newPlainText("text", mensajedecod);
        myClipboard?.setPrimaryClip(myClip)

        // Envio de mensaje decodificado para su despliegue en la nueva actividad
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensajedecod)
        }
        startActivity(intent)

    }






}
