package com.esielkar.calificame.utils

interface UniContract {

    interface Model {
        interface OnFinishedListener {
            fun onFinished(homescreenResponse: Any?)
            fun onFailure(t: Throwable?)
        }

        fun getUni(listener: OnFinishedListener?)
    }

    //Definir reglas del presentador
    interface Presenter {
        fun requestUni()
    }

    //Definimos las reglas de la vista

    //Definimos las reglas de la vista
    interface View {
        fun showUni(radio: UniResponse?)
        fun showError(t: Throwable?)
    }
}