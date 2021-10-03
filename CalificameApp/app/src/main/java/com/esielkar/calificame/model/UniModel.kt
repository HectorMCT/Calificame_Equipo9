package com.esielkar.calificame.model

import com.esielkar.calificame.utils.UniContract

class UniModel : UniContract.Model {
    var TAG = "UniModel"
    override fun getUni(listener: UniContract.Model.OnFinishedListener?) {
        /*ApiUtils.api.getUni()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<UniResponse> {
                override fun onSubscribe(d: Disposable) {}
                override fun onNext(homescreenResponse: UniResponse) {
                    Log.d(TAG, "onNext: " + homescreenResponse.uniList)
                    listener?.onFinished(homescreenResponse)
                }

                override fun onError(t: Throwable) {
                    listener?.onFailure(t)
                    Log.e(TAG, "onError: ", t)
                }

                override fun onComplete() {}
            })*/
    }
}