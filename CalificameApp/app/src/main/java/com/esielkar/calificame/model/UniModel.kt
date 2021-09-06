package com.esielkar.calificame.model

import android.util.Log
import com.esielkar.calificame.api.ApiUtils
import com.esielkar.calificame.contract.UniContract
import com.esielkar.calificame.objects.UniResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UniModel : UniContract.Model {
    var TAG = "UniModel"
    override fun getUni(listener: UniContract.Model.OnFinishedListener?) {
        ApiUtils.api.getUni()
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
            })
    }
}