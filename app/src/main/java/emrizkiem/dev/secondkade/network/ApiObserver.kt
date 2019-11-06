package emrizkiem.dev.secondkade.network

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class ApiObserver<T> constructor(private val compositeDisposable: CompositeDisposable) : Observer<T> {
    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(value: T) {
        onApiSuccess(value)
    }

    override fun onError(e: Throwable) {
        onApiError(e)
    }

    abstract fun onApiSuccess(data: T)
    abstract fun onApiError(err: Throwable)
}