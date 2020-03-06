package com.example.lenguajesautomatas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cerraduras.*
import kotlinx.android.synthetic.main.activity_operaciones.*

class cerradurasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerraduras)

        val objExtra: Intent = intent
        var lenguajeUno = objExtra.getStringArrayListExtra("lenguajeUno")
        var lenguajeDos = objExtra.getStringArrayListExtra("lenguajeDos")

        kleene.setOnClickListener(){

            resultadoCerradura1.setText("")
            resultadoCerradura2.setText("")

            var segundaIteracion = ArrayList<String>()
                var terceraIteracion = ArrayList<String>()

            for (i in lenguajeUno.indices) {
                for (j in lenguajeUno.indices) {
                    segundaIteracion.add(lenguajeUno[j] + lenguajeUno[i])
                }
            }
            for (i in lenguajeUno.indices) {
                for (j in segundaIteracion.indices){
                    terceraIteracion.add(segundaIteracion[j] + lenguajeUno[i])
                }
            }

            var kleeneUno = ArrayList<String>(lenguajeUno + segundaIteracion + terceraIteracion)
            resultadoCerradura1.append("E,")

            for (i in kleeneUno.indices){
                resultadoCerradura1.append(kleeneUno[i] + ",")
            }

            //Lenguaje 2

            var segundaIteracionD = ArrayList<String>()
            var terceraIteracionD = ArrayList<String>()

            for (i in lenguajeDos.indices) {
                for (j in lenguajeDos.indices) {
                    segundaIteracionD.add(lenguajeDos[j] + lenguajeDos[i])
                }
            }
            for (i in lenguajeDos.indices) {
                for (j in segundaIteracionD.indices){
                    terceraIteracionD.add(segundaIteracionD[j] + lenguajeDos[i])
                }
            }

            var kleeneDos = ArrayList<String>(lenguajeDos + segundaIteracionD + terceraIteracionD)
            resultadoCerradura2.append("E,")

            for (i in kleeneUno.indices){
                resultadoCerradura2.append(kleeneDos[i] + ",")
            }
        }

        positiva.setOnClickListener(){

            resultadoCerradura1.setText("")
            resultadoCerradura2.setText("")

            var segundaIteracion = ArrayList<String>()
            var terceraIteracion = ArrayList<String>()

            for (i in lenguajeUno.indices) {
                for (j in lenguajeUno.indices) {
                    segundaIteracion.add(lenguajeUno[j] + lenguajeUno[i])
                }
            }
            for (i in lenguajeUno.indices) {
                for (j in segundaIteracion.indices){
                    terceraIteracion.add(segundaIteracion[j] + lenguajeUno[i])
                }
            }

            var positivaUno = ArrayList<String>(segundaIteracion + terceraIteracion)

            for (i in positivaUno.indices){
                resultadoCerradura1.append(positivaUno[i] + ",")
            }

            //Lenguaje 2

            var segundaIteracionD = ArrayList<String>()
            var terceraIteracionD = ArrayList<String>()

            for (i in lenguajeDos.indices) {
                for (j in lenguajeDos.indices) {
                    segundaIteracionD.add(lenguajeDos[j] + lenguajeDos[i])
                }
            }
            for (i in lenguajeDos.indices) {
                for (j in segundaIteracionD.indices){
                    terceraIteracionD.add(segundaIteracionD[j] + lenguajeDos[i])
                }
            }

            var positivaDos = ArrayList<String>(lenguajeDos + segundaIteracionD + terceraIteracionD)
            for (i in positivaDos.indices){
                resultadoCerradura2.append(positivaDos[i] + ",")
            }
        }
    }
}
