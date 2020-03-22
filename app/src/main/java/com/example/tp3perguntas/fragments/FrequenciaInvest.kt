package com.example.tp3perguntas.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.tp3perguntas.R
import com.example.tp3perguntas.model.PerguntasViewModel
import kotlinx.android.synthetic.main.fragment_aplicacoes_rendimentos.*
import kotlinx.android.synthetic.main.fragment_frequencia_invest.*

/**
 * A simple [Fragment] subclass.
 */
class FrequenciaInvest : Fragment() {

    private lateinit var perguntasViewModel: PerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frequencia_invest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var button = getView()!!.findViewById<Button>(R.id.btnFreqInv)
        activity?.let { act ->
            perguntasViewModel = ViewModelProviders.of(act)
                .get(PerguntasViewModel::class.java)
        }
        setUpListeners(button)
    }

    private fun setUpListeners(btn: Button?){
        btn?.setOnClickListener{
            var radioOpcao = radioGroupFreqInv.checkedRadioButtonId

            if(radioOpcao != -1)
            {
                if(radioFreqInvA.isChecked)
                    perguntasViewModel.quest8 = "A"
                else
                    if(radioFreqInvB.isChecked)
                        perguntasViewModel.quest8 = "B"
                    else
                        if(radioFreqInvC.isChecked)
                            perguntasViewModel.quest8 = "C"

                findNavController().navigate(R.id.volumeOperacao)
            }
        }
    }
}
