package com.example.tp3perguntas.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.tp3perguntas.R
import com.example.tp3perguntas.model.PerguntasViewModel
import kotlinx.android.synthetic.main.fragment_aplicacoes_queda.*
import kotlinx.android.synthetic.main.fragment_tempo_investido.*

/**
 * A simple [Fragment] subclass.
 */
class AplicacoesQueda : Fragment() {

    private lateinit var perguntasViewModel: PerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aplicacoes_queda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { act ->
            perguntasViewModel = ViewModelProviders.of(act)
                .get(PerguntasViewModel::class.java)
        }
        setUpListeners()
    }

    private fun setUpListeners(){
        btnNextTempInvest.setOnClickListener{
            var radioOpcao = radioGroupAplQueda.checkedRadioButtonId

            if(radioOpcao != -1)
            {
                if(radioAplQuedaA.isChecked)
                    perguntasViewModel.quest5 = "A"
                else
                    if(radioAplQuedaB.isChecked)
                        perguntasViewModel.quest5 = "B"
                    else
                        if(radioAplQuedaC.isChecked)
                            perguntasViewModel.quest5 = "C"

                findNavController().navigate(R.id.patrimonioDistribuido)
            }
        }
    }
}
