package com.example.lenguajesautomatas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_operaciones.*

class operaciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operaciones)

        var datosUno = ""
        var datosDos = ""

        var ArrayValoresU = ArrayList<String>()
        var ArrayValoresD = ArrayList<String>()

        val objetoExtra: Intent = intent
        var valoresLenguaje1 = objetoExtra.getStringExtra("lenguajeUno")
        var valoresLenguaje2 = objetoExtra.getStringExtra("lenguajeDos")

        var universoLenguajes = ArrayList<String>(valoresLenguaje1.split(",") + valoresLenguaje2.split(",")).distinct()

        var lenguajeUno = ArrayList<String>(valoresLenguaje1.split(","))
        var lenguajeDos = ArrayList<String>(valoresLenguaje2.split(","))

        union.setOnClickListener() {
            resultadoOperacion1.setText("")
            resultadoOperacion2.setText("")

            var unionLenguaje2 =
                ArrayList<String>(valoresLenguaje2.split(",") + valoresLenguaje1.split(",")).distinct()

            for (i in universoLenguajes.indices) {
                resultadoOperacion1.append(universoLenguajes[i] + ",")
                resultadoOperacion2.append(unionLenguaje2[i] + ",")
            }
        }

        universo.setOnClickListener() {
            resultadoOperacion1.setText("")
            resultadoOperacion2.setText("")

            for (i in universoLenguajes.indices) {
                resultadoOperacion1.append(universoLenguajes[i] + ",")
                resultadoOperacion2.append(universoLenguajes[i] + ",")
            }
        }

        interseccion.setOnClickListener() {
            resultadoOperacion1.setText("")
            resultadoOperacion2.setText("")

            for (i in lenguajeUno.indices) {
                for (j in lenguajeDos.indices ) {
                    if (lenguajeUno[i] == lenguajeDos[j]) {
                        resultadoOperacion1.append(lenguajeUno[i] + ",")
                    }
                }
            }

            for (i in lenguajeDos.indices) {
                for (j in lenguajeUno.indices) {
                    if (lenguajeDos[i] == lenguajeUno[j]) {
                        resultadoOperacion2.append(lenguajeDos[i] + ",")
                    }
                }
            }
        }

        diferencia.setOnClickListener() {
            resultadoOperacion1.setText("")
            resultadoOperacion2.setText("")

            var datos = ""
            for (i in lenguajeUno.indices) {
                var datoComparar = lenguajeUno[i]
                if (lenguajeDos.contains(datoComparar) == false) {
                    datos = lenguajeUno[i] + ","
                    datosUno = lenguajeUno[i]
                    resultadoOperacion1.append(datos)
                }
            }

            for (i in lenguajeDos.indices) {
                var datoComparar = lenguajeDos[i]
                if (lenguajeUno.contains(datoComparar) == false) {
                    datos = lenguajeDos[i] + ","
                    datosDos = lenguajeDos[i]
                    resultadoOperacion2.append(datos)
                }
            }
        }

        diferenciaSimetrica.setOnClickListener() {
            resultadoOperacion1.setText("")
            resultadoOperacion2.setText("")

            for (i in lenguajeUno.indices) {
                var datoComparar = lenguajeUno[i]
                if (lenguajeDos.contains(datoComparar) == false) {
                    ArrayValoresU.add(lenguajeUno[i])
                }
            }

            for (i in lenguajeDos.indices) {
                var datoComparar = lenguajeDos[i]
                if (lenguajeUno.contains(datoComparar) == false) {
                    ArrayValoresD.add(lenguajeDos[i])
                }
            }

            var Array1 = ArrayList<String>(ArrayValoresU + ArrayValoresD).distinct()
            var Array2 = ArrayList<String>(ArrayValoresD + ArrayValoresU).distinct()

            for (i in Array1.indices) {
                resultadoOperacion1.append(Array1[i] + ",")
                resultadoOperacion2.append(Array2[i] + ",")
            }
        }

        complementoButton.setOnClickListener() {
            resultadoOperacion1.setText("")
            resultadoOperacion2.setText("")

            var complementoUno = ArrayList<String>(universoLenguajes)
            var complementoDos = ArrayList<String>(universoLenguajes)

            for (i in lenguajeUno.indices) {
                if (universoLenguajes.contains(lenguajeUno[i])) {
                    var dato = lenguajeUno[i]
                        complementoUno.remove(dato)
                }
            }

            for (i in lenguajeDos.indices) {
                if (universoLenguajes.contains(lenguajeDos[i])) {
                    var dato = lenguajeDos[i]
                    complementoDos.remove(dato)
                }
            }

            for (i in complementoUno.indices){
                resultadoOperacion1.append(complementoUno[i] + ",")
            }

            for (i in complementoDos.indices){
                resultadoOperacion2.append(complementoDos[i] + ",")
            }
        }

        multiplicacion.setOnClickListener() {
            for (i in lenguajeUno.indices) {
                for (j in lenguajeDos.indices) {
                    resultadoOperacion1.append(lenguajeUno[i] + lenguajeDos[j] + ",")
                }
            }
            for (i in lenguajeDos.indices) {
                for (j in lenguajeUno.indices) {
                    resultadoOperacion2.append(lenguajeDos[i] + lenguajeUno[j] + ",")
                }
            }
        }
            cerraduras.setOnClickListener(){
                val activityC = Intent(this, cerradurasActivity::class.java)
                activityC.putStringArrayListExtra("lenguajeUno", lenguajeUno)
                activityC.putStringArrayListExtra("lenguajeDos", lenguajeDos)
                startActivity(activityC)

                Toast.makeText(this,"Realize las cerraduras", Toast.LENGTH_SHORT).show()
            }
        }

    }

