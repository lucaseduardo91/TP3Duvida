package com.example.tp3perguntas.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.tp3perguntas.Perfil

import com.example.tp3perguntas.R
import com.example.tp3perguntas.model.PerguntasViewModel
import kotlinx.android.synthetic.main.fragment_renda_mensal.*
import kotlinx.android.synthetic.main.fragment_valor_patrimonio.*

/**
 * A simple [Fragment] subclass.
 */
class ValorPatrimonio : Fragment() {

    private lateinit var perguntasViewModel: PerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_valor_patrimonio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var button = getView()!!.findViewById<Button>(R.id.btnNextValorPat)
        activity?.let { act ->
            perguntasViewModel = ViewModelProviders.of(act)
                .get(PerguntasViewModel::class.java)
        }
        setUpListeners(button)
    }

    private fun setUpListeners(btn: Button?){
        btn?.setOnClickListener{
            var radioOpcao = radioGroupValorPat.checkedRadioButtonId

            if(radioOpcao != -1)
            {
                if(radioValorPatA.isChecked)
                    perguntasViewModel.quest11 = "A"
                else
                    if(radioValorPatB.isChecked)
                        perguntasViewModel.quest11 = "B"
                    else
                        if(radioValorPatC.isChecked)
                            perguntasViewModel.quest11 = "C"
                        else
                            if(radioValorPatD.isChecked)
                                perguntasViewModel.quest11 = "D"
                            else
                                if(radioValorPatE.isChecked)
                                    perguntasViewModel.quest11 = "E"

                var pontos = calculaSoma()
                var i = Intent(getActivity(),Perfil::class.java)
                i.putExtra("soma",pontos)
                startActivity(i)
            }
        }
    }

    private fun calculaSoma() : Int
    {
        var soma :Int = 0

        when(perguntasViewModel.quest1){
            "B" -> soma += 2
            "C" -> soma += 3
            "D" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest2){
            "B" -> soma += 2
            "C" -> soma += 4
            "D" -> soma += 5
            else -> soma += 0
        }
        when(perguntasViewModel.quest3){
            "B" -> soma += 1
            "C" -> soma += 2
            "D" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest4){
            "B" -> soma += 2
            "C" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest5){
            "B" -> soma += 2
            "C" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest6){
            "B" -> soma += 2
            "C" -> soma += 3
            "D" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest7){
            "B" -> soma += 2
            "C" -> soma += 3
            "D" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest8){
            "A" -> soma += 1
            "B" -> soma += 2
            "C" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest9){
            "A" -> soma += 1
            "B" -> soma += 2
            "C" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest10){
            "B" -> soma += 1
            "C" -> soma += 2
            "D" -> soma += 4
            else -> soma += 0
        }
        when(perguntasViewModel.quest11){
            "B" -> soma += 1
            "C" -> soma += 2
            "D" -> soma += 4
            "E" -> soma += 5
            else -> soma += 0
        }
        return soma
    }
}
