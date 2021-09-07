package com.esielkar.calificame.presenter

import com.esielkar.calificame.contract.UniContract
import com.esielkar.calificame.model.UniModel
import com.esielkar.calificame.objects.UniResponse

class UniPresenter : UniContract.Presenter, UniContract.Model.OnFinishedListener {
    private var uniView: UniContract.View? = null
    private var uniModel: UniContract.Model? = null

    constructor(uniView: UniContract.View?) {
        this.uniView = uniView
        uniModel = UniModel()
    }
    override fun requestUni() {
        uniModel?.getUni(this)
    }

    override fun onFinished(data: Any?) {
        if (data is UniResponse) {
            this.uniView?.showUni(data as UniResponse?)
        }
    }

    override fun onFailure(t: Throwable?) {
        uniView?.showError(t)
    }


}