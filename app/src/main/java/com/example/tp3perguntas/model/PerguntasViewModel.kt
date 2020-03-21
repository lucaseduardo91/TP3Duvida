package com.example.tp3perguntas.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerguntasViewModel: ViewModel(){
    var pontos = MutableLiveData<Int>().apply { value = 0 }
    var soma = 0
    var quest1 : String? = null
    var quest2 : String? = null
    var quest3 : String? = null
    var quest4 : String? = null
    var quest5 : String? = null
    var quest6 : String? = null
    var quest7 : String? = null
    var quest8 : String? = null
    var quest9 : String? = null
    var quest10 : String? = null
    var quest11 : String? = null

}