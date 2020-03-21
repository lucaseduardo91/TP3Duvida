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
import kotlinx.android.synthetic.main.fragment_experiencia_formacao.*
import kotlinx.android.synthetic.main.fragment_tempo_investido.*

/**
 * A simple [Fragment] subclass.
 */
class ExperienciaFormacao : Fragment() {

    private lateinit var perguntasViewModel: PerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experiencia_formacao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { act ->
            perguntasViewModel = ViewModelProviders.of(act)
                .get(PerguntasViewModel::class.java)
        }

        btnNextTempInvest.setOnClickListener{
            setUpListeners()
        }
    }

    private fun setUpListeners(){

            var radioOpcao = radioGroupXPFor.checkedRadioButtonId

            if(radioOpcao != -1)
            {
                if(radioXpForA.isChecked)
                    perguntasViewModel.quest3 = "A"
                else
                    if(radioXpForB.isChecked)
                        perguntasViewModel.quest3 = "B"
                    else
                        if(radioXpForC.isChecked)
                            perguntasViewModel.quest3 = "C"
                        else
                            if(radioXpForD.isChecked)
                                perguntasViewModel.quest3 = "D"
                findNavController().navigate(R.id.reservaPorcentagem)
            }

    }
}
