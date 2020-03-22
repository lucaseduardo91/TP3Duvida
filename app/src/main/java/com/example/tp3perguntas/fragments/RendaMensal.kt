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
import kotlinx.android.synthetic.main.fragment_renda_mensal.*
import kotlinx.android.synthetic.main.fragment_volume_operacao.*

/**
 * A simple [Fragment] subclass.
 */
class RendaMensal : Fragment() {

    private lateinit var perguntasViewModel: PerguntasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_renda_mensal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var button = getView()!!.findViewById<Button>(R.id.btnNextRendaMensal)
        activity?.let { act ->
            perguntasViewModel = ViewModelProviders.of(act)
                .get(PerguntasViewModel::class.java)
        }
        setUpListeners(button)
    }

    private fun setUpListeners(btn: Button?){
        btn?.setOnClickListener{
            var radioOpcao = radioGroupRendaMensal.checkedRadioButtonId

            if(radioOpcao != -1)
            {
                if(radioRendaMensalA.isChecked)
                    perguntasViewModel.quest10 = "A"
                else
                    if(radioRendaMensalB.isChecked)
                        perguntasViewModel.quest10 = "B"
                    else
                        if(radioRendaMensalC.isChecked)
                            perguntasViewModel.quest10 = "C"
                        else
                            if(radioRendaMensalD.isChecked)
                                perguntasViewModel.quest10 = "D"

                findNavController().navigate(R.id.valorPatrimonio)
            }
        }
    }
}
