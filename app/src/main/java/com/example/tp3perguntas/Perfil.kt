package com.example.tp3perguntas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_perfil.*

class Perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val soma:Int = intent.getIntExtra("soma",0)

        perfilInvestidor(soma)

    }

    private fun perfilInvestidor(soma:Int){
        if(soma <= 14)
            resultadoSoma.text = "Conservador"
        else
            if(soma in 14..35)
                resultadoSoma.text = "Moderado"
            else
                resultadoSoma.text = "Arrojado"

        valorSoma.text = soma.toString()

    }
}
