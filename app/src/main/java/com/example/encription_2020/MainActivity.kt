package com.example.encription_2020

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.view.View as View


const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var anta: MyMethods? = null

    fun codificar(view: View) {
      anta = MyMethods()
        val texto: String
        val llave: String
        val mensajecod: String

        //Recepcion del texto y llave
        val editllave = findViewById<EditText>(R.id.editllave)
        val edittexto = findViewById<EditText>(R.id.edittexto)
        texto = edittexto.text.toString()
        llave = editllave.text.toString()

        // Envio de parametros para su codificacion
        mensajecod = anta!!.codifica(texto, llave)

        //Compartir mensaje
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, mensajecod)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
        // Envio de mensaje codificado para su despliegue en la nueva actividad
      //  val intent = Intent(this, DisplayMessageActivity::class.java).apply {
        //    putExtra(EXTRA_MESSAGE, mensajecod)
        //}
        startActivity(intent)

    }

    fun decodificar(view: View) {

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



        //Share
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, mensajedecod)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
        // Envio de mensaje decodificado para su despliegue en la nueva actividad
      //  val intent = Intent(this, DisplayMessageActivity::class.java).apply {
        //    putExtra(EXTRA_MESSAGE, mensajedecod)
        //}
        startActivity(intent)

    }

       fun compartir(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }
}
