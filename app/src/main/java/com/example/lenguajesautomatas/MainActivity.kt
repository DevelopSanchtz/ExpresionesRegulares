package com.example.lenguajesautomatas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuOperaciones.setOnClickListener () {

            var valoresLenguajeUno = lenguaje1.text.toString()
                    var valoresLenguajeDos = lenguaje2.text.toString()


            var ActivityOperacion = Intent (this, operaciones::class.java)
            ActivityOperacion.putExtra("lenguajeUno",valoresLenguajeUno)
            ActivityOperacion.putExtra("lenguajeDos",valoresLenguajeDos)
            startActivity(ActivityOperacion)

                Toast.makeText(this, "Eliga que operación realizar", Toast.LENGTH_SHORT).show()
        }
    }
}
